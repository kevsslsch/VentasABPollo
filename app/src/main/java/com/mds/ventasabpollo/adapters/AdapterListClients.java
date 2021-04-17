package com.mds.ventasabpollo.adapters;


import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mds.ventasabpollo.models.Clients;
import com.mds.ventasabpollo.models.ClientsLists;
import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.activities.ListClientsActivity;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.models.VisitsClasifications;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class AdapterListClients extends RecyclerView.Adapter<AdapterListClients.ListsViewHolder>
        implements View.OnClickListener {

    private Context context;
    private View.OnClickListener listener;

    private List<ClientsLists> listsListClients;
    private List<ClientsLists> listsListClientsFull;
    private HashMap<Integer, ListsViewHolder> holderlist;

    private long mLastClickTime = 0;
    int nRoute = 0;

    Realm realm;

    public AdapterListClients(Context context, List<ClientsLists> listsListClients) {
        this.context = context;
        this.listsListClients = listsListClients;
        listsListClientsFull = new ArrayList<>(listsListClients);
        holderlist = new HashMap<>();
    }

    @Override
    public ListsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_clients, parent, false);
        view.setOnClickListener(this);
        return new ListsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterListClients.ListsViewHolder holder, final int position) {
        final BaseApp baseApp = new BaseApp(context);
        final FunctionsApp functionsapp = new FunctionsApp(context);
        final SPClass spClass = new SPClass(context);

        realm = Realm.getDefaultInstance();
        nRoute = spClass.intGetSP("idRoute");

        if(!holderlist.containsKey(position)){
            holderlist.put(position, holder);
        }

        Clients client = realm.where(Clients.class)
                .equalTo("cliente", listsListClients.get(position).getCliente())
                .findFirst();

        holder.txtClientName.setText(client.getNombre_cliente().trim());

        if(spClass.boolGetSP("changingOrdenClients")){


            holder.btnVisit.setVisibility(View.GONE);
            holder.btnAverages.setVisibility(View.GONE);
            holder.btnMap.setVisibility(View.GONE);

            if(position == 0){
                holder.btnUp.setVisibility(View.INVISIBLE);
            }else{
                holder.btnUp.setVisibility(View.VISIBLE);
            }

            if(position == (listsListClients.size()-1)){
                holder.btnDown.setVisibility(View.INVISIBLE);
            }else{
                holder.btnDown.setVisibility(View.VISIBLE);
            }

        }else{
            holder.btnUp.setVisibility(View.GONE);
            holder.btnDown.setVisibility(View.GONE);

            holder.btnVisit.setVisibility(View.VISIBLE);
            //holder.btnAverages.setVisibility(View.VISIBLE);
            holder.btnMap.setVisibility(View.VISIBLE);
        }

        if(!client.getNombre_comercial().trim().equals("")){
            holder.txtBussinessName.setText(client.getNombre_comercial().trim());
        }else{
            holder.txtBussinessName.setVisibility(View.GONE);
        }

        holder.txtDirection.setText(client.getCalle().trim() + " " +client.getNumero_exterior().trim() + " " + client.getColonia().trim());
                //TODO
        // listsListClients.get(position).getCiudad().trim());

        if(!client.getTelefono().trim().equals("")){
            holder.txtPhone.setText(client.getTelefono().trim());
        }else{
            holder.txtPhone.setVisibility(View.GONE);
        }

        if(listsListClients.get(position).getOrden() == 0 && listsListClients.get(position).getLista() != 1){
            holder.txtViewWithoutOrder.setVisibility(View.VISIBLE);
        }else{
            holder.txtViewWithoutOrder.setVisibility(View.GONE);
        }

        //holder.btnAverages.setOnClickListener(v -> ((ListClientsActivity)context).showMenuBottomAskAveragesArticles(listsListClients.get(position).getCliente()));
        holder.btnAverages.setOnClickListener(v-> functionsapp.goAveragesActivity(listsListClients.get(position).getCliente()));
        holder.btnMap.setOnClickListener(v -> functionsapp.goMapsActivity(listsListClients.get(position).getCliente()));
        //holder.btnVisit.setOnClickListener(v -> ((ListClientsActivity)context).showMenuBottomAskVisitClient(listsListClients.get(position).getCliente(), listsListClients.get(position).getNombre_cliente().trim()));

        holder.btnVisit.setTag(R.drawable.custom_btn_info);

        if(functionsapp.clientVisitedinRoute(listsListClients.get(position).getCliente(), nRoute) && functionsapp.clasificationVisit(listsListClients.get(position).getCliente(), nRoute) == 1){
            holder.txtViewVisited.setVisibility(View.VISIBLE);
            holder.txtViewVisited.setText("Cliente ya visitado en la Ruta");
            holder.txtViewVisited.setTextColor(Color.parseColor("#914D01"));
        }else{
            holder.txtViewVisited.setVisibility(View.GONE);
        }

        if(functionsapp.clasificationVisit(listsListClients.get(position).getCliente(), nRoute) != 0 && functionsapp.clasificationVisit(listsListClients.get(position).getCliente(), nRoute) != 1){
            RealmResults<VisitsClasifications> clasifications = realm.where(VisitsClasifications.class)
                    .equalTo("clasificacion", functionsapp.clasificationVisit(listsListClients.get(position).getCliente(), nRoute))
                    .findAll();

            if(clasifications.size() > 0){
                switch (functionsapp.clasificationVisit(listsListClients.get(position).getCliente(), nRoute)){
                    case 2:
                    case 3:
                    case 4:
                        holder.txtViewVisited.setVisibility(View.VISIBLE);
                        holder.txtViewVisited.setText(clasifications.get(0).getNombre_clasificacion());
                        holder.txtViewVisited.setTextColor(Color.parseColor("#FFF44336"));
                        break;
                    case 5:
                        holder.txtViewVisited.setVisibility(View.VISIBLE);
                        holder.txtViewVisited.setText(clasifications.get(0).getNombre_clasificacion());
                        holder.txtViewVisited.setTextColor(Color.parseColor("#914D01"));
                        break;
                }
            }
        }

        if(spClass.intGetSP("nList") == 1){
            holder.txtViewLists.setVisibility(View.VISIBLE);
            //TODO
            // holder.txtViewLists.setText(listsListClients.get(position).getListas().trim());
        }else{
            holder.txtViewLists.setVisibility(View.GONE);
        }

        holder.layoutClient.setOnLongClickListener(v -> {
            if(!spClass.boolGetSP("changingOrdenClients")){
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                }else{
                    openOptionMenu(position);
                }
                mLastClickTime = SystemClock.elapsedRealtime();
            }

            return false;
        });

        holder.btnVisit.setOnClickListener(view -> {
            if (context instanceof ListClientsActivity) {

                //ColorDrawable layoutCurrentColor = (ColorDrawable) holder.btnVisit.getBackground();
                //ColorDrawable buttonColor = (ColorDrawable) holder.btnVisit.getBackground();

                if(Integer.parseInt(holder.btnVisit.getTag().toString()) == R.drawable.custom_btn_selected){
                    baseApp.showLog("Opening activity VisitsClient with data: " + listsListClients.get(position).getCliente());

                    ((ListClientsActivity)context).startVisit(listsListClients.get(position).getCliente());
                }else {
                    ((ListClientsActivity) context).deleteBackgroundParts();
                    holder.btnVisit.setBackgroundResource(R.drawable.custom_btn_selected);
                    holder.btnVisit.setTag(R.drawable.custom_btn_selected);
                }
            }
        });

        holder.btnUp.setOnClickListener(v->{
            if(position > 0){

                Collections.swap(listsListClients, position, position-1);
                notifyItemChanged(position, position-1);
                notifyItemChanged(position-1, position);
            }
        });

        holder.btnDown.setOnClickListener(v->{
            if(position < (listsListClients.size()-1)){

                Collections.swap(listsListClients, position, position+1);
                notifyItemChanged(position, position+1);
                notifyItemChanged(position+1, position);
            }
        });
    }

    public AdapterListClients.ListsViewHolder getViewByPosition(int position) { return holderlist.get(position); }

    public void openOptionMenu(final int position) {
        final FunctionsApp functionsapp = new FunctionsApp(context);
        final BaseApp baseApp = new BaseApp(context);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        //builder.setTitle("Selecciona una opción");

        String[] animals = {"Cambiar ubicación", "Abrir mapa", "Promedios de Ventas", "Saldar cuentas", "Cancelar"};
        builder.setItems(animals, (dialog, which) -> {
            switch (which) {
                case 0:
                    functionsapp.goChangeUbicationClientActivity(listsListClients.get(position).getCliente());
                    baseApp.showToast("Espere a que se posicione su ubicación en el mapa.");

                    /*if(baseApp.isSuperUser()){
                        functionsapp.goChangeUbicationClientActivity(listsListClients.get(position).getCliente());
                    }else{
                        baseApp.showToast("Función aún no disponible.");
                    }*/

                    dialog.dismiss();
                    break;
                case 1:
                    functionsapp.goMapsActivity(listsListClients.get(position).getCliente());
                    dialog.dismiss();
                    break;
                case 2:
                    functionsapp.goAveragesActivity(listsListClients.get(position).getCliente());
                    break;
                case 3:
                    functionsapp.goPayOffActivity(listsListClients.get(position).getCliente());
                    break;
                case 4:
                    dialog.dismiss();
                    break;
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public int getItemCount() {
        return listsListClients.size();
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

        LinearLayout layoutClient;
        TextView txtClientName, txtBussinessName, txtDirection, txtPhone, txtViewVisited, txtViewWithoutOrder, txtViewLists;
        Button btnVisit, btnAverages, btnMap;
        ImageButton btnUp, btnDown;

        public ListsViewHolder(View itemView) {
            super(itemView);

            layoutClient     = itemView.findViewById(R.id.layoutClient);
            txtClientName    = itemView.findViewById(R.id.txtClientName);
            txtBussinessName = itemView.findViewById(R.id.txtBussinessName);
            txtDirection     = itemView.findViewById(R.id.txtDirection);
            txtPhone         = itemView.findViewById(R.id.txtPhone);
            txtViewVisited   = itemView.findViewById(R.id.txtViewVisited);
            txtViewWithoutOrder = itemView.findViewById(R.id.txtViewWithoutOrder);
            txtViewLists     = itemView.findViewById(R.id.txtViewLists);
            btnVisit         = itemView.findViewById(R.id.btnVisit);
            btnAverages      = itemView.findViewById(R.id.btnAverages);
            btnMap           = itemView.findViewById(R.id.btnMap);
            btnUp            = itemView.findViewById(R.id.btnUp);
            btnDown          = itemView.findViewById(R.id.btnDown);
        }
    }
}