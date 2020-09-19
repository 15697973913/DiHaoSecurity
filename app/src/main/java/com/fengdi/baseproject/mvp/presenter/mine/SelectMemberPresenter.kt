package com.fengdi.baseproject.mvp.presenter.mine

import android.app.Application

import com.jess.arms.integration.AppManager
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.mvp.BasePresenter
import com.jess.arms.http.imageloader.ImageLoader
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

import com.fengdi.baseproject.mvp.contract.mine.SelectMemberContract


/**
 * Description:
 * <p>
 * Created by YangJie on 09/19/2020 11:30
 *
 * ================================================
 */
@ActivityScope
class SelectMemberPresenter
@Inject
constructor(model: SelectMemberContract.Model, rootView: SelectMemberContract.View) :
        BasePresenter<SelectMemberContract.Model, SelectMemberContract.View>(model, rootView) {
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
