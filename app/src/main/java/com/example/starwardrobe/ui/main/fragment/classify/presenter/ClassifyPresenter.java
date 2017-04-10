package com.example.starwardrobe.ui.main.fragment.classify.presenter;

import android.util.Log;

import com.example.starwardrobe.bean.ClassifyBean;
import com.example.starwardrobe.ui.main.fragment.classify.ClassifyFragment;
import com.example.starwardrobe.ui.main.fragment.classify.contract.ClassifyContract;

import rx.Observer;

/**
 * Created by 樊康 on 2017/4/10.
 */

public class ClassifyPresenter extends ClassifyContract.Presenter {


    private static final String TAG = ClassifyFragment.class.getSimpleName();

    @Override
    public void init() {

        mModel.loadData().subscribe(new Observer<ClassifyBean>() {
            @Override
            public void onCompleted() {

                Log.e(TAG, "onCompleted:请求数据成功 " );
            }

            @Override
            public void onError(Throwable e) {

                Log.e(TAG, "onError: 请求数据失败 " );
            }

            @Override
            public void onNext(ClassifyBean classifyBean) {

                mView.getData(classifyBean);

                Log.e(TAG, "onNext: "+classifyBean.getData().getItems().size());
            }
        });
    }
}
