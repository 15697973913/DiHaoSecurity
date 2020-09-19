package com.fengdi.baseproject.mvp.presenter.message

import android.app.Application

import com.jess.arms.integration.AppManager
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.mvp.BasePresenter
import com.jess.arms.http.imageloader.ImageLoader
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

import com.fengdi.baseproject.mvp.contract.message.MyVideoContract


/**
 * Description:
 * <p>
 * Created by YangJie on 09/16/2020 16:18
 *
 * ================================================
 */
@ActivityScope
class MyVideoPresenter
@Inject
constructor(model: MyVideoContract.Model, rootView: MyVideoContract.View) :
        BasePresenter<MyVideoContract.Model, MyVideoContract.View>(model, rootView) {
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
