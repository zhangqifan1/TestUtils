package com.bawei.monthrepeat1.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.monthrepeat1.JsonBean.ZuiXinBean;
import com.bawei.monthrepeat1.R;
import com.bawei.monthrepeat1.Utils.ImageLoaderUtils;
import com.bawei.monthrepeat1.View.RoundImageView;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

/**
 * Created by 张祺钒
 * on2017/10/20.
 */

public class ZuiXinAdapter extends RecyclerView.Adapter<ZuiXinAdapter.MyViewHolder> {
    private ZuiXinBean bean;
    private Context context;

    public ZuiXinAdapter(ZuiXinBean bean, Context context) {
        this.bean = bean;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case Type0:
                view = View.inflate(context, R.layout.zuixin_banner, null);
                break;
            case Type1:
                view = View.inflate(context, R.layout.zuixin_item, null);
                break;
            default:
                break;
        }
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        int type = getItemViewType(position);
        switch (type) {
            case Type0:
                List<String> images = bean.stories.get(position).images;
                holder.banner.setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Glide.with(context).load(path).into(imageView);
                    }
                }).setImages(images).start();
                break;
            case Type1:
                ZuiXinBean.TopStoriesBean topStoriesBean = bean.top_stories.get(position);
                ImageLoaderUtils.setImageView(topStoriesBean.image,context,holder.image);
                holder.tv.setText(topStoriesBean.title);
                break;
            default:
                break;
        }
    }

    private static final int Type0 = 324;
    private static final int Type1 = 222;

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return Type0;
        }
        return Type1;
    }

    @Override
    public int getItemCount() {
        return bean.top_stories.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        private final RoundImageView image;
        private final Banner banner;
        private final TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
            image = itemView.findViewById(R.id.image_zuixin_item);
            tv = itemView.findViewById(R.id.tv_zuixin_item);
        }
    }
}
