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
import com.mds.ventasabpollo.models.ChangesPricesPending;
import com.mds.ventasabpollo.models.Lists;

import java.util.List;

public class AdapterChangesPrices extends RecyclerView.Adapter<AdapterChangesPrices.ListsViewHolder>
        implements View.OnClickListener{

    private Context context;
    private View.OnClickListener listener;

    private List<ChangesPricesPending> listsChangesPrices;

    public AdapterChangesPrices(Context context, List<ChangesPricesPending> listsList) {
        this.context = context;
        this.listsChangesPrices = listsList;
    }

    @Override
    public ListsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_change_price, parent, false);
        view.setOnClickListener(this);
        return new ListsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterChangesPrices.ListsViewHolder holder, final int position) {

        holder.txtViewInfo.setText("#" + listsChangesPrices.get(position).getCambio() +
                                  "\n" + listsChangesPrices.get(position).getNombre_cliente().trim() +
                                  "\n" + listsChangesPrices.get(position).getNombre_articulo().trim() +
                                  "\nP. Original: $" + listsChangesPrices.get(position).getPrecio_original() +
                                  "\nP. Nuevo: $" + listsChangesPrices.get(position).getPrecio_pactado() +
                                  "\n" + listsChangesPrices.get(position).getFecha() +
                                  "\nObservaciones: " + listsChangesPrices.get(position).getObservaciones());
    }

    @Override
    public int getItemCount() {
        return listsChangesPrices.size();
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

        TextView txtViewInfo;

        public ListsViewHolder(View itemView) {
            super(itemView);

            txtViewInfo        = itemView.findViewById(R.id.txtViewInfo);
        }
    }
}