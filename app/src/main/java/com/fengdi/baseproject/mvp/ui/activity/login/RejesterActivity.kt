package com.fengdi.baseproject.mvp.ui.activity.login

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.fengdi.baseproject.di.component.DaggerRejesterComponent
import com.fengdi.baseproject.di.module.RejesterModule
import com.fengdi.baseproject.mvp.contract.login.RejesterContract
import com.fengdi.baseproject.mvp.presenter.login.RejesterPresenter

import com.fengdi.baseproject.R
import com.fengdi.baseproject.mvp.util.CountDownTimerUtils
import kotlinx.android.synthetic.main.activity_login.*


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/11/2020 14:22
 

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
class RejesterActivity : BaseActivity<RejesterPresenter>(), RejesterContract.View {

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerRejesterComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .rejesterModule(RejesterModule(this))
                .build()
                .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_rejester //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {

        //数字获取验证码
        getSmsCode.setOnClickListener {
            CountDownTimerUtils(getSmsCode, 60000, 1000).start()
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
