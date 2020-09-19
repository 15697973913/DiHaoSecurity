package com.fengdi.baseproject.mvp.presenter.mine

import android.app.Application

import com.jess.arms.integration.AppManager
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.mvp.BasePresenter
import com.jess.arms.http.imageloader.ImageLoader
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

import com.fengdi.baseproject.mvp.contract.mine.MyDataContract


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/11/2020 16:29
 

 * ================================================
 */
@ActivityScope
class MyDataPresenter
@Inject
constructor(model: MyDataContract.Model, rootView: MyDataContract.View) :
        BasePresenter<MyDataContract.Model, MyDataContract.View>(model, rootView) {
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
