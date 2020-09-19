package com.fengdi.baseproject.mvp.presenter.mine

import android.app.Application
import com.fengdi.baseproject.mvp.contract.mine.ModifyPassWordContract
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.http.imageloader.ImageLoader
import com.jess.arms.integration.AppManager
import com.jess.arms.mvp.BasePresenter
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

@ActivityScope
class ModifyPassWordPresenter
@Inject
constructor(model: ModifyPassWordContract.Model, rootView: ModifyPassWordContract.View) :
        BasePresenter<ModifyPassWordContract.Model, ModifyPassWordContract.View>(model, rootView) {

    @Inject
    lateinit var mErrorHandler: RxErrorHandler

    @Inject
    lateinit var mApplication: Application

    @Inject
    lateinit var mImageLoader: ImageLoader

    @Inject
    lateinit var mAppManager: AppManager



}