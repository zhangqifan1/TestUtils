package com.bawei.monthrepeat1;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.bawei.monthrepeat1.Adapters.FragmentAdapter;
import com.bawei.monthrepeat1.Fragments.ReMenFragment;
import com.bawei.monthrepeat1.Fragments.ZhuTiFragment;
import com.bawei.monthrepeat1.Fragments.ZhuanLanFragment;
import com.bawei.monthrepeat1.Fragments.ZuiXinFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabTitle;
    private ViewPager viewPager;
    private List<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initTabLayout();
        initViewPager();
    }

    private void initViewPager() {
        tabTitle.setupWithViewPager(viewPager);
        FragmentAdapter fragmentAdapter=new FragmentAdapter(getSupportFragmentManager());
        fragmentAdapter.setList(list);
        viewPager.setAdapter(fragmentAdapter);
        tabTitle.getTabAt(0).setText("最新日报");
        tabTitle.getTabAt(1).setText("专栏");
        tabTitle.getTabAt(2).setText("热门");
        tabTitle.getTabAt(3).setText("主题日报");
    }

    private void initTabLayout() {
        for (int i = 0; i < list.size(); i++) {
            tabTitle.addTab(tabTitle.newTab());
        }

    }

    /**
     * 准备数据 List<Fragment>
     */
    private void initData() {
        ZuiXinFragment zuiXinFragment = new ZuiXinFragment();
        ZhuanLanFragment zhuanLanFragment=new ZhuanLanFragment();
        ReMenFragment reMenFragment=new ReMenFragment();
        ZhuTiFragment zhuTiFragment=new ZhuTiFragment();
        list = new ArrayList<>();
        list.add(zuiXinFragment);
        list.add(zhuanLanFragment);
        list.add(reMenFragment);
        list.add(zhuTiFragment);
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabTitle = (TabLayout) findViewById(R.id.tabTitle);
    }
}
