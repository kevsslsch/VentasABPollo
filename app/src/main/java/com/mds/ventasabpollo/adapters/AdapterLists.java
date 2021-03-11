package com.mds.ventasabpollo.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.models.Lists;

import java.util.List;

public class AdapterLists extends RecyclerView.Adapter<AdapterLists.ListsViewHolder>
        implements View.OnClickListener{

    private Context context;
    private View.OnClickListener listener;

    private List<Lists> listsLists;

    public AdapterLists(Context context, List<Lists> listsList) {
        this.context = context;
        this.listsLists = listsList;
    }

    @Override
    public ListsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_lists, parent, false);
        view.setOnClickListener(this);
        return new ListsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterLists.ListsViewHolder holder, final int position) {
        final BaseApp baseApp = new BaseApp(context);
        final FunctionsApp functionsapp = new FunctionsApp(context);
        final SPClass spClass = new SPClass(context);

        holder.txtName.setText(listsLists.get(position).getNombre_lista());
        holder.txtRute.setText("Nombre Ruta: " + listsLists.get(position).getNombre_ruta());

        holder.btnMap.setOnClickListener(v -> functionsapp.goMapsRouteActivity(listsLists.get(position).getLista()));
        holder.btnShowClients.setOnClickListener(v -> {

            if(baseApp.statusPermissionUbication()){
                functionsapp.goListClientsActivity(listsLists.get(position).getLista(), false);
                spClass.intSetSP("nList", listsLists.get(position).getLista());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listsLists.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    public class ListsViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtRute;
        Button btnShowClients, btnMap;

        public ListsViewHolder(View itemView) {
            super(itemView);

            txtName        = itemView.findViewById(R.id.txtName);
            txtRute        = itemView.findViewById(R.id.txtRute);
            btnShowClients = itemView.findViewById(R.id.btnShowClients);
            btnMap         = itemView.findViewById(R.id.btnMap);
        }
    }
}