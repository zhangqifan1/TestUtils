package com.bawei.monthrepeat1.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 张祺钒
 * on2017/10/20.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    public void setList(List<Fragment> list) {
        this.list = list;
    }
}
