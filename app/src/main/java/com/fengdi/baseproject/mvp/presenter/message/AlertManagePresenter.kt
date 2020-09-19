package com.fengdi.baseproject.mvp.presenter.message

import android.app.Application

import com.jess.arms.integration.AppManager
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.mvp.BasePresenter
import com.jess.arms.http.imageloader.ImageLoader
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

import com.fengdi.baseproject.mvp.contract.message.AlertManageContract


/**
 * Description:
 * <p>
 * Created by YangJie on 09/15/2020 15:27
 *
 * ================================================
 */
@ActivityScope
class AlertManagePresenter
@Inject
constructor(model: AlertManageContract.Model, rootView: AlertManageContract.View) :
        BasePresenter<AlertManageContract.Model, AlertManageContract.View>(model, rootView) {
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
