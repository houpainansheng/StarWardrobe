package com.example.starwardrobe.ui.main.fragment.fashion.fragament;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.starwardrobe.R;
import com.example.starwardrobe.R2;
import com.example.starwardrobe.ui.main.fragment.fashion.adapter.TuiJianAdapter;
import com.example.starwardrobe.ui.main.fragment.fashion.bean.Item1Bean;
import com.example.starwardrobe.ui.main.fragment.fashion.bean.Item2Bean;
import com.example.starwardrobe.ui.main.fragment.fashion.bean.LunboBean;
import com.example.starwardrobe.ui.main.fragment.fashion.constant.TuiJianConstant;
import com.example.starwardrobe.ui.main.fragment.fashion.model.TuiJianModel;
import com.example.starwardrobe.ui.main.fragment.fashion.presenter.TuiJianPresenter;
import com.rock.mvplibrary.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by baisaikele on 2017/4/10.
 */

public class TuiJianFragament extends BaseFragment implements TuiJianConstant.MainView {

    @BindView(R2.id.tj_rv_mian)
    RecyclerView tj_rv_mian;
    private TuiJianAdapter tjAdapter;
    private TuiJianModel mModel;
    private TuiJianPresenter mPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.fraga_tuijian;
    }

    @Override
    public void initView() {

        List<Integer> data=new ArrayList<>();
        data.add(0);
        data.add(1);
        data.add(2);
        tjAdapter = new TuiJianAdapter(getContext());
        tj_rv_mian.setAdapter(tjAdapter);
        GridLayoutManager layout = new GridLayoutManager(getContext(), 2);
        layout.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position<2)
                    return 2;

                return 1;
            }
        });
        tj_rv_mian.setLayoutManager(layout);



        tj_rv_mian.setLayoutManager(layout);


        mModel=new TuiJianModel();
        mPresenter=new TuiJianPresenter();
        mPresenter.setVM(this,mModel);
        mPresenter.initData();






    }

    @Override
    public void onStartLoad() {

    }

    @Override
    public void onStopLoad() {

    }

    @Override
    public void onError(String errorInfo) {

    }

    @Override
    public void returnLunbo(LunboBean bean) {

        tjAdapter.setPageData(bean.getData().getItems());
    }

    @Override
    public void returnItem1(Item1Bean bean) {
        tjAdapter.setHotTJdata(bean);
    }

    @Override
    public void returnItem2(Item2Bean bean) {
        tjAdapter.setItem2Data(bean.getResponse().getData().getItems());

    }
}
