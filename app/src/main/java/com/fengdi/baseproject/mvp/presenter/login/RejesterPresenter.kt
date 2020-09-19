package com.fengdi.baseproject.mvp.presenter.login

import android.app.Application

import com.jess.arms.integration.AppManager
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.mvp.BasePresenter
import com.jess.arms.http.imageloader.ImageLoader
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

import com.fengdi.baseproject.mvp.contract.login.RejesterContract


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/11/2020 14:22


 * ================================================
 */
@ActivityScope
class RejesterPresenter
@Inject
constructor(model: RejesterContract.Model, rootView: RejesterContract.View) :
        BasePresenter<RejesterContract.Model, RejesterContract.View>(model, rootView) {
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
