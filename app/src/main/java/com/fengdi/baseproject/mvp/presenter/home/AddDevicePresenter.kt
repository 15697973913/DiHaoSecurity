package com.fengdi.baseproject.mvp.presenter.home

import android.app.Application

import com.jess.arms.integration.AppManager
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.mvp.BasePresenter
import com.jess.arms.http.imageloader.ImageLoader
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

import com.fengdi.baseproject.mvp.contract.home.AddDeviceContract


/**
 * Description: 添加设备界面
 * <p>
 * Created by YangJie on 09/17/2020 11:16
 *
 * ================================================
 */
@ActivityScope
class AddDevicePresenter
@Inject
constructor(model: AddDeviceContract.Model, rootView: AddDeviceContract.View) :
        BasePresenter<AddDeviceContract.Model, AddDeviceContract.View>(model, rootView) {
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
