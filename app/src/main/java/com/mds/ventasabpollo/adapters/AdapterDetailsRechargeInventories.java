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
import com.mds.ventasabpollo.models.Articles;
import com.mds.ventasabpollo.models.RechargeInventories;

import java.util.List;

public class AdapterDetailsRechargeInventories extends RecyclerView.Adapter<AdapterDetailsRechargeInventories.ArticlesViewHolder>
        implements View.OnClickListener{

    private Context context;
    private View.OnClickListener listener;

    private List<RechargeInventories> listArticles;

    public AdapterDetailsRechargeInventories(Context context, List<RechargeInventories> listArticles) {
        this.context = context;
        this.listArticles = listArticles;
    }

    @Override
    public ArticlesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_details_recharge_inventory, parent, false);
        view.setOnClickListener(this);
        return new ArticlesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterDetailsRechargeInventories.ArticlesViewHolder holder, final int position) {
        final BaseApp baseApp = new BaseApp(context);
        final FunctionsApp functionsapp = new FunctionsApp(context);
        final SPClass spClass = new SPClass(context);

        Articles article = functionsapp.getArticle(listArticles.get(position).getClave_articulo());

        if(article != null){
            holder.txtArticle.setText(article.getNombre_articulo().trim());
        }else{
            holder.txtArticle.setText("Art. No Disponible.");
        }

        holder.txtViewAmount.setText(Double.toString(listArticles.get(position).getCantidad()));
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