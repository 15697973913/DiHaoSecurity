package com.fengdi.baseproject.mvp.presenter.mine

import android.app.Application
import com.fengdi.baseproject.mvp.contract.mine.ModifyPhoneContract
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.http.imageloader.ImageLoader
import com.jess.arms.mvp.BasePresenter
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject


@ActivityScope
class ModifyPhonePresenter
@Inject
constructor(model: ModifyPhoneContract.Model, veiw: ModifyPhoneContract.View):BasePresenter<ModifyPhoneContract.Model,ModifyPhoneContract.View>(model,veiw) {

    @Inject
    lateinit var mErrorHandler: RxErrorHandler

    @Inject
    lateinit var mApplication: Application

    @Inject
    lateinit var mImageLoader: ImageLoader

    @Inject
    lateinit var mAppComponent: AppComponent



    override fun onDestroy() {
        super.onDestroy();
    }

}