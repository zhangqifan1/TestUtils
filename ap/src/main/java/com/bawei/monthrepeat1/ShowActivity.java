package com.bawei.monthrepeat1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bawei.monthrepeat1.Adapters.RecyclerTypesAdapter;
import com.bawei.monthrepeat1.JsonBean.ZuiXinBean;

public class ShowActivity extends Activity {

    private RecyclerView mRecyclerShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();
        ZuiXinBean name = (ZuiXinBean) getIntent().getSerializableExtra("name");
        RecyclerTypesAdapter adapter=new RecyclerTypesAdapter(this,name);
        mRecyclerShow.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerShow.setAdapter(adapter);
    }

    private void initView() {
        mRecyclerShow = (RecyclerView) findViewById(R.id.recycler_Show);
    }
}
