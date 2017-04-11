package com.example.starwardrobe.ui.main.fragment.classify;

import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.starwardrobe.R;
import com.example.starwardrobe.bean.ClassifyBean;
import com.example.starwardrobe.ui.main.fragment.classify.adapter.ClassifyLeftAdapter;
import com.example.starwardrobe.ui.main.fragment.classify.adapter.ClassifyRightAdapter;
import com.example.starwardrobe.ui.main.fragment.classify.contract.ClassifyContract;
import com.example.starwardrobe.ui.main.fragment.classify.model.ClassifyModel;
import com.example.starwardrobe.ui.main.fragment.classify.presenter.ClassifyPresenter;
import com.rock.mvplibrary.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by 樊康 on 2017/4/5.
 */

public class ClassifyFragment extends BaseFragment implements ClassifyContract.ClassifyView {


    @BindView(R.id.classify_frag_head_search)
    Button mSearch;
    @BindView(R.id.classify_frag_head_shop)
    ImageView mShop;
    @BindView(R.id.classify_frag_left_list)
    ListView mLeftList;
    @BindView(R.id.classify_frag_right_grid)
    GridView mRightGrid;


    public static final String TAG = ClassifyFragment.class.getName();
    private ClassifyLeftAdapter leftAdapter;
    private ClassifyRightAdapter rightAdapter;
    private ClassifyPresenter mPresenter;
    private ClassifyModel mModel;

    @Override
    protected int getLayoutId() {
        return R.layout.frag_classify;
    }

    @Override
    public void initView() {
        mPresenter = new ClassifyPresenter();
        mModel = new ClassifyModel();
        mPresenter.setVM(this, mModel);


        mPresenter.init();

        //为左边的ListView设置数据

        leftAdapter = new ClassifyLeftAdapter(getActivity(), null, R.layout.classify_frag_left_listitem);
        mLeftList.setAdapter(leftAdapter);


        //为右边的GridView设置数据
        rightAdapter = new ClassifyRightAdapter(getActivity(), null, R.layout.classify_frag_right_listitem);
        mRightGrid.setAdapter(rightAdapter);
    }

    @Override
    public void getData(ClassifyBean data) {

        leftAdapter.updateRes(data.getData().getItems());

        rightAdapter.updateRes(data.getData().getItems().get(0).getComponent().getItems());
    }

    @Override
    public void onStartLoad() {

    }

    @Override
    public void onStopLoad() {

    }

    @Override
    public void onError(String errorInfo) {

    }


}
