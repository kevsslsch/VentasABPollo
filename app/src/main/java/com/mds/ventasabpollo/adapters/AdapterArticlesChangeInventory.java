package com.mds.ventasabpollo.adapters;


import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.models.Inventories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdapterArticlesChangeInventory extends RecyclerView.Adapter<AdapterArticlesChangeInventory.ArticlesViewHolder>
        implements View.OnClickListener{

    private Context context;
    private View.OnClickListener listener;

    private List<Inventories> listArticles;
    private HashMap<Integer, ArticlesViewHolder> holderlist;

    private static List<Integer> mEditTextValues = new ArrayList<>();

    public AdapterArticlesChangeInventory(Context context, List<Inventories> listArticles) {
        this.context = context;
        this.listArticles = listArticles;

        if(mEditTextValues != null){
            mEditTextValues.clear();
        }

        for(int i=1;i<=listArticles.size();i++){
            mEditTextValues.add(0);
        }

        holderlist = new HashMap<>();
    }

    @Override
    public ArticlesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_articles_change_inventory, parent, false);
        view.setOnClickListener(this);
        return new ArticlesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterArticlesChangeInventory.ArticlesViewHolder holder, final int position) {
        final BaseApp baseApp = new BaseApp(context);
        final FunctionsApp functionsapp = new FunctionsApp(context);
        final SPClass spClass = new SPClass(context);

        if(!holderlist.containsKey(position)){
            holderlist.put(position, holder);
        }

        int amount = functionsapp.getAmountArticleRoute(listArticles.get(position).getRuta(), listArticles.get(position).getClave_articulo(), false, true);

        holder.txtKey.setText(Integer.toString(listArticles.get(position).getClave_articulo()));
        holder.txtArticle.setText(listArticles.get(position).getNombre_articulo().trim());
        //holder.txtViewAmount.setText(Integer.toString(listArticles.get(position).getCantidad()));
        holder.txtViewAmount.setText(Integer.toString(amount));

        holder.editTxtViewNewAmount.setSelectAllOnFocus(true);
        holder.editTxtViewNewAmount.setTag(position);

        if(mEditTextValues.get(position) == 0 && amount != 0){
            mEditTextValues.set(position, amount);
            holder.editTxtViewNewAmount.setText(Integer.toString(amount));
        }else{
            holder.editTxtViewNewAmount.setText(Integer.toString(mEditTextValues.get(position)));
        }
    }

    @Override
    public int getItemCount() {
        return listArticles.size();
    }

    public AdapterArticlesChangeInventory.ArticlesViewHolder getViewByPosition(int position) { return holderlist.get(position); }

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

        TextView txtKey, txtArticle, txtViewAmount, editTxtViewNewAmount;

        public ArticlesViewHolder(View itemView) {
            super(itemView);

            txtKey            = itemView.findViewById(R.id.txtKey);
            txtArticle        = itemView.findViewById(R.id.txtArticle);
            txtViewAmount     = itemView.findViewById(R.id.txtViewAmount);
            editTxtViewNewAmount    = itemView.findViewById(R.id.editTxtViewNewAmount);

            editTxtViewNewAmount.addTextChangedListener(new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                public void afterTextChanged(Editable editable) {}
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(editTxtViewNewAmount.getTag()!=null) {

                        if (charSequence.length() == 0) {
                            mEditTextValues.set((int) editTxtViewNewAmount.getTag(), 0);
                        } else if (charSequence.length() > 9) {
                            mEditTextValues.set((int) editTxtViewNewAmount.getTag(), Integer.valueOf(charSequence.toString().substring(0, 9)));
                        } else {
                            mEditTextValues.set((int) editTxtViewNewAmount.getTag(), Integer.valueOf(charSequence.toString()));
                        }
                    }
                }
            });
        }
    }
}