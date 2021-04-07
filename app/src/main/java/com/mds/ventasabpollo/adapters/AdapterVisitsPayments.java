package com.mds.ventasabpollo.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.activities.FinalReportActivity;
import com.mds.ventasabpollo.activities.PayOffActivity;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.models.Clients;
import com.mds.ventasabpollo.models.VisitsPayments;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class AdapterVisitsPayments extends RecyclerView.Adapter<AdapterVisitsPayments.VisitsPaymentsHolder>{
        //implements View.OnClickListener{

    private Context context;
    private Realm realm;
    int nUser;
    double difference = 0.0;
    //private View.OnClickListener listener;

    private List<VisitsPayments> visitsList;

    public AdapterVisitsPayments(Context context, List<VisitsPayments> visitsList) {
        this.context = context;
        this.visitsList = visitsList;
    }

    @Override
    public VisitsPaymentsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_visits_payments, parent, false);
        //view.setOnClickListener(this);
        return new VisitsPaymentsHolder(view);
    }

    @Override
    public void onBindViewHolder(final VisitsPaymentsHolder holder, final int position) {
        final BaseApp baseApp = new BaseApp(context);
        final FunctionsApp functionsapp = new FunctionsApp(context);
        final SPClass spClass = new SPClass(context);

        realm = Realm.getDefaultInstance();
        nUser = spClass.intGetSP("user");

        /*if (context instanceof FinalReportActivity) {
            holder.txtViewTotal.setVisibility(View.VISIBLE);
            RealmResults<ListClients> clients = realm.where(ListClients.class).equalTo("cliente", visitsList.get(position).getCliente()).findAll();

            if(clients.size() > 0){
                holder.txtViewClient.setText(clients.get(0).getNombre_cliente());
            }
        }else{
            holder.txtViewTotal.setVisibility(View.GONE);
        }*/

        holder.txtViewTotal.setVisibility(View.VISIBLE);
        RealmResults<Clients> clients = realm.where(Clients.class)
                .equalTo("cliente", visitsList.get(position)
                        .getCliente())
                .findAll();

        if(clients.size() > 0){
            holder.txtViewClient.setText(clients.get(0).getNombre_cliente());
        }

        holder.txtViewTotal.setText("Venta total: $" + baseApp.formattedNumber(visitsList.get(position).getImporte()));

        if(visitsList.get(position).getImporte_saldado() != 0){
            holder.txtViewTotalPayed.setVisibility(View.VISIBLE);
            holder.txtViewTotalDifference.setVisibility(View.VISIBLE);

            holder.txtViewTotalPayed.setText("Abono: $" + baseApp.formattedNumber(visitsList.get(position).getImporte_saldado()));
            holder.txtViewTotalDifference.setText("Restante: $" + baseApp.formattedNumber(( visitsList.get(position).getImporte() - visitsList.get(position).getImporte_saldado())));
        }else{
            holder.txtViewTotalPayed.setVisibility(View.GONE);
            holder.txtViewTotalDifference.setVisibility(View.GONE);
        }

        if(visitsList.get(position).getMetodo_pago() == null){
            holder.txtViewType.setText("Sin método de pago");
        }else {
            holder.txtViewType.setText(visitsList.get(position).getMetodo_pago());
        }

        if(visitsList.get(position).getFecha() == null){
            holder.txtViewDate.setText("Sin fecha");
        }else {
            holder.txtViewDate.setText(baseApp.dateFormat(baseApp.convertDate(visitsList.get(position).getFecha())));
        }

        holder.btnPayOff.setOnClickListener(v -> {
            if (context instanceof PayOffActivity) {
                //if (!visitsList.get(position).isCobrado()) {
                    askPayOff(position);
                //}
            }
        });

        if (visitsList.get(position).isCobrado()) {
            //holder.btnPayOff.setText("Saldada");
        }else{
            if (context instanceof FinalReportActivity) {
                holder.btnPayOff.setText("Sin saldar");
            }
        }

        if(visitsList.get(position).isCobrado()){
            holder.txtInfo.setVisibility(View.VISIBLE);
        }else{
            holder.txtInfo.setVisibility(View.GONE);
        }

        if(visitsList.get(position).isEnviado()){
            holder.btnPayOff.setVisibility(View.GONE);
        }else{
            holder.btnPayOff.setVisibility(View.VISIBLE);
        }
    }

    public void askPayOff(final int position){
        new AlertDialog.Builder(context)
                .setMessage("¿Estás seguro que quieres saldar esta deuda?")
                .setCancelable(true)
                .setPositiveButton("Sí", (dialog, id) -> payOff(position))
                .setNegativeButton("No", null)
                .show();
    }

    public void payOff(int position){
        SPClass spClass = new SPClass(context);
        BaseApp baseApp = new BaseApp(context);
        FunctionsApp functionsapp = new FunctionsApp(context);
        int idRoute;

        View popupInputDialogView;
        AlertDialog alert;

        TextView txtTotalPayed;
        EditText editTxtTotal;
        Button btnDialogSave, btnDialogCancel;
        LinearLayout layoutPayed;

        try {
            realm = Realm.getDefaultInstance();
            idRoute = spClass.intGetSP("idRoute");

            alert = new AlertDialog.Builder(context).create();
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            popupInputDialogView = layoutInflater.inflate(R.layout.dialog_payoff, null);

            layoutPayed = popupInputDialogView.findViewById(R.id.layoutPayed);

            btnDialogSave = popupInputDialogView.findViewById(R.id.btnDialogSave);
            btnDialogCancel = popupInputDialogView.findViewById(R.id.btnDialogCancel);

            txtTotalPayed = popupInputDialogView.findViewById(R.id.txtTotalPayed);
            editTxtTotal = popupInputDialogView.findViewById(R.id.editTxtTotal);

            editTxtTotal.setSelectAllOnFocus(true);

            if(visitsList.get(position).isCobrado()){
                difference = visitsList.get(position).getImporte() - visitsList.get(position).getImporte_saldado();

                editTxtTotal.setHint(Double.toString(difference));
                editTxtTotal.setText(Double.toString(difference));

                txtTotalPayed.setText(String.valueOf(visitsList.get(position).getImporte_saldado()));

                layoutPayed.setVisibility(View.VISIBLE);
            }else{
                editTxtTotal.setHint(Double.toString(visitsList.get(position).getImporte()));
                editTxtTotal.setText(Double.toString(visitsList.get(position).getImporte()));

                txtTotalPayed.setText(String.valueOf(visitsList.get(position).getImporte_saldado()));

                layoutPayed.setVisibility(View.GONE);
            }

            alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            alert.setView(popupInputDialogView);

            alert.show();

            btnDialogSave.setOnClickListener(v -> {
                if (editTxtTotal.getText().toString().length() == 0) {
                    baseApp.showToast("Escribe un total válido.");
                } else if (
                        (visitsList.get(position).isCobrado() && Double.parseDouble(editTxtTotal.getText().toString()) > difference) ||
                        (!visitsList.get(position).isCobrado() && Double.parseDouble(editTxtTotal.getText().toString()) > visitsList.get(position).getImporte())) {
                    baseApp.showToast("El dinero recibido no puede ser mayor al total de la venta.");
                } else {
                    if (visitsList.get(position).getPago() != 0) {
                        RealmResults<VisitsPayments> visitsPayments = realm.where(VisitsPayments.class)
                                .equalTo("pago", visitsList.get(position).getPago()).findAll();

                        if (visitsPayments.size() > 0) {
                            realm.beginTransaction();
                            for (VisitsPayments visitsPayments1 : visitsPayments) {

                                if(visitsList.get(position).isCobrado()){
                                    visitsPayments1.setImporte_saldado(visitsList.get(position).getImporte_saldado() + Double.parseDouble(editTxtTotal.getText().toString()));
                                }else{
                                    visitsPayments1.setImporte_saldado(Double.parseDouble(editTxtTotal.getText().toString()));
                                }

                                visitsPayments1.setCobrado(true);
                                visitsPayments1.setFecha_cobrado(baseApp.getCurrentDateFormated());
                                visitsPayments1.setRuta(idRoute);
                            }

                            realm.commitTransaction();

                            baseApp.showToast("Marcado como cobrado con éxito");
                            alert.cancel();
                        }
                    } else {
                        RealmResults<VisitsPayments> visitsPayments = realm.where(VisitsPayments.class)
                                .equalTo("visita", visitsList.get(position).getVisita()).findAll();

                        if (visitsPayments.size() > 0) {
                            realm.beginTransaction();
                            for (VisitsPayments visitsPayments1 : visitsPayments) {
                                if(visitsList.get(position).isCobrado()){
                                    visitsPayments1.setImporte_saldado(visitsList.get(position).getImporte_saldado() + Double.parseDouble(editTxtTotal.getText().toString()));
                                }else{
                                    visitsPayments1.setImporte_saldado(Double.parseDouble(editTxtTotal.getText().toString()));
                                }

                                visitsPayments1.setCobrado(true);
                                visitsPayments1.setFecha_cobrado(baseApp.getCurrentDateFormated());
                                visitsPayments1.setRuta(idRoute);
                            }
                            realm.commitTransaction();

                            baseApp.showToast("Marcado como cobrado con éxito");
                            alert.cancel();
                        }
                    }

                    if(spClass.boolGetSP("onlineConnection")){
                        if (context instanceof PayOffActivity) {
                            ((PayOffActivity) context).backgroundProcess("backgroundProcess");
                            alert.dismiss();
                        }
                    }else{
                        ((PayOffActivity) context).getVisits();
                    }
                }
            });

            btnDialogCancel.setOnClickListener(view -> {
                alert.cancel();
                //closeKeyboard();
            });

        }catch (Exception ex){
            baseApp.showAlert("Error", "Ocurrió un error al realizar el pago, repórtalo al dpto de Sistemas: " + ex);
            realm.close();
        }
    }

    @Override
    public int getItemCount() {
        return visitsList.size();
    }

    /*public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }
*/

    public class VisitsPaymentsHolder extends RecyclerView.ViewHolder {

        TextView txtViewClient, txtViewTotal, txtViewTotalDifference, txtViewTotalPayed, txtViewType, txtViewDate, txtInfo;
        Button btnPayOff;

        public VisitsPaymentsHolder(View itemView) {
            super(itemView);

            txtViewClient = itemView.findViewById(R.id.txtViewClient);
            txtViewTotal = itemView.findViewById(R.id.txtViewTotal);
            txtViewType = itemView.findViewById(R.id.txtViewType);
            txtViewTotalPayed = itemView.findViewById(R.id.txtViewTotalPayed);
            txtViewTotalDifference = itemView.findViewById(R.id.txtViewTotalDifference);
            txtViewDate = itemView.findViewById(R.id.txtViewDate);
            txtInfo = itemView.findViewById(R.id.txtInfo);

            btnPayOff = itemView.findViewById(R.id.btnPayOff);
        }
    }
}