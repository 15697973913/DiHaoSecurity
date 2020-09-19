package com.fengdi.baseproject.mvp.ui.activity.home

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.fengdi.baseproject.di.component.DaggerDeviceGroupComponent
import com.fengdi.baseproject.di.module.DeviceGroupModule
import com.fengdi.baseproject.mvp.contract.home.DeviceGroupContract
import com.fengdi.baseproject.mvp.presenter.home.DeviceGroupPresenter

import com.fengdi.baseproject.R
import kotlinx.android.synthetic.main.activity_device_group.*


/**
 * Description: 设备分组
 * <p>
 * Created by YangJie on 09/18/2020 15:26
 *
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
class DeviceGroupActivity : BaseActivity<DeviceGroupPresenter>(), DeviceGroupContract.View {

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerDeviceGroupComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .deviceGroupModule(DeviceGroupModule(this))
                .build()
                .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_device_group //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        btConfirm.setOnClickListener {
            finish()
        }

        linGroup1.setOnClickListener {
            ivGroup1.setImageResource(R.drawable.ic_checkbox_yes)
            ivGroup2.setImageResource(R.drawable.ic_checkbox_no)

        }

        linGroup2.setOnClickListener {
            ivGroup1.setImageResource(R.drawable.ic_checkbox_no)
            ivGroup2.setImageResource(R.drawable.ic_checkbox_yes)
        }
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
