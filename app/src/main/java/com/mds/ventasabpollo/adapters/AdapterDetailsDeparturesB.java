package com.mds.ventasabpollo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.models.DetailsDepartures;

import java.util.List;

public class AdapterDetailsDeparturesB extends RecyclerView.Adapter<AdapterDetailsDeparturesB.ArticlesViewHolder>
        implements View.OnClickListener{

    private Context context;
    private View.OnClickListener listener;

    private List<DetailsDepartures> listArticles;

    public AdapterDetailsDeparturesB(Context context, List<DetailsDepartures> listArticles) {
        this.context = context;
        this.listArticles = listArticles;
    }

    @Override
    public ArticlesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_details_departures_b, parent, false);
        view.setOnClickListener(this);
        return new ArticlesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterDetailsDeparturesB.ArticlesViewHolder holder, final int position) {
        final BaseApp baseApp = new BaseApp(context);
        final FunctionsApp functionsapp = new FunctionsApp(context);
        final SPClass spClass = new SPClass(context);

        holder.txtArticle.setText(listArticles.get(position).getNombre_articulo().trim());
        holder.txtViewAmount.setText(Integer.toString(listArticles.get(position).getCantidad()));
    }

    @Override
    public int getItemCount() {
        return listArticles.size();
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

    public class ArticlesViewHolder extends RecyclerView.ViewHolder {

        TextView txtArticle, txtViewAmount;

        public ArticlesViewHolder(View itemView) {
            super(itemView);

            txtArticle        = itemView.findViewById(R.id.txtArticle);
            txtViewAmount     = itemView.findViewById(R.id.txtViewAmount);
        }
    }
}