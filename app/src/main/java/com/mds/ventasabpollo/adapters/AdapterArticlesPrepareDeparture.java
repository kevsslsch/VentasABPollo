package com.mds.ventasabpollo.adapters;


import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.models.Articles;
import com.mds.ventasabpollo.models.Inventories;
import com.mds.ventasabpollo.models.PrepareDeparture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class AdapterArticlesPrepareDeparture extends RecyclerView.Adapter<AdapterArticlesPrepareDeparture.ArticlesViewHolder>
        implements View.OnClickListener{

    private Context context;
    private View.OnClickListener listener;

    private List<Articles> listArticles;

    private HashMap<Integer, ArticlesViewHolder> holderlist;
    private static List<Double> mEditTextValues = new ArrayList<>();

    Realm realm;

    public AdapterArticlesPrepareDeparture(Context context, List<Articles> listArticles) {
        this.context = context;
        this.listArticles = listArticles;

        if (mEditTextValues != null) {
            mEditTextValues.clear();
        }

        for (int i = 1; i <= listArticles.size(); i++) {
            mEditTextValues.add(0.0);
        }

        holderlist = new HashMap<>();

    }

    @Override
    public ArticlesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_articles_prepare_departure, parent, false);
        view.setOnClickListener(this);
        return new ArticlesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterArticlesPrepareDeparture.ArticlesViewHolder holder, final int position) {
        final BaseApp baseApp = new BaseApp(context);
        final FunctionsApp functionsapp = new FunctionsApp(context);
        final SPClass spClass = new SPClass(context);

        if(!holderlist.containsKey(position)){
            holderlist.put(position, holder);
        }

        double amount = functionsapp.getAmountPrepareDeparture(listArticles.get(position).getClave_articulo());

        holder.txtKey.setText(Integer.toString(listArticles.get(position).getClave_articulo()));
        holder.txtArticle.setText(listArticles.get(position).getNombre_articulo().trim());

        holder.editTxtViewAmount.setSelectAllOnFocus(true);
        holder.editTxtViewAmount.setTag(position);

        if(mEditTextValues.get(position) == 0 && amount != 0){
            mEditTextValues.set(position, amount);
            holder.editTxtViewAmount.setText(Double.toString(amount));
        }else{
            holder.editTxtViewAmount.setText(Double.toString(mEditTextValues.get(position)));
        }

        holder.editTxtViewAmount.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                save(holder);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listArticles.size();
    }

    public AdapterArticlesPrepareDeparture.ArticlesViewHolder getViewByPosition(int position) { return holderlist.get(position); }

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

        TextView txtKey, txtArticle, editTxtViewAmount;

        public ArticlesViewHolder(View itemView) {
            super(itemView);

            txtKey            = itemView.findViewById(R.id.txtKey);
            txtArticle        = itemView.findViewById(R.id.txtArticle);
            editTxtViewAmount = itemView.findViewById(R.id.editTxtViewAmount);

            editTxtViewAmount.addTextChangedListener(new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                public void afterTextChanged(Editable editable) {}
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(editTxtViewAmount.getTag()!=null) {

                        if (charSequence.length() == 0) {
                            mEditTextValues.set((int) editTxtViewAmount.getTag(), 0.0);
                        } else if (charSequence.length() > 9) {
                            mEditTextValues.set((int) editTxtViewAmount.getTag(), Double.valueOf(charSequence.toString().substring(0, 9)));
                        } else {
                            mEditTextValues.set((int) editTxtViewAmount.getTag(), Double.valueOf(charSequence.toString()));
                        }
                    }
                }
            });
        }
    }

    public void save(ArticlesViewHolder holder){

        BaseApp baseApp = new BaseApp(context);

        realm = Realm.getDefaultInstance();

        try {

            double value = 0.0;

            if(!holder.editTxtViewAmount.getText().toString().isEmpty()){
                value = Double.parseDouble(holder.editTxtViewAmount.getText().toString());
            }

            int key = Integer.valueOf(holder.txtKey.getText().toString());

            RealmResults<PrepareDeparture> prepareDepartures = realm.where(PrepareDeparture.class)
                    .equalTo("clave_articulo", key)
                    .findAll();

            realm.beginTransaction();

            if (prepareDepartures.size() > 0) {
                if (value == 0) {
                    prepareDepartures.get(0).deleteFromRealm();
                } else {
                    prepareDepartures.get(0).setCantidad(value);
                }
            } else {

                if (value != 0) {
                    PrepareDeparture prepareDeparture = new PrepareDeparture(
                            key,
                            value);

                    realm.insertOrUpdate(prepareDeparture);
                }
            }

            realm.commitTransaction();

        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
        }
    }


}