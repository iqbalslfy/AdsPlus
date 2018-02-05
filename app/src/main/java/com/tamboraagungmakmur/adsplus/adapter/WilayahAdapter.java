package com.tamboraagungmakmur.adsplus.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tamboraagungmakmur.adsplus.R;

/**
 * Created by innan on 12/4/2017.
 */

public class WilayahAdapter extends RecyclerView.Adapter<WilayahAdapter.WilayahViewHolder> {
    @Override
    public WilayahViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wilayah, parent, false);
        WilayahViewHolder holder = new WilayahViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(WilayahViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class WilayahViewHolder extends RecyclerView.ViewHolder {
        public WilayahViewHolder(View itemView) {
            super(itemView);
        }
    }
}
