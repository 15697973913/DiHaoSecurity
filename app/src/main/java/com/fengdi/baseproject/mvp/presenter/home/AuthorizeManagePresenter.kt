package com.fengdi.baseproject.mvp.presenter.home

import android.app.Application

import com.jess.arms.integration.AppManager
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.mvp.BasePresenter
import com.jess.arms.http.imageloader.ImageLoader
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

import com.fengdi.baseproject.mvp.contract.home.AuthorizeManageContract


/**
 * Description:
 * <p>
 * Created by YangJie on 09/18/2020 14:50
 *
 * ================================================
 */
@ActivityScope
class AuthorizeManagePresenter
@Inject
constructor(model: AuthorizeManageContract.Model, rootView: AuthorizeManageContract.View) :
        BasePresenter<AuthorizeManageContract.Model, AuthorizeManageContract.View>(model, rootView) {
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
}
