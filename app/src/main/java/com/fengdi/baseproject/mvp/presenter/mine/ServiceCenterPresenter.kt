package com.fengdi.baseproject.mvp.presenter.mine

import android.app.Application

import com.jess.arms.integration.AppManager
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.mvp.BasePresenter
import com.jess.arms.http.imageloader.ImageLoader
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

import com.fengdi.baseproject.mvp.contract.mine.ServiceCenterContract


/**
 * Description:
 * <p>
 * Created by YangJie on 09/18/2020 17:56
 *
 * ================================================
 */
@ActivityScope
class ServiceCenterPresenter
@Inject
constructor(model: ServiceCenterContract.Model, rootView: ServiceCenterContract.View) :
        BasePresenter<ServiceCenterContract.Model, ServiceCenterContract.View>(model, rootView) {
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
