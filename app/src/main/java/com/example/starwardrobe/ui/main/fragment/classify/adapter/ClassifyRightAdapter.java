package com.example.starwardrobe.ui.main.fragment.classify.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.example.starwardrobe.R;
import com.example.starwardrobe.bean.ClassifyBean;
import com.rock.mvplibrary.adapters.BaisBaseAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 樊康 on 2017/4/10.
 */

public class ClassifyRightAdapter extends BaisBaseAdapter<ClassifyBean.DataBean.ItemsBeanX.ComponentBeanX.ItemsBean> {


    private Context context;
    public ClassifyRightAdapter(Context context, List<ClassifyBean.DataBean.ItemsBeanX.ComponentBeanX.ItemsBean> data, int layoutResId) {
        super(context, data, layoutResId);
        this.context = context;
    }

    @Override
    protected void bindData(ViewHolder holder, ClassifyBean.DataBean.ItemsBeanX.ComponentBeanX.ItemsBean item, int position) {

        ImageView mImage = (ImageView) holder.findView(R.id.classify_frag_right_item_image);

        //使用Picasso 加载图片
        Picasso.with(context).load(item.getComponent().getPicUrl()).placeholder(R.mipmap.ic_cart_empty).into(mImage);

        holder.setText(R.id.classify_frag_right_item_text,item.getComponent().getWord());
    }
}
