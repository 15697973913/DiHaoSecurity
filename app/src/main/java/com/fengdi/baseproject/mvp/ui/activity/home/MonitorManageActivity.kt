package com.fengdi.baseproject.mvp.ui.activity.home

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.fengdi.baseproject.di.component.DaggerMonitorManageComponent
import com.fengdi.baseproject.di.module.MonitorManageModule
import com.fengdi.baseproject.mvp.contract.home.MonitorManageContract
import com.fengdi.baseproject.mvp.presenter.home.MonitorManagePresenter

import com.fengdi.baseproject.R


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/10/2020 11:36
 

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
class MonitorManageActivity : BaseActivity<MonitorManagePresenter>(), MonitorManageContract.View {

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerMonitorManageComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .monitorManageModule(MonitorManageModule(this))
                .build()
                .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_monitor_manage //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {

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
}
