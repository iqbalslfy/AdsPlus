package com.tamboraagungmakmur.adsplus;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tamboraagungmakmur.adsplus.adapter.IklanAdapter;

/**
 * Created by innan on 11/30/2017.
 */

public class IklanFragment extends Fragment {

    private View view;
    private Context context;

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private IklanAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null)
                parent.removeView(view);
        }
        try {
            view = inflater.inflate(R.layout.fragment_iklan, container, false);
        } catch (InflateException e) {

        }
        context = view.getContext();

        initRv();

        return view;
    }

    private void initRv() {
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_iklan);
        linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new IklanAdapter();
        recyclerView.setAdapter(adapter);

    }

}
