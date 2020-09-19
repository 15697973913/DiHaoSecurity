package com.fengdi.baseproject.mvp.presenter.login

import android.app.Application
import com.fengdi.baseproject.mvp.contract.login.LoginContract
import com.fengdi.baseproject.mvp.ui.activity.MainActivity
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.http.imageloader.ImageLoader
import com.jess.arms.integration.AppManager
import com.jess.arms.mvp.BasePresenter
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject


@ActivityScope
class LoginPresenter
@Inject
constructor(model: LoginContract.Model, rootView: LoginContract.View) :
        BasePresenter<LoginContract.Model, LoginContract.View>(model, rootView) {
    @Inject
    lateinit var mErrorHandler: RxErrorHandler

    @Inject
    lateinit var mApplication: Application

    @Inject
    lateinit var mImageLoader: ImageLoader

    @Inject
    lateinit var mAppManager: AppManager

    override fun onDestroy() {
        super.onDestroy();
    }

    fun login(phone: String, password: String) {

        //扫一扫
        AppManager.getAppManager().startActivity(MainActivity::class.java)
//        AppManager.getAppManager().startActivity(MainActivity::class.java)

    }

}
