package com.example.starwardrobe.ui.main.fragment.fashion.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.ToxicBakery.viewpager.transforms.DepthPageTransformer;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.example.starwardrobe.R;
import com.example.starwardrobe.ui.main.fragment.fashion.bean.Item1Bean;
import com.example.starwardrobe.ui.main.fragment.fashion.bean.Item2Bean;
import com.example.starwardrobe.ui.main.fragment.fashion.bean.LunboBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by baisaikele on 2017/4/10.
 */

public class TuiJianAdapter extends RecyclerView.Adapter<TuiJianAdapter.ViewHolder> {


    private LayoutInflater inflater;
    private int data[] = {0, 1, 2};
    private List<Item2Bean.ResponseBean.DataBean.ItemsBean> dataitem2;
    private ConvenientBanner convenientBanner;
    private Context context;
    private HotTJAdapter gvAdapter;


    public TuiJianAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        dataitem2 = new ArrayList<>();
    }

    public void setItem2Data(List<Item2Bean.ResponseBean.DataBean.ItemsBean> item2Data) {
        if (item2Data != null) {
            this.dataitem2.clear();
            this.dataitem2.addAll(item2Data);
            notifyDataSetChanged();
        }

    }


    @Override
    public int getItemViewType(int position) {
        return position < 2 ? data[position] : data[2];
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = null;
        switch (viewType) {
            case 0:
                view = inflater.inflate(R.layout.tj_item_lunbo, parent, false);
                convenientBanner = ((ConvenientBanner) view.findViewById(R.id.tj_convenientBanner));
                convenientBanner.setPageIndicator(new int[]{R.mipmap.point_1, R.mipmap.point})
                        .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                        .setPageTransformer(new DepthPageTransformer())
                        .startTurning(1000);
                break;
            case 1:
                view = inflater.inflate(R.layout.tj_item_1, parent, false);
                GridView gridView = (GridView) view.findViewById(R.id.tj_gv);
                gvAdapter = new HotTJAdapter(context, null, R.layout.it_gv_item);
                gridView.setAdapter(gvAdapter);
                break;
            case 2:
                view = inflater.inflate(R.layout.tj_item_2, parent, false);

                break;
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position > 1) {

            ImageView tj_iv_item = (ImageView) holder.findID(R.id.tj_iv_item);
            Picasso.with(context).load(dataitem2.get(position-2).getComponent().getPics()).into(tj_iv_item);
            ImageView userAvatar = (ImageView) holder.findID(R.id.tj_iv_userAvatar);
            Picasso.with(context).load(dataitem2.get(position-2).getComponent().getUser().getUserAvatar()).into(userAvatar);

            holder.setText(R.id.tj_tv_collect_count,dataitem2.get(position-2).getComponent().getCollect_count());
            holder.setText(R.id.tj_tv_content,dataitem2.get(position-2).getComponent().getContent());
            holder.setText(R.id.tj_tv_username,dataitem2.get(position-2).getComponent().getUser().getUsername());


        }


    }


    public void setHotTJdata(Item1Bean bean) {
        if (bean.getResponse().getData().getItems() != null) {
            gvAdapter.addRes(bean.getResponse().getData().getItems());
        }

    }


    public void setPageData(List<LunboBean.DataBean.ItemsBean> data) {
        List<String> pics = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            pics.add(data.get(i).getComponent().getPicUrl());
        }
        convenientBanner.setPages(new CBViewHolderCreator<LocalImageHolderView>() {
            @Override
            public LocalImageHolderView createHolder() {
                return new LocalImageHolderView();
            }
        }, pics);


    }


    @Override
    public int getItemCount() {
        return 2 + dataitem2.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        private View findID(int id) {

            return itemView.findViewById(id);
        }

        private void setText(int id, String text) {

            TextView textView = (TextView) findID(id);
            textView.setText(text);


        }


    }


    public class LocalImageHolderView implements Holder<String> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            Picasso.with(context).load(data).into(imageView);
        }
    }

}
