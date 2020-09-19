package com.fengdi.baseproject.mvp.presenter.message

import android.app.Application

import com.jess.arms.integration.AppManager
import com.jess.arms.di.scope.FragmentScope
import com.jess.arms.mvp.BasePresenter
import com.jess.arms.http.imageloader.ImageLoader
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

import com.fengdi.baseproject.mvp.contract.message.MessageContract


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/07/2020 15:12


 * ================================================
 */
@FragmentScope
class MessagePresenter
@Inject
constructor(model: MessageContract.Model, rootView: MessageContract.View) :
        BasePresenter<MessageContract.Model, MessageContract.View>(model, rootView) {
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
