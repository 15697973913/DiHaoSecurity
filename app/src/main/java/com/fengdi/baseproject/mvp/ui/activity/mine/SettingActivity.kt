package com.fengdi.baseproject.mvp.ui.activity.mine

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.fengdi.baseproject.di.component.DaggerSettingComponent
import com.fengdi.baseproject.di.module.SettingModule
import com.fengdi.baseproject.mvp.contract.mine.SettingContract
import com.fengdi.baseproject.mvp.presenter.mine.SettingPresenter

import com.fengdi.baseproject.R
import kotlinx.android.synthetic.main.activity_setting.*


/**
 *
 *author: YangJie
 *email: 2295360491@qq.com
 *time: 2020/9/11 17:42
 * descripton: 设置界面
 *
 *
 */

class SettingActivity : BaseActivity<SettingPresenter>(), SettingContract.View {

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerSettingComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .settingModule(SettingModule(this))
                .build()
                .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_setting //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        linUserData.setOnClickListener {
            //用户信息
            launchActivity(Intent(this, MyDataActivity::class.java))
        }

        tvAccountSecurity.setOnClickListener {
            //账号与安全
            launchActivity(Intent(this, AccountSecurityActivity::class.java))
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
