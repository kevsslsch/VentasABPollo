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
import com.mds.ventasabpollo.models.ChangesInventories;
import com.mds.ventasabpollo.models.Inventories;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class AdapterArticlesInventory extends RecyclerView.Adapter<AdapterArticlesInventory.ArticlesViewHolder>
        implements View.OnClickListener{

    private Context context;
    private View.OnClickListener listener;

    private List<Inventories> listArticles;

    Realm realm;

    public AdapterArticlesInventory(Context context, List<Inventories> listArticles) {
        this.context = context;
        this.listArticles = listArticles;
    }

    @Override
    public ArticlesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_articles_inventory, parent, false);
        view.setOnClickListener(this);
        return new ArticlesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterArticlesInventory.ArticlesViewHolder holder, final int position) {
        final BaseApp baseApp = new BaseApp(context);
        final FunctionsApp functionsapp = new FunctionsApp(context);
        final SPClass spClass = new SPClass(context);

        int idRoute = spClass.intGetSP("idRoute");

        if(idRoute == 0){
            idRoute = spClass.intGetSP("idRouteTemp");
        }

        int countChanges = 0;

        realm = Realm.getDefaultInstance();

        RealmResults<ChangesInventories> changesInventories = realm.where(ChangesInventories.class)
                .equalTo("ruta", idRoute)
                .equalTo("clave_articulo", listArticles.get(position).getClave_articulo())
                .findAll();

        for(ChangesInventories changes: changesInventories){
            countChanges += (changes.getCantidad_nueva()-changes.getCantidad_anterior());
        }

        holder.txtArticle.setText(listArticles.get(position).getNombre_articulo().trim());
        holder.txtViewAmount.setText(Integer.toString(listArticles.get(position).getCantidad_inicial() + countChanges));
        //holder.txtViewAmount2.setText(Integer.toString(listArticles.get(position).getCantidad()));
        holder.txtViewAmount2.setText(Integer.toString(functionsapp.getAmountArticleRoute(listArticles.get(position).getRuta(), listArticles.get(position).getClave_articulo(), false, true)));

        holder.txtViewSalesAmount.setText(Integer.toString(functionsapp.getDataInventoryRoute(listArticles.get(position).getRuta(), listArticles.get(position).getClave_articulo(), "venta")));
        holder.txtViewDevolutionsAmount.setText(Integer.toString(functionsapp.getDataInventoryRoute(listArticles.get(position).getRuta(), listArticles.get(position).getClave_articulo(), "devolucion")));
        holder.txtViewSeparatedAmount.setText(Integer.toString(functionsapp.getDataInventoryRoute(listArticles.get(position).getRuta(), listArticles.get(position).getClave_articulo(), "cambio")));
        holder.txtViewChangesAmount.setText(Integer.toString(functionsapp.getDataInventoryRoute(listArticles.get(position).getRuta(), listArticles.get(position).getClave_articulo(), "apartado")));
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

        TextView txtArticle, txtViewAmount, txtViewAmount2, txtViewSalesAmount, txtViewDevolutionsAmount, txtViewSeparatedAmount, txtViewChangesAmount;

        public ArticlesViewHolder(View itemView) {
            super(itemView);

            txtArticle         = itemView.findViewById(R.id.txtArticle);
            txtViewAmount      = itemView.findViewById(R.id.txtViewAmount);
            txtViewAmount2     = itemView.findViewById(R.id.txtViewAmount2);
            txtViewSalesAmount       = itemView.findViewById(R.id.txtViewSalesAmount);
            txtViewDevolutionsAmount = itemView.findViewById(R.id.txtViewDevolutionsAmount);
            txtViewSeparatedAmount   = itemView.findViewById(R.id.txtViewSeparatedAmount);
            txtViewChangesAmount     = itemView.findViewById(R.id.txtViewChangesAmount);
        }
    }
}