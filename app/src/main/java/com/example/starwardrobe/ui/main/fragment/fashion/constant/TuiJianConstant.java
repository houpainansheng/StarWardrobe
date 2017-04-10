package com.example.starwardrobe.ui.main.fragment.fashion.constant;

import com.example.starwardrobe.ui.main.fragment.fashion.bean.Item1Bean;
import com.example.starwardrobe.ui.main.fragment.fashion.bean.Item2Bean;
import com.example.starwardrobe.ui.main.fragment.fashion.bean.LunboBean;
import com.rock.mvplibrary.base.BaseModel;
import com.rock.mvplibrary.base.BasePresenter;
import com.rock.mvplibrary.base.BaseView;

import rx.functions.Action1;

/**
 * Created by baisaikele on 2017/4/10.
 */

public interface TuiJianConstant {

    public abstract class Presenter extends BasePresenter<MainModel,MainView>{

        public abstract void initData();
    }

    public interface MainModel extends BaseModel{

        void  LoaderLunboPic(Action1<LunboBean> action);

        void  LoaderItem1(Action1<Item1Bean> action);
        void  LoaderItem2(Action1<Item2Bean> action,String flag);

    }
    public interface MainView extends BaseView{
        void returnLunbo(LunboBean bean);
        void returnItem1(Item1Bean bean);
        void returnItem2(Item2Bean bean);
    }

}
