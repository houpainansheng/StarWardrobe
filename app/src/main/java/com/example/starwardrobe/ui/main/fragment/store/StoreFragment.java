package com.example.starwardrobe.ui.main.fragment.store;

import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

import com.example.starwardrobe.R;
import com.example.starwardrobe.R2;
import com.example.starwardrobe.ui.main.fragment.store.adapter.StoreViewPagerAdapter;
import com.rock.mvplibrary.base.BaseFragment;

import butterknife.BindView;

public class StoreFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener {

    @BindView(R2.id.frag_store_rg)
    RadioGroup mRadioGroup;
    @BindView(R2.id.frag_store_vp)
    ViewPager mViewPager;
    private StoreViewPagerAdapter viewPagerAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.frag_store;
    }


    @Override
    public void initView() {
        mRadioGroup.setOnCheckedChangeListener(this);
        viewPagerAdapter = new StoreViewPagerAdapter(getChildFragmentManager(),null);
        mViewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.frag_store_rb_all:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.frag_store_rb_china:
//                mViewPager.setCurrentItem(1);
                break;
            case R.id.frag_store_rb_sea:
//                mViewPager.setCurrentItem(2);
                break;
            case R.id.frag_store_rb_beauty:
//                mViewPager.setCurrentItem(3);
                break;
        }
    }
}
