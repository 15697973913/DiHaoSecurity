package com.fengdi.baseproject.mvp.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.fengdi.baseproject.R
import com.fengdi.baseproject.di.component.DaggerMainComponent
import com.fengdi.baseproject.di.module.MainModule
import com.fengdi.baseproject.mvp.contract.MainContract
import com.fengdi.baseproject.mvp.presenter.MainPresenter
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils
import com.qmuiteam.qmui.util.QMUIStatusBarHelper
import com.tbruyelle.rxpermissions2.RxPermissions
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/05/2020 17:57


 * ================================================
 */
/**
 * 如果没presenter
 * 你可以这样写
 *
 * @ActivityScope(請注意命名空間) class NullObjectPresenterByActivity
 * @Inject constructor() : IPresenter {
 * override fun onStart() {
 * }
 *
 * override fun onDestroy() {
 * }
 * }
 */
class MainActivity : BaseActivity<MainPresenter>(), MainContract.View, BottomNavigationView.OnNavigationItemSelectedListener {

    @Inject
    lateinit var rxPermissions: RxPermissions



    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerMainComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .mainModule(MainModule(this))
                .build()
                .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_main //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        QMUIStatusBarHelper.translucent(this)

        //取消导航栏图标着色
        bottomNvgView.itemIconTintList = null
        //设置点击事件
        bottomNvgView.setOnNavigationItemSelectedListener(this)
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(bottomNvgView, navController)

        adjustNavigationIcoSize(bottomNvgView)

        QMUIStatusBarHelper.setStatusBarLightMode(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.bottomNvgView).navigateUp()
    }


    private fun adjustNavigationIcoSize(navigation: BottomNavigationView) {
        val menuView: BottomNavigationMenuView = navigation.getChildAt(0) as BottomNavigationMenuView
        for (i in 0 until menuView.childCount) {
            val iconView: View = menuView.getChildAt(i).findViewById(R.id.icon)
            val layoutParams: ViewGroup.LayoutParams = iconView.layoutParams
            val displayMetrics = resources.displayMetrics
            layoutParams.height = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20f, displayMetrics).toInt()
            layoutParams.width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20f, displayMetrics).toInt()
            iconView.layoutParams = layoutParams
        }
    }

    override fun getRxPermissions1(): RxPermissions {
        return rxPermissions
    }

    override fun getActivity(): Activity {
        return this
    }


    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showMessage(message: String) {
        ArmsUtils.snackbarText(message)
    }

    override fun launchActivity(intent: Intent) {
        ArmsUtils.startActivity(intent)
    }

    override fun killMyself() {
        finish()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return true
    }
}
