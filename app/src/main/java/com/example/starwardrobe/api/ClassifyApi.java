package com.example.starwardrobe.api;

import com.example.starwardrobe.constants.Constant;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 樊康 on 2017/4/10.
 */

public class ClassifyApi {

    private static  ClassifyApiService mApiService;

    public static  ClassifyApiService getApiService(){
        if (mApiService == null){
            initService();
        }
        return  mApiService;
    }

    private static void initService() {

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constant.HOST_URL)
                .build();

        mApiService =  retrofit.create(ClassifyApiService.class);
    }

}
