package com.fengdi.baseproject.mvp.presenter.mine

import android.app.Application
import com.fengdi.baseproject.mvp.contract.mine.MyDevicesContrace
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.http.imageloader.ImageLoader
import com.jess.arms.integration.AppManager
import com.jess.arms.mvp.BasePresenter
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject


@ActivityScope
class MyDevicesPresenter
@Inject
constructor(model: MyDevicesContrace.Model, view: MyDevicesContrace.View) :
        BasePresenter<MyDevicesContrace.Model, MyDevicesContrace.View>(model, view) {

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