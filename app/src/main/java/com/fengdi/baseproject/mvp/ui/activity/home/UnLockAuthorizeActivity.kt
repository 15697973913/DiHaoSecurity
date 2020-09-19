package com.fengdi.baseproject.mvp.ui.activity.home

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.fengdi.baseproject.di.component.DaggerUnLockAuthorizeComponent
import com.fengdi.baseproject.di.module.UnLockAuthorizeModule
import com.fengdi.baseproject.mvp.contract.home.UnLockAuthorizeContract
import com.fengdi.baseproject.mvp.presenter.home.UnLockAuthorizePresenter

import com.fengdi.baseproject.R
import com.fengdi.baseproject.app.entity.AuthorizeRecordBean
import com.fengdi.baseproject.mvp.ui.activity.GeneratePassWordActivity
import com.fengdi.baseproject.mvp.ui.adapter.AlertMessageAdapter
import com.fengdi.baseproject.mvp.ui.adapter.AuthorizeRecordAdapter
import kotlinx.android.synthetic.main.activity_alert_manage.*
import kotlinx.android.synthetic.main.activity_un_lock_authorize.*


/**
 * Description://开锁授权界面
 * <p>
 * Created by YangJie on 09/17/2020 17:22
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
class UnLockAuthorizeActivity : BaseActivity<UnLockAuthorizePresenter>(), UnLockAuthorizeContract.View {

    var authorizeRecord = mutableListOf<AuthorizeRecordBean>()

    var alertMessageAdapter = AuthorizeRecordAdapter(authorizeRecord)

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerUnLockAuthorizeComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .unLockAuthorizeModule(UnLockAuthorizeModule(this))
                .build()
                .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_un_lock_authorize //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        authorizeRecord.add(AuthorizeRecordBean("哈哈哈", 1, 1, "aaa", 0))
        authorizeRecord.add(AuthorizeRecordBean("哈哈哈", 1, 1, "aaa", 0))
        authorizeRecord.add(AuthorizeRecordBean("哈哈哈", 1, 1, "aaa", 0))
        authorizeRecord.add(AuthorizeRecordBean("哈哈哈", 1, 1, "aaa", 0))
        authorizeRecord.add(AuthorizeRecordBean("哈哈哈", 1, 1, "aaa", 0))
        authorizeRecord.add(AuthorizeRecordBean("哈哈哈", 1, 1, "aaa", 0))
        authorizeRecord.add(AuthorizeRecordBean("哈哈哈", 1, 1, "aaa", 0))
        authorizeRecord.add(AuthorizeRecordBean("哈哈哈", 1, 1, "aaa", 0))
        rcyAuthorizeRecord.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rcyAuthorizeRecord.adapter = alertMessageAdapter

        btGenerate.setOnClickListener {
            launchActivity(Intent(this, GeneratePassWordActivity::class.java))
        }
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
