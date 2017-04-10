package com.example.starwardrobe.ui.main.fragment.classify.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.starwardrobe.R;
import com.example.starwardrobe.bean.ClassifyBean;
import com.orhanobut.logger.Logger;
import com.rock.mvplibrary.adapters.BaisBaseAdapter;

import java.util.List;

/**
 * Created by 樊康 on 2017/4/10.
 */

public class ClassifyLeftAdapter extends BaisBaseAdapter<ClassifyBean.DataBean.ItemsBeanX> {

    private Context context;

    public ClassifyLeftAdapter(Context context, List<ClassifyBean.DataBean.ItemsBeanX> data, int layoutResId) {
        super(context, data, layoutResId);
    this.context = context;

    }

    @Override
    protected void bindData(ViewHolder holder, ClassifyBean.DataBean.ItemsBeanX item, int position) {

        //设置ListView的第一个item的背景为白色

        TextView mText = (TextView) holder.findView(R.id.classify_frag_left_item_text);

        mText.setText(item.getComponent().getTitle());


        if (mText.getText().equals("裙子")){
            mText.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
        }

        //在适配器中直接为listView的item设置事件



    }



}
