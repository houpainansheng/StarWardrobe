package com.example.starwardrobe.ui.main.fragment.fashion.presenter;

import com.example.starwardrobe.ui.main.fragment.fashion.bean.Item1Bean;
import com.example.starwardrobe.ui.main.fragment.fashion.bean.Item2Bean;
import com.example.starwardrobe.ui.main.fragment.fashion.bean.LunboBean;
import com.example.starwardrobe.ui.main.fragment.fashion.constant.TuiJianConstant;

import rx.functions.Action1;

/**
 * Created by baisaikele on 2017/4/10.
 */

public class TuiJianPresenter extends TuiJianConstant.Presenter {
    @Override
    public void initData() {

        mModel.LoaderLunboPic(new Action1<LunboBean>() {
            @Override
            public void call(LunboBean bean) {
                mView.returnLunbo(bean);
            }
        });
        mModel.LoaderItem1(new Action1<Item1Bean>() {
            @Override
            public void call(Item1Bean bean) {
                mView.returnItem1(bean);
            }
        });

        mModel.LoaderItem2(new Action1<Item2Bean>() {
            @Override
            public void call(Item2Bean item2Bean) {
                mView.returnItem2(item2Bean);
            }
        },"");
    }
}
