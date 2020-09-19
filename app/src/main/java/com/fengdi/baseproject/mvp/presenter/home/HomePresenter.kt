package com.fengdi.baseproject.mvp.presenter.home

import android.app.Application
import androidx.core.app.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.fengdi.baseproject.app.entity.MonitorBean
import com.fengdi.baseproject.app.entity.SmartLockBean
import com.fengdi.baseproject.mvp.contract.home.HomeContract
import com.jess.arms.di.scope.FragmentScope
import com.jess.arms.http.imageloader.ImageLoader
import com.jess.arms.integration.AppManager
import com.jess.arms.mvp.BasePresenter
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/07/2020 16:27


 * ================================================
 */
@FragmentScope
class HomePresenter
@Inject
constructor(model: HomeContract.Model, rootView: HomeContract.View) :
        BasePresenter<HomeContract.Model, HomeContract.View>(model, rootView) {
    @Inject
    lateinit var mErrorHandler: RxErrorHandler

    @Inject
    lateinit var mApplication: Application

    @Inject
    lateinit var mImageLoader: ImageLoader

    @Inject
    lateinit var mAppManager: AppManager


    /**
     * 智能锁列表
     */
    @Inject
    lateinit var smartLockList: MutableList<SmartLockBean>

    /**
     * 监控设备列表
     */
    @Inject
    lateinit var monitorList: MutableList<MonitorBean>


    /**
     * 使用 2017 Google IO 发布的 Architecture Components 中的 Lifecycles 的新特性 (此特性已被加入 Support library)
     * 使 `Presenter` 可以与 [ComponentActivity] 和 [Fragment] 的部分生命周期绑定
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onCreate() {
        requestDeviceList() //打开 App 时自动加载列表
    }

    private fun requestDeviceList() {

        smartLockList.add(SmartLockBean("厨房", 1, 212, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1599546968539&di=9c5e2a6706ce8a50972f43efd3f2c950&imgtype=0&src=http%3A%2F%2Fgoods.tiaodao.com%2Fimage%2Fcache%2Fcatalog%2F20170330%2F112-2048x2048.jpg", 1))
        smartLockList.add(SmartLockBean("厕所", 0, 2212, "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3617443108,3467474169&fm=26&gp=0.jpg", 1))
        smartLockList.add(SmartLockBean("公司", 0, 2152, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1599547002796&di=11762fdfc28bb0940941c61312b12b89&imgtype=0&src=http%3A%2F%2Fimg1.imgtn.bdimg.com%2Fit%2Fu%3D2222959491%2C4153852580%26fm%3D214%26gp%3D0.jpg", 0))

        monitorList.add(MonitorBean(1, 1, "厨房", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1599546968539&di=9c5e2a6706ce8a50972f43efd3f2c950&imgtype=0&src=http%3A%2F%2Fgoods.tiaodao.com%2Fimage%2Fcache%2Fcatalog%2F20170330%2F112-2048x2048.jpg"))
        monitorList.add(MonitorBean(2, 1, "厕所", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3617443108,3467474169&fm=26&gp=0.jpg"))
        monitorList.add(MonitorBean(3, 0, "公司", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1599547002796&di=11762fdfc28bb0940941c61312b12b89&imgtype=0&src=http%3A%2F%2Fimg1.imgtn.bdimg.com%2Fit%2Fu%3D2222959491%2C4153852580%26fm%3D214%26gp%3D0.jpg"))

    }


    override fun onDestroy() {
        super.onDestroy();
    }



}
