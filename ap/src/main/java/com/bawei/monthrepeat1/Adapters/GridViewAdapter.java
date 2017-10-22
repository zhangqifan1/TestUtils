package com.bawei.monthrepeat1.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bawei.monthrepeat1.JsonBean.ZuiXinBean;
import com.bawei.monthrepeat1.R;
import com.bawei.monthrepeat1.Utils.ImageLoaderUtils;
import com.bawei.monthrepeat1.View.ImageViewPlus;

/**
 * Created by 张祺钒
 * on2017/10/22.
 */

public class GridViewAdapter extends BaseAdapter {
    private ZuiXinBean bean;
    private Context context;

    public GridViewAdapter(ZuiXinBean bean, Context context) {
        this.bean = bean;
        this.context = context;
    }

    @Override
    public int getCount() {
        return bean.top_stories.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            holder=new ViewHolder();
            convertView=View.inflate(context, R.layout.griditem,null);
            holder.circleImageView=convertView.findViewById(R.id.circle);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        ImageLoaderUtils.setImageView(bean.top_stories.get(position).image,context, holder.circleImageView);
        return convertView;
    }
    static class ViewHolder{
        ImageViewPlus circleImageView;
    }
}
