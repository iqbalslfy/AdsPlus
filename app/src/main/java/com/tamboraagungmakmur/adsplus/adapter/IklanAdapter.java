package com.tamboraagungmakmur.adsplus.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.tamboraagungmakmur.adsplus.IklanDetActivity;
import com.tamboraagungmakmur.adsplus.Model.Model_Iklan;
import com.tamboraagungmakmur.adsplus.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by innan on 11/30/2017.
 */

public class IklanAdapter extends RecyclerView.Adapter<IklanAdapter.IklanViewHolder> {


    private List<Model_Iklan> iklanList = new ArrayList<>();
    private Context context;

    public class IklanViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ImageIklan)
        ImageView ImageIklan;

        @BindView(R.id.ambil)
        Button ambil;

        @OnClick(R.id.ambil)
        public void onViewClicked() {
            Intent intent = new Intent(context, IklanDetActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intent);
        }

        public IklanViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    public IklanAdapter(List<Model_Iklan> iklanList, Context context) {
        this.iklanList = iklanList;
        this.context = context;
    }

    @Override
    public IklanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.iklan_item, parent, false);

        return new IklanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IklanViewHolder holder, int position) {
        holder.ImageIklan.setImageResource(iklanList.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return iklanList.size();
    }

}
