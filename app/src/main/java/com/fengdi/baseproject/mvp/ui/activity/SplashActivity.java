package com.fengdi.baseproject.mvp.ui.activity;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.fengdi.baseproject.R;
import com.fengdi.baseproject.app.constant.Constants;
import com.jess.arms.integration.AppManager;
import com.jess.arms.utils.ArmsDataHelper;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.bgabanner.BGABanner;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.bannerGuide)
    BGABanner bannerGuide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        //设置透明状态栏
        QMUIStatusBarHelper.translucent(this);


        boolean mIsNotFirst = ArmsDataHelper.getBooleanSF(this, Constants.APP_IS_FIRST, true);
//        if (mIsNotFirst) {//首次
//            BGALocalImageSize localImageSize = new BGALocalImageSize(1080, 1920, 320, 640);
//            // 设置数据源
//            bannerGuide.setData(localImageSize, ImageView.ScaleType.FIT_XY,
//                    R.mipmap.gui1,
//                    R.mipmap.gui2,
//                    R.mipmap.gui3,
//                    R.mipmap.gui4,
//                    R.mipmap.gui5,
//                    R.mipmap.gui6
//            );
//            initEvent();
//            ArmsDataHelper.setBooleanSF(this, Constants.APP_IS_FIRST, false);
//
//        } else {//非首次
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
//                    AppManager.getAppManager().startActivity(LoginActivity.class);
                    AppManager.getAppManager().startActivity(MainActivity.class);
                    finish();
                }
            }, 2000);
            bannerGuide.setBackgroundResource(R.mipmap.ic_main_splash);

//        }

    }

    private void initEvent() {
        bannerGuide.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == bannerGuide.getItemCount() - 1) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            AppManager.getAppManager().startActivity(LoginActivity.class);
                            finish();
                        }
                    }, 2000);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}