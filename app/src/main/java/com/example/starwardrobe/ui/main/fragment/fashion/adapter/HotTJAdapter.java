package com.example.starwardrobe.ui.main.fragment.fashion.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.example.starwardrobe.R;
import com.example.starwardrobe.ui.main.fragment.fashion.bean.Item1Bean;
import com.rock.mvplibrary.adapters.BaisBaseAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by baisaikele on 2017/4/10.
 */

public class HotTJAdapter extends BaisBaseAdapter<Item1Bean.ResponseBean.DataBean.ItemsBean> {
    private Context context;

    public HotTJAdapter(Context context, List<Item1Bean.ResponseBean.DataBean.ItemsBean> data, int layoutResId) {
        super(context, data, layoutResId);
        this.context=context;
    }

    @Override
    protected void bindData(ViewHolder holder, Item1Bean.ResponseBean.DataBean.ItemsBean item, int position) {

        ImageView imageView = (ImageView) holder.findView(R.id.gv_iv);
        Picasso.with(context).load(item.getComponent().getPicUrl()).into(imageView);
        holder.setText(R.id.gv_title,item.getComponent().getTitle());


    }
}
