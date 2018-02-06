package com.tamboraagungmakmur.adsplus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tamboraagungmakmur.adsplus.Model.Model_Iklan;
import com.tamboraagungmakmur.adsplus.adapter.IklanAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by innan on 11/30/2017.
 */

public class IklanFragment extends Fragment {


    private GridLayoutManager gridLayoutManager;
    private IklanAdapter adapter;
    private List<Model_Iklan> iklanList = new ArrayList<>();
    RecyclerView rvIklan;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_iklan, container, false);

        InitIklan();
        rvIklan = view.findViewById(R.id.rv_iklan);
        rvIklan.setHasFixedSize(true);

        gridLayoutManager = new GridLayoutManager(getContext(), 1,
                GridLayoutManager.VERTICAL, false);

        rvIklan.setLayoutManager(gridLayoutManager);
        adapter = new IklanAdapter(iklanList, getContext());
        rvIklan.setAdapter(adapter);

        ButterKnife.bind(this, view);
        return view;
    }

    private void InitIklan() {
        iklanList.add(new Model_Iklan(R.drawable.adv1));
        iklanList.add(new Model_Iklan(R.drawable.adv2));
        iklanList.add(new Model_Iklan(R.drawable.adv33));
        iklanList.add(new Model_Iklan(R.drawable.adv1));
        iklanList.add(new Model_Iklan(R.drawable.adv2));
        iklanList.add(new Model_Iklan(R.drawable.adv33));
    }

}
