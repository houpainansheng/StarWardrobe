package com.example.starwardrobe.ui.main.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.starwardrobe.R;
import com.example.starwardrobe.R2;
import com.example.starwardrobe.ui.main.fragment.classify.ClassifyFragment;
import com.example.starwardrobe.ui.main.fragment.fashion.FashionFragment;
import com.rock.mvplibrary.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    @BindView(R2.id.activity_main_button_home)
    RadioButton mStore;
    @BindView(R2.id.activity_main_button_class)
    RadioButton mClass;
    @BindView(R2.id.activity_main_button_bbs)
    RadioButton mBbs;
    @BindView(R2.id.activity_main_button_massage)
    RadioButton mMassage;
    @BindView(R2.id.activity_main_button_my)
    RadioButton mMy;
    @BindView(R.id.activity_main_group)
    RadioGroup mGroup;

    private Fragment mShowFragment;



    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        //设置RadioButton图片大小
//        Drawable drawableStore = getResources().getDrawable(R.drawable.main_rbtn_store_selector);
//        drawableStore.setBounds(0,0,50,50);
//        mStore.setCompoundDrawables(null,drawableStore,null,null);
//
//        Drawable drawableClass = getResources().getDrawable(R.drawable.main_rbtn_classification_selector);
//        drawableClass.setBounds(0,0,50,50);
//        mClass.setCompoundDrawables(null,drawableClass,null,null);
//
//        Drawable drawableBbs = getResources().getDrawable(R.drawable.main_rbtn_bbs_selector);
//        drawableBbs.setBounds(0,0,50,50);
//        mBbs.setCompoundDrawables(null,drawableBbs,null,null);
//
//        Drawable drawableMessage = getResources().getDrawable(R.drawable.main_rbtn_message_selector);
//        drawableMessage.setBounds(0,0,50,50);
//        mMassage.setCompoundDrawables(null,drawableMessage,null,null);
//
//        Drawable drawableMy = getResources().getDrawable(R.drawable.main_rbtn_my_selector);
//        drawableMy.setBounds(0,0,50,50);
//        mMy.setCompoundDrawables(null,drawableMy,null,null);

mGroup.setOnCheckedChangeListener(this);

    }




    private void switchPage(String tag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        // 隐藏当前显示的页面
        if (mShowFragment != null) {
            transaction.hide(mShowFragment);
        }
        // 去缓存中查找
        mShowFragment = fm.findFragmentByTag(tag);
        if (mShowFragment != null) {
            transaction.show(mShowFragment);
        }else{
            try {
                mShowFragment = (Fragment) Class.forName(tag).newInstance();
                transaction.add(R.id.activity_main_frame,mShowFragment,tag);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        transaction.commit();
    }


    private boolean isExit;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // 条件
            if (!isExit){
                Toast toast = Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                isExit = true;
                // 还原标志位状态
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        // delay之后执行的代码
                        isExit = false;
                    }
                },2 * 1000);
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {
            case R.id.activity_main_button_home:

                Toast.makeText(this, "点击了商城", Toast.LENGTH_SHORT).show();

                break;

            case R.id.activity_main_button_class:
                Toast.makeText(this, "点击了分类", Toast.LENGTH_SHORT).show();
                switchPage(ClassifyFragment.TAG);
                break;

            case R.id.activity_main_button_bbs:
                Toast.makeText(this, "点击了时尚圈", Toast.LENGTH_SHORT).show();

                switchPage(FashionFragment.TAG);
                break;

            case R.id.activity_main_button_massage:
                Toast.makeText(this, "点击了消息", Toast.LENGTH_SHORT).show();

                break;

            case R.id.activity_main_button_my:
                Toast.makeText(this, "点击了我的", Toast.LENGTH_SHORT).show();
            break;
        }
    }
}
