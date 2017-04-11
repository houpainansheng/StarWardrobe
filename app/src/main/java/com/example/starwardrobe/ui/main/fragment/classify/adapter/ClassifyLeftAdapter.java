package com.example.starwardrobe.ui.main.fragment.classify.adapter;

import android.content.Context;
import android.widget.TextView;

import com.example.starwardrobe.R;
import com.example.starwardrobe.bean.ClassifyBean;
import com.rock.mvplibrary.adapters.BaisBaseAdapter;

import java.util.List;

/**
 * Created by 樊康 on 2017/4/10.
 */

public class ClassifyLeftAdapter extends BaisBaseAdapter<ClassifyBean.DataBean.ItemsBeanX>  {

    private Context context;

    public ClassifyLeftAdapter(Context context, List<ClassifyBean.DataBean.ItemsBeanX> data, int layoutResId) {
        super(context, data, layoutResId);
    this.context = context;

    }

    @Override
    protected void bindData(ViewHolder holder, ClassifyBean.DataBean.ItemsBeanX item, int position) {

        //设置ListView的第一个item的背景为白色

        TextView mBtn = (TextView) holder.findView(R.id.classify_frag_left_item_text);

         mBtn.setText(item.getComponent().getTitle());
        //mText.setText(item.getComponent().getTitle());


        if (mBtn.getText().equals("裙子")){

        }



    }



}
