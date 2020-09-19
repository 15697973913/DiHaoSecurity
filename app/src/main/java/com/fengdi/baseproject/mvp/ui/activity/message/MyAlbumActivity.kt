package com.fengdi.baseproject.mvp.ui.activity.message

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.fengdi.baseproject.di.component.DaggerMyAlbumComponent
import com.fengdi.baseproject.di.module.MyAlbumModule
import com.fengdi.baseproject.mvp.contract.message.MyAlbumContract
import com.fengdi.baseproject.mvp.presenter.message.MyAlbumPresenter

import com.fengdi.baseproject.R


/**
 * Description:
 * <p>
 * Created by YangJie on 09/16/2020 16:11
 *
 * ================================================
 */
/**
 * 如果没presenter
 * 你可以这样写
 *
 * @ActivityScope(請注意命名空間) class NullObjectPresenterByActivity
 * @Inject constructor() : IPresenter {
 * override fun onStart() {
 * }
 *
 * override fun onDestroy() {
 * }
 * }
 */
class MyAlbumActivity : BaseActivity<MyAlbumPresenter>(), MyAlbumContract.View {

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerMyAlbumComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .myAlbumModule(MyAlbumModule(this))
                .build()
                .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_my_album //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {

    }


    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showMessage(message: String) {
        ArmsUtils.snackbarText(message)
    }

    override fun launchActivity(intent: Intent) {
        ArmsUtils.startActivity(intent)
    }

    override fun killMyself() {
        finish()
    }
}
