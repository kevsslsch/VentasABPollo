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
import com.mds.ventasabpollo.models.Prices;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class AdapterArticlesAverages extends RecyclerView.Adapter<AdapterArticlesAverages.ArticlesViewHolder>
        implements View.OnClickListener{

    private Context context;
    private View.OnClickListener listener;

    private List<Prices> listArticles;

    Realm realm;

    public AdapterArticlesAverages(Context context, List<Prices> listArticles) {
        this.context = context;
        this.listArticles = listArticles;
    }

    @Override
    public ArticlesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_articles_average, parent, false);
        view.setOnClickListener(this);
        return new ArticlesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterArticlesAverages.ArticlesViewHolder holder, final int position) {
        final BaseApp baseApp = new BaseApp(context);
        final FunctionsApp functionsapp = new FunctionsApp(context);
        final SPClass spClass = new SPClass(context);

        realm = Realm.getDefaultInstance();

        RealmResults<Articles> articles = realm.where(Articles.class).equalTo("clave_articulo", listArticles.get(position).getClave_articulo()).findAll();
        int countArticles = articles.size();

        if(countArticles > 0){
            holder.txtArticle.setText(articles.get(0).getNombre_articulo().trim());
        }else{
            holder.txtArticle.setText("");
        }

        holder.txtViewAmount.setText(Integer.toString(listArticles.get(position).getPromedio_piezas()));
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