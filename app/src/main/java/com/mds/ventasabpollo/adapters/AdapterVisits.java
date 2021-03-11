package com.mds.ventasabpollo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.activities.VisitsActivity;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.models.Clients;
import com.mds.ventasabpollo.models.Lists;
import com.mds.ventasabpollo.models.VisitsClients;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class AdapterVisits extends RecyclerView.Adapter<AdapterVisits.VisitsViewHolder>{
        //implements View.OnClickListener{

    private Context context;
    private Realm realm;
    int nUser;
    //private View.OnClickListener listener;

    private List<VisitsClients> visitsList;

    public AdapterVisits(Context context, List<VisitsClients> visitsList) {
        this.context = context;
        this.visitsList = visitsList;
    }

    @Override
    public VisitsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_visits, parent, false);
        //view.setOnClickListener(this);
        return new VisitsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final VisitsViewHolder holder, final int position) {
        final BaseApp baseApp = new BaseApp(context);
        final FunctionsApp functionsapp = new FunctionsApp(context);
        final SPClass spClass = new SPClass(context);

        realm = Realm.getDefaultInstance();
        nUser = spClass.intGetSP("user");

        RealmResults<Lists> lists = null;
        RealmResults<Clients> clients = null;

        /*if(functionsapp.countDetailsOrderVisit(visitsList.get(position).getId(), 2) > 0){
            holder.btnViewOrder.setVisibility(View.VISIBLE);
        }else{
            holder.btnViewOrder.setVisibility(View.INVISIBLE);
        }*/

        try{
            if(visitsList.get(position).getLista() != 0) {
                lists = realm.where(Lists.class).equalTo("lista", visitsList.get(position).getLista()).equalTo("user_id", nUser).findAll();
                holder.txtList.setText(lists.get(0).getNombre_lista());
            }
        }catch (Exception ex){

        }

        if(visitsList.get(position).getCliente() != 0) {
            clients = realm.where(Clients.class).equalTo("cliente", visitsList.get(position).getCliente()).equalTo("user_id", nUser).findAll();

            if(clients.size() > 0){
                holder.txtClientName.setText(clients.get(0).getNombre_cliente());
                holder.txtBussinessName.setText(clients.get(0).getNombre_comercial());
            }else{
                holder.txtClientName.setText("Sin nombre");
                holder.txtBussinessName.setText("Sin empresa");
            }
        }

        if(visitsList.get(position).getFecha_visita_fin() == null){
            holder.txtStatus.setText("Status: Aún sin terminar");
        }else{
            holder.txtStatus.setText("Status: Terminada");
            holder.txtDuration.setText("Duración:" + baseApp.getDifferenceTime(baseApp.convertDate(visitsList.get(position).getFecha_visita_inicio()), baseApp.convertDate(visitsList.get(position).getFecha_visita_fin())));
        }

        if(visitsList.get(position).isEnviada()){
            holder.txtStatus.setText("Status: Enviada al servidor");
        }

        if(visitsList.get(position).isFinalizado_forzado()){
            holder.txtStatus.setText("Status: Se terminó de manera forzada");
        }

        holder.txtClasification.setText("Clasificación: " + functionsapp.getNameClasification(visitsList.get(position).getClasificacion_visita()));

        if(functionsapp.routeFinished(visitsList.get(position).getRuta())){
            holder.btnDelete.setVisibility(View.GONE);
        }

        //holder.btnViewOrder.setOnClickListener(v -> functionsapp.goDetailsOrderActivity(visitsList.get(position).getId()));

        holder.btnViewDetails.setOnClickListener(v -> {
            spClass.intSetSP("nVisit", visitsList.get(position).getId());
            spClass.intSetSP("nClient", visitsList.get(position).getCliente());
            functionsapp.goSalesActivity2();

        });

        //holder.btnTicket.setOnClickListener(v->functionsapp.printTicket(visitsList.get(position).getId()));
        holder.btnDelete.setOnClickListener(v -> askDeleteVisit(position));
    }

    public void askDeleteVisit(final int position){
        new AlertDialog.Builder(context)
                .setMessage("¿Estás seguro que quieres eliminar esta Visita? Se borrará toda la información, incluyendo el pedido.")
                .setCancelable(true)
                .setPositiveButton("Sí", (dialog, id) -> {

                    if (context instanceof VisitsActivity) {
                        if(visitsList.get(position).isEnviada()){
                             ((VisitsActivity) context).processCancelVisit(visitsList.get(position).getId());
                        }else {
                            ((VisitsActivity) context).deleteVisit(visitsList.get(position).getId());
                        }
                    }

                })
                .setNegativeButton("No", null)
                .show();
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

    public class VisitsViewHolder extends RecyclerView.ViewHolder {

        TextView txtList, txtClientName, txtBussinessName, txtStatus, txtClasification, txtDuration;
        Button btnViewDetails, btnTicket, btnDelete;
        LinearLayout layoutList;

        public VisitsViewHolder(View itemView) {
            super(itemView);

            txtList = itemView.findViewById(R.id.txtList);
            txtClientName = itemView.findViewById(R.id.txtClientName);
            txtBussinessName = itemView.findViewById(R.id.txtBussinessName);
            txtStatus = itemView.findViewById(R.id.txtDateRegister);
            txtClasification = itemView.findViewById(R.id.txtClasification);
            txtDuration = itemView.findViewById(R.id.txtDuration);
            btnViewDetails = itemView.findViewById(R.id.btnViewDetails);
            btnTicket = itemView.findViewById(R.id.btnTicket);
            btnDelete = itemView.findViewById(R.id.btnDelete);
            layoutList = itemView.findViewById(R.id.layoutList);
        }
    }
}