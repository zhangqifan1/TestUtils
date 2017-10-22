package com.bawei.monthrepeat1.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bawei.monthrepeat1.Adapters.ZuiXinAdapter;
import com.bawei.monthrepeat1.Const;
import com.bawei.monthrepeat1.JsonBean.ZuiXinBean;
import com.bawei.monthrepeat1.R;
import com.bawei.monthrepeat1.Utils.EndlessRecyclerOnScrollListener;
import com.bawei.monthrepeat1.Utils.network.OkhttpUtils;
import com.bawei.monthrepeat1.Utils.network.ResultCallback;
import com.squareup.okhttp.Request;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZuiXinFragment extends Fragment {


    private View view;
    private RecyclerView mRecyclerZuiXin;
    private SwipeRefreshLayout mSwipeRefresh;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zui_xin, container, false);
        initView(view);
        RequestData();

        return view;
    }

    private void RequestData() {
        OkhttpUtils.getAsyn(Const.pathZuiXin, new ResultCallback<ZuiXinBean>() {

            private ZuiXinAdapter adapter;

            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(final ZuiXinBean response) {
                adapter = new ZuiXinAdapter(response, getContext());
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                mRecyclerZuiXin.setLayoutManager(linearLayoutManager);
                mRecyclerZuiXin.setAdapter(adapter);
                mRecyclerZuiXin.addOnScrollListener(new EndlessRecyclerOnScrollListener(linearLayoutManager) {
                    @Override
                    public void onLoadMore(int currentPage) {
                        for (int i = 0; i < 3; i++) {
                            response.top_stories.add(response.top_stories.get(i));
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
                mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        response.top_stories.add(0,response.top_stories.get(2));
                        adapter.notifyDataSetChanged();
                        mSwipeRefresh.setRefreshing(false);
                        Toast.makeText(getContext(),"刷新 ",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    private void initView(View view) {
        mRecyclerZuiXin = (RecyclerView) view.findViewById(R.id.recycler_ZuiXin);
        mSwipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefresh);
    }
}
