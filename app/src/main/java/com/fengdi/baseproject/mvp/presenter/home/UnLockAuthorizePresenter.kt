package com.fengdi.baseproject.mvp.presenter.home

import android.app.Application

import com.jess.arms.integration.AppManager
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.mvp.BasePresenter
import com.jess.arms.http.imageloader.ImageLoader
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

import com.fengdi.baseproject.mvp.contract.home.UnLockAuthorizeContract


/**
 * Description:
 * <p>
 * Created by YangJie on 09/17/2020 17:22
 *
 * ================================================
 */
@ActivityScope
class UnLockAuthorizePresenter
@Inject
constructor(model: UnLockAuthorizeContract.Model, rootView: UnLockAuthorizeContract.View) :
        BasePresenter<UnLockAuthorizeContract.Model, UnLockAuthorizeContract.View>(model, rootView) {
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
