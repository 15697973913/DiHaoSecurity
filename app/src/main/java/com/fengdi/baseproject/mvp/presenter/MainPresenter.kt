package com.fengdi.baseproject.mvp.presenter

import android.app.Application
import androidx.core.app.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.fengdi.baseproject.mvp.contract.MainContract
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.http.imageloader.ImageLoader
import com.jess.arms.integration.AppManager
import com.jess.arms.mvp.BasePresenter
import com.jess.arms.utils.ArmsPermissionUtil
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/05/2020 17:57
 * ================================================
 */
@ActivityScope
class MainPresenter
@Inject
constructor(model: MainContract.Model, rootView: MainContract.View) :
        BasePresenter<MainContract.Model, MainContract.View>(model, rootView) {
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

    /**
     * 使用 2017 Google IO 发布的 Architecture Components 中的 Lifecycles 的新特性 (此特性已被加入 Support library)
     * 使 `Presenter` 可以与 [ComponentActivity] 和 [Fragment] 的部分生命周期绑定
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        requestDevice() //打开 App 时自动加载列表
    }

    private fun requestDevice() {
        //请求外部存储权限用于适配android6.0的权限管理机制
        ArmsPermissionUtil.externalStorage(object : ArmsPermissionUtil.RequestPermission {
            override fun onRequestPermissionSuccess() {
                //request permission success, do something.
            }

            override fun onRequestPermissionFailure(permissions: List<String>) {
                mRootView.showMessage("Request permissions failure")
                mRootView.hideLoading() //隐藏下拉刷新的进度条
            }

            override fun onRequestPermissionFailureWithAskNeverAgain(permissions: List<String>) {
                mRootView.showMessage("Need to go to the settings")
                mRootView.hideLoading() //隐藏下拉刷新的进度条
            }
        }, mRootView.getRxPermissions1(), mErrorHandler)
    }

}
