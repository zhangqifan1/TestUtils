package com.bawei.monthrepeat1.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.monthrepeat1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhuanLanFragment extends Fragment {


    public ZhuanLanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_zhuan_lan, container, false);
    }

}
