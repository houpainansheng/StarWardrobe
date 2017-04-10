package com.example.starwardrobe.ui.main.fragment.classify.model;

import com.example.starwardrobe.api.ClassifyApi;
import com.example.starwardrobe.bean.ClassifyBean;
import com.example.starwardrobe.ui.main.fragment.classify.contract.ClassifyContract;
import com.rock.mvplibrary.event.AndroidIOToMain;

import java.util.HashMap;

import rx.Observable;

/**
 * Created by 樊康 on 2017/4/10.
 */

public class ClassifyModel implements ClassifyContract.Model {

    /**
     * http://api-v2.mall.hichao.com/category/list?ga= %2Fcategory%2Flist
     */
    @Override
    public Observable<ClassifyBean> loadData() {

        HashMap<String, String> map = new HashMap<>();

         map.put("ga","%2Fcategory%2Flist");

        return ClassifyApi.getApiService().getString(map).compose(new AndroidIOToMain.IOToMainTransformer<ClassifyBean>());

    }
}