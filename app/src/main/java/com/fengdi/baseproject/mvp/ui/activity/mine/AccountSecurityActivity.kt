package com.fengdi.baseproject.mvp.ui.activity.mine

import android.content.Intent
import android.os.Bundle
import com.fengdi.baseproject.R
import com.fengdi.baseproject.di.component.DaggerAccountSecurityComponent
import com.fengdi.baseproject.di.module.AccountSecurityModule
import com.fengdi.baseproject.mvp.contract.mine.AccountSecurityContract
import com.fengdi.baseproject.mvp.presenter.mine.AccountSecurityPresenter
import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils
import kotlinx.android.synthetic.main.activity_account_security.*
import javax.inject.Inject

/**
 *
 *
 *author: YangJie
 *email: 2295360491@qq.com
 *time: 2020/9/11 17:47
 * descripton: 账号与安全
 *
 *
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
class AccountSecurityActivity : BaseActivity<AccountSecurityPresenter>(), AccountSecurityContract.View {


    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerAccountSecurityComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .accountSecurityModule(AccountSecurityModule(this))
                .build()
                .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_account_security //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        linPhone.setOnClickListener {
            launchActivity(Intent(this, ModifyPhoneActivity::class.java))
        }

        linPassword.setOnClickListener {
            launchActivity(Intent(this, ModifyPassWordActivity::class.java))
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
