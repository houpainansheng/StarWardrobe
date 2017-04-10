package com.example.starwardrobe.ui.main.fragment.classify.contract;

import com.example.starwardrobe.bean.ClassifyBean;
import com.rock.mvplibrary.base.BaseModel;
import com.rock.mvplibrary.base.BasePresenter;
import com.rock.mvplibrary.base.BaseView;

import rx.Observable;

/**
 * Created by 樊康 on 2017/4/10.
 */

public interface ClassifyContract {

    //定义Presenter
    public abstract class  Presenter extends BasePresenter<Model,ClassifyView> {

        public abstract  void  init();
    }
    //定义Model

    interface  Model extends BaseModel {

        Observable<ClassifyBean>  loadData();


    }

    //定义View
    public interface  ClassifyView extends BaseView {

        void  getData(ClassifyBean data);
    }
}
