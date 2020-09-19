package com.fengdi.baseproject.mvp.presenter.home

import android.app.Application

import com.jess.arms.integration.AppManager
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.mvp.BasePresenter
import com.jess.arms.http.imageloader.ImageLoader
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

import com.fengdi.baseproject.mvp.contract.home.RemoteUnLockContract


/**
 * Description:
 * <p>
 * Created by YangJie on 09/17/2020 18:48
 *
 * ================================================
 */
@ActivityScope
class RemoteUnLockPresenter
@Inject
constructor(model: RemoteUnLockContract.Model, rootView: RemoteUnLockContract.View) :
        BasePresenter<RemoteUnLockContract.Model, RemoteUnLockContract.View>(model, rootView) {
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
