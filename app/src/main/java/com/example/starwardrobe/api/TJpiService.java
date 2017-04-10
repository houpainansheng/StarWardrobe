package com.example.starwardrobe.api;

import com.example.starwardrobe.ui.main.fragment.fashion.bean.Item1Bean;
import com.example.starwardrobe.ui.main.fragment.fashion.bean.Item2Bean;
import com.example.starwardrobe.ui.main.fragment.fashion.bean.LunboBean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by baisaikele on 2017/4/10.
 */

public interface TJpiService {

    @GET("forum/banner")
    Observable<LunboBean> getList(@QueryMap Map<String, String> map);
    @GET("forum/tag-recommend")
    Observable<Item1Bean> getItem1List(@QueryMap Map<String, String> map);
    @GET("forum/recommend-list")
    Observable<Item2Bean> getItem2List(@QueryMap Map<String, String> map);


}
