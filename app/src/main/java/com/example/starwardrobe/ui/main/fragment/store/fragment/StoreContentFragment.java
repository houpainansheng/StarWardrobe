package com.example.starwardrobe.ui.main.fragment.store.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.starwardrobe.R;
import com.example.starwardrobe.R2;
import com.rock.mvplibrary.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/4/10.
 */

public class StoreContentFragment extends BaseFragment {

    @BindView(R2.id.store_content_rv)
    RecyclerView mRecyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.frag_store_content_frag;
    }

    @Override
    public void initView() {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
//        mRecyclerView.setAdapter();
    }
}
