package com.tamboraagungmakmur.adsplus;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tamboraagungmakmur.adsplus.adapter.WilayahAdapter;

/**
 * Created by innan on 12/4/2017.
 */

public class KendaraanDet2Activity extends FragmentActivity {

    private RecyclerView recyclerView;
    private GridLayoutManager linearLayoutManager;
    private WilayahAdapter adapter;

    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.activity_kendaraan_det2);
        initView();
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.rv_wilayah);
        linearLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new WilayahAdapter();
        recyclerView.setAdapter(adapter);
    }

}
