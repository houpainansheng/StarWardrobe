package com.example.starwardrobe.api;



import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.starwardrobe.constants.HttpParams.HOST_URL;

/**
 * Created by 樊康 on 2017/3/28.
 */

public class TJApi {

    private static TJpiService mApiService;

    public static TJpiService getApiService(){
        if (mApiService == null){
            initService();
        }
        return  mApiService;
    }

    private static void initService() {

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(HOST_URL)
                .build();


        mApiService =  retrofit.create(TJpiService.class);
    }
}
