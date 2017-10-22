package com.bawei.monthrepeat1.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.bawei.monthrepeat1.Adapters.GridViewAdapter;
import com.bawei.monthrepeat1.Const;
import com.bawei.monthrepeat1.JsonBean.ZuiXinBean;
import com.bawei.monthrepeat1.R;
import com.bawei.monthrepeat1.ShowActivity;
import com.bawei.monthrepeat1.Utils.network.OkhttpUtils;
import com.bawei.monthrepeat1.Utils.network.ResultCallback;
import com.squareup.okhttp.Request;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhuTiFragment extends Fragment {


    private View view;
    private GridView mGridView;

    public ZhuTiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_zhu_ti, container, false);

        initView(view);
        OkhttpUtils.getAsyn(Const.pathZuiXin, new ResultCallback<ZuiXinBean>() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(final ZuiXinBean response) {
                GridViewAdapter adapter=new GridViewAdapter(response,getContext());
                mGridView.setAdapter(adapter);
                mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getContext(), ShowActivity.class);
                        Bundle bundle=new Bundle();
                        bundle.putSerializable("name",response);
                        intent.putExtras(bundle);
                        getContext().startActivity(intent);
                    }
                });
            }
        });

        return view;
    }

    private void initView(View view) {
        mGridView = (GridView) view.findViewById(R.id.gridView);
    }
}
