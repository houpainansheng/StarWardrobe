package com.example.starwardrobe.ui.main.fragment.store.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.starwardrobe.ui.main.fragment.store.fragment.StoreContentFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/10.
 */

public class StoreViewPagerAdapter extends FragmentPagerAdapter {

    private List<StoreContentFragment> data;

    public StoreViewPagerAdapter(FragmentManager fm,List<StoreContentFragment> data) {
        super(fm);
        if (data != null) {
            this.data = new ArrayList<>();
            this.data = data;
        }

    }

    @Override
    public StoreContentFragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }
}
