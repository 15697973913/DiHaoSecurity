package com.fengdi.baseproject.mvp.ui.activity

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import butterknife.BindView
import butterknife.ButterKnife
import cn.bingoogolapple.bgabanner.BGABanner
import com.fengdi.baseproject.R
import com.fengdi.baseproject.app.constant.Constants
import com.fengdi.baseproject.mvp.ui.activity.login.LoginActivity
import com.jess.arms.integration.AppManager
import com.jess.arms.utils.ArmsDataHelper
import com.qmuiteam.qmui.util.QMUIStatusBarHelper

class SplashActivity : AppCompatActivity() {
    @JvmField
    @BindView(R.id.bannerGuide)
    var bannerGuide: BGABanner? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        ButterKnife.bind(this)

        //设置透明状态栏
        QMUIStatusBarHelper.translucent(this)
        val mIsNotFirst = ArmsDataHelper.getBooleanSF(this, Constants.APP_IS_FIRST, true)
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
        Handler().postDelayed({ //
            AppManager.getAppManager().startActivity(LoginActivity::class.java)
//            AppManager.getAppManager().startActivity(MainActivity::class.java)
            finish()
        }, 2000)
        bannerGuide!!.setBackgroundResource(R.mipmap.ic_main_splash)

//        }
    }

    private fun initEvent() {
        bannerGuide!!.setOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {
                if (position == bannerGuide!!.itemCount - 1) {
                    Handler().postDelayed({
                        AppManager.getAppManager().startActivity(LoginActivity::class.java)
                        finish()
                    }, 2000)
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }
}