package com.mds.ventasabpollo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.models.Clients;
import com.mds.ventasabpollo.models.Lists;
import com.mds.ventasabpollo.models.Routes;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class AdapterRoutes extends RecyclerView.Adapter<AdapterRoutes.RoutesViewHolder>{
        //implements View.OnClickListener{

    private Context context;
    private Realm realm;
    int nUser;
    //private View.OnClickListener listener;

    private List<Routes> routesList;

    public AdapterRoutes(Context context, List<Routes> routesList) {
        this.context = context;
        this.routesList = routesList;
    }

    @Override
    public RoutesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_routes, parent, false);
        //view.setOnClickListener(this);
        return new RoutesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RoutesViewHolder holder, final int position) {
        final BaseApp baseApp = new BaseApp(context);
        final FunctionsApp functionsapp = new FunctionsApp(context);
        final SPClass spClass = new SPClass(context);

        realm = Realm.getDefaultInstance();
        nUser = spClass.intGetSP("user");

        RealmResults<Lists> lists = null;
        RealmResults<Clients> clients = null;

        holder.txtRute.setText("Ruta: " + routesList.get(position).getRuta());
        holder.txtUserAuthorizer.setText("Usuario que autorizo: " + routesList.get(position).getNombre_autorizador_inicio());
        holder.txtDateStart.setText("Fecha inicio: " + routesList.get(position).getFecha_inicio());
        holder.txtDateEnd.setText("Fecha fin: " + routesList.get(position).getFecha_fin());
        holder.txtDeparture.setText("Salida: " + routesList.get(position).getSalida());

        if(routesList.get(position).getFecha_fin().equals("")){
            holder.txtStatus.setText("Status: En proceso");
            holder.btnViewReport.setVisibility(View.GONE);
            holder.txtDateEnd.setVisibility(View.GONE);
        }else{
            holder.txtStatus.setText("Status: Terminada");
            holder.btnViewReport.setVisibility(View.VISIBLE);
            holder.txtDateEnd.setVisibility(View.VISIBLE);
        }

        holder.btnViewVisits.setOnClickListener(v -> {
            functionsapp.goVisitsRouteActivity(routesList.get(position).getRuta());
        });
        holder.btnViewReport.setOnClickListener(v -> {
            spClass.intSetSP("idRouteTemp", routesList.get(position).getRuta());
            functionsapp.goFinalReportRouteActivity(routesList.get(position).getRuta());
        });
    }

    @Override
    public int getItemCount() {
        return routesList.size();
    }


    public class RoutesViewHolder extends RecyclerView.ViewHolder {

        TextView txtDeparture, txtRute, txtUserAuthorizer, txtDateStart, txtDateEnd, txtStatus;
        Button btnViewVisits, btnViewReport;
        LinearLayout layoutList;

        public RoutesViewHolder(View itemView) {
            super(itemView);

            txtDeparture = itemView.findViewById(R.id.txtDeparture);
            txtRute = itemView.findViewById(R.id.txtRute);
            txtUserAuthorizer = itemView.findViewById(R.id.txtUserAuthorizer);
            txtDateStart = itemView.findViewById(R.id.txtDateStart);
            txtDateEnd = itemView.findViewById(R.id.txtDateEnd);
            txtStatus = itemView.findViewById(R.id.txtDateRegister);
            btnViewVisits = itemView.findViewById(R.id.btnViewVisits);
            btnViewReport = itemView.findViewById(R.id.btnViewReport);
            layoutList = itemView.findViewById(R.id.layoutList);
        }
    }
}