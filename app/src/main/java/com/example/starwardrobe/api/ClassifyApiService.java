package com.example.starwardrobe.api;

import com.example.starwardrobe.bean.ClassifyBean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by 樊康 on 2017/4/10.
 */

public interface ClassifyApiService {

    /**
     http://api-v2.mall.hichao.com/category/list?ga= %2Fcategory%2Flist

     */
    @GET("/category/list")
    Observable<ClassifyBean> getString(@QueryMap Map<String, String> map);

}
