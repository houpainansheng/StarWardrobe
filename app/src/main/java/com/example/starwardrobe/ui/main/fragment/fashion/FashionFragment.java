package com.example.starwardrobe.ui.main.fragment.fashion;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.example.starwardrobe.R;
import com.example.starwardrobe.R2;
import com.example.starwardrobe.ui.main.fragment.fashion.fragament.GuangZhuFragament;
import com.example.starwardrobe.ui.main.fragment.fashion.fragament.TuiJianFragament;
import com.example.starwardrobe.ui.main.fragment.fashion.fragament.ZuiXinFragament;
import com.rock.mvplibrary.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/4/6.
 */

public class FashionFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener {



    public static final String TAG=FashionFragment.class.getName();
    @BindView(R2.id.fashin_fl)
    FrameLayout  fashin_fl;
    @BindView(R2.id.fashin_rg)
    RadioGroup fashin_rg;
    @BindView(R2.id.fashin_iv_di)
    ImageView fashin_iv_di;
    @BindView(R2.id.fashin_iv_pic)
    ImageView fashin_iv_pic;
    @BindView(R2.id.frash_iv_find)
    ImageView frash_iv_find;
    private Fragment mShowFragment;
    private int diwidth;


    @Override
    protected int getLayoutId() {
        return R.layout.fraga_fashion;
    }

    @Override
    public void initView() {


        fashin_rg.setOnCheckedChangeListener(this);
        switchPage(TuiJianFragament.class);



    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        diwidth = fashin_iv_di.getWidth();
        int num=0;
        switch (checkedId) {
            case R.id.fashin_rb_guangzhu:
                switchPage(GuangZhuFragament.class);
                num =0;
                break;
            case R.id.fashin_rb_tuijian:
                switchPage(TuiJianFragament.class);
                num =1;
                break;
            case R.id.fashin_rb_zuixin:
                switchPage(ZuiXinFragament.class);
                num =2;
                break;
        }
       fashin_iv_di.setTranslationX((num-1)*diwidth);




    }


    private void switchPage(Class<? extends Fragment> cls){
        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        // 开始进入隐藏操作
        if (mShowFragment != null) {
            transaction.hide(mShowFragment);
        }
        // 显示我们将要显示的页面
        mShowFragment = fm.findFragmentByTag(cls.getName());
        if (mShowFragment != null) {
            transaction.show(mShowFragment);
        } else {
            try {
                mShowFragment = cls.newInstance();
                transaction.add(R.id.fashin_fl, mShowFragment, cls.getName());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            }
        }
        transaction.commit();
    }
}
