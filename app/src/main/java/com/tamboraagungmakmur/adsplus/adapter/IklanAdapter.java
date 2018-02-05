package com.tamboraagungmakmur.adsplus.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tamboraagungmakmur.adsplus.IklanDetActivity;
import com.tamboraagungmakmur.adsplus.R;

/**
 * Created by innan on 11/30/2017.
 */

public class IklanAdapter extends RecyclerView.Adapter<IklanAdapter.IklanViewHolder> {

    private Context context;

    @Override
    public IklanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.iklan_item, parent, false);
        IklanViewHolder holder = new IklanViewHolder(view);
        context = parent.getContext();
        return holder;
    }

    @Override
    public void onBindViewHolder(IklanViewHolder holder, int position) {

        holder.ambil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, IklanDetActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class IklanViewHolder extends RecyclerView.ViewHolder {

        private Button ambil;

        public IklanViewHolder(View itemView) {
            super(itemView);
            ambil = (Button) itemView.findViewById(R.id.ambil);
        }
    }
}
