package com.example.starwardrobe.ui.main.fragment.fashion.model;

import com.example.starwardrobe.api.TJpiService;
import com.example.starwardrobe.api.TJApi;
import com.example.starwardrobe.ui.main.fragment.fashion.bean.Item1Bean;
import com.example.starwardrobe.ui.main.fragment.fashion.bean.Item2Bean;
import com.example.starwardrobe.ui.main.fragment.fashion.bean.LunboBean;
import com.example.starwardrobe.ui.main.fragment.fashion.constant.TuiJianConstant;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by baisaikele on 2017/4/10.
 */

public class TuiJianModel implements TuiJianConstant.MainModel {
    @Override
    public void LoaderLunboPic(Action1 action) {

        Map<String,String> map=new HashMap<>();
        map.put("ga","%2Fforum%2Fbanner%20HTTP/1.1");
        TJpiService apiService = TJApi.getApiService();
        Observable<LunboBean> observable = apiService.getList(map);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(action);


    }

    @Override
    public void LoaderItem1(Action1<Item1Bean> action) {
        Map<String,String> map=new HashMap<>();
        map.put("ga","%2Fforum%2Ftag-recommend%20HTTP/1.1");
        TJpiService apiService = TJApi.getApiService();
        Observable<Item1Bean> observable = apiService.getItem1List(map);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(action);
    }

    @Override
    public void LoaderItem2(Action1<Item2Bean> action,String flag) {
        Map<String,String> map=new HashMap<>();
        map.put("flag",flag);
        map.put("ga","%2Fforum%2Frecommend-list%20HTTP/1.1");
        TJpiService apiService = TJApi.getApiService();
        Observable<Item2Bean> observable = apiService.getItem2List(map);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(action);
    }


}
