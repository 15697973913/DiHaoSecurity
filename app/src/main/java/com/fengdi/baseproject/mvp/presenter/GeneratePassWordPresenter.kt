package com.fengdi.baseproject.mvp.presenter

import android.app.Application

import com.jess.arms.integration.AppManager
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.mvp.BasePresenter
import com.jess.arms.http.imageloader.ImageLoader
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

import com.fengdi.baseproject.mvp.contract.GeneratePassWordContract


/**
 * Description:
 * <p>
 * Created by YangJie on 09/19/2020 14:29
 *
 * ================================================
 */
@ActivityScope
class GeneratePassWordPresenter
@Inject
constructor(model: GeneratePassWordContract.Model, rootView: GeneratePassWordContract.View) :
        BasePresenter<GeneratePassWordContract.Model, GeneratePassWordContract.View>(model, rootView) {
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
