package com.bawei.monthrepeat1.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.monthrepeat1.JsonBean.ZuiXinBean;
import com.bawei.monthrepeat1.R;
import com.bawei.monthrepeat1.Utils.ImageLoaderUtils;
import com.bawei.monthrepeat1.View.ImageViewPlus;

/**
 * Created by 张祺钒
 * on2017/10/22.
 */

public class RecyclerTypesAdapter extends RecyclerView.Adapter<RecyclerTypesAdapter.MyViewHolder>{
    private Context context;
    private ZuiXinBean bean;

    public RecyclerTypesAdapter(Context context, ZuiXinBean bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==Type){
            View inflate = View.inflate(context, R.layout.type, null);
            MyViewHolder myViewHolder = new MyViewHolder(inflate);
            return  myViewHolder;
        }else{
            View inflate = View.inflate(context, R.layout.type1, null);
            MyViewHolder myViewHolder = new MyViewHolder(inflate);
            return  myViewHolder;
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        int type = getItemViewType(position);
        switch(type){
            case Type:
                ImageLoaderUtils.setImageView(bean.top_stories.get(position).image,context,holder.circle2);
                holder.tvType.setText(bean.top_stories.get(position).id+"\n"+bean.top_stories.get(position).title);
                break;
            case Type1:
                holder.tvType1.setText(bean.top_stories.get(position).title);
                break;
            default:
                break;
        }
    }

    private static final int Type = 666;
    private static final int Type1 = 222;

    @Override
    public int getItemViewType(int position) {
        if(position%2==0){
            return Type;
        }else{
            return Type1;
        }
    }

    @Override
    public int getItemCount() {
        return bean.top_stories.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageViewPlus circle2;
        private final TextView tvType;
        private final TextView tvType1;

        public MyViewHolder(View itemView) {
            super(itemView);
            circle2 = itemView.findViewById(R.id.circle2);
            tvType = itemView.findViewById(R.id.tvType);
            tvType1 = itemView.findViewById(R.id.tvType1);
        }
    }
}
