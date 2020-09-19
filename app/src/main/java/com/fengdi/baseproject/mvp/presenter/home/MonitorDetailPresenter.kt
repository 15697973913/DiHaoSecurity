package com.fengdi.baseproject.mvp.presenter.home

import android.app.Application

import com.jess.arms.integration.AppManager
import com.jess.arms.di.scope.FragmentScope
import com.jess.arms.mvp.BasePresenter
import com.jess.arms.http.imageloader.ImageLoader
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

import com.fengdi.baseproject.mvp.contract.home.MonitorDetailContract


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/10/2020 10:17
 

 * ================================================
 */
@FragmentScope
class MonitorDetailPresenter
@Inject
constructor(model: MonitorDetailContract.Model, rootView: MonitorDetailContract.View) :
        BasePresenter<MonitorDetailContract.Model, MonitorDetailContract.View>(model, rootView) {
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
