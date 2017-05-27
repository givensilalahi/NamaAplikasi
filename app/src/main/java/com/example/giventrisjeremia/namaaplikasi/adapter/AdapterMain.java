package com.example.giventrisjeremia.namaaplikasi.adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.giventrisjeremia.namaaplikasi.R;
import com.example.giventrisjeremia.namaaplikasi.databinding.ActivityListBinding;
import com.example.giventrisjeremia.namaaplikasi.databinding.ListHomeBinding;
import com.example.giventrisjeremia.namaaplikasi.mainview.ScrollingActivity;
import com.example.giventrisjeremia.namaaplikasi.model.QuotesEntity;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.R.attr.id;

/**
 * Created by Giventris Jeremia on 25/05/2017.
 */

public class AdapterMain extends RecyclerView.Adapter<AdapterMain.ViewHolder>{
    private List<QuotesEntity> mQuotesEntity;
    private Context mContext;
    private ListHomeBinding binding;

    public AdapterMain(List<QuotesEntity> mQuotesEntity, Context context) {
        this.mQuotesEntity = mQuotesEntity;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_home, parent, false);
        return new AdapterMain.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        QuotesEntity a = mQuotesEntity.get(position);
        holder.textView1.setText(a.getPulau());
        holder.textView2.setText(a.getLati().toString());
        holder.textView3.setText(a.getLongi().toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, ScrollingActivity.class);
                i.putExtra("id",id);
                mContext.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mQuotesEntity.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1, textView2,textView3;
        ImageView imageView;
        CardView cardView;


        public ViewHolder(View itemView) {
            super(itemView);

            textView1 = (TextView) itemView.findViewById(R.id.idPulau);
            textView2 = (TextView) itemView.findViewById(R.id.idLati);
            textView3 = (TextView) itemView.findViewById(R.id.idLongi);

            cardView = (CardView) itemView.findViewById(R.id.card_view);
        }
    }
}
