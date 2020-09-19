package com.fengdi.baseproject.mvp.ui.activity.home

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fengdi.baseproject.R
import com.fengdi.baseproject.app.entity.AuthorizeManageBean
import com.fengdi.baseproject.di.component.DaggerAuthorizeManageComponent
import com.fengdi.baseproject.di.module.AuthorizeManageModule
import com.fengdi.baseproject.mvp.contract.home.AuthorizeManageContract
import com.fengdi.baseproject.mvp.presenter.home.AuthorizeManagePresenter
import com.fengdi.baseproject.mvp.ui.activity.mine.SelectMemberActivity
import com.fengdi.baseproject.mvp.ui.adapter.AuthorizeManageAdapter
import com.fengdi.baseproject.mvp.ui.widget.MyToolBar
import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils
import kotlinx.android.synthetic.main.activity_authorize_manage.*


/**
 * Description:授权管理界面
 * <p>
 * Created by YangJie on 09/18/2020 14:50
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
class AuthorizeManageActivity : BaseActivity<AuthorizeManagePresenter>(), AuthorizeManageContract.View {

    var authorizeManageList = mutableListOf<AuthorizeManageBean>()

    var authorizeManageAdapter = AuthorizeManageAdapter(authorizeManageList)

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerAuthorizeManageComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .authorizeManageModule(AuthorizeManageModule(this))
                .build()
                .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_authorize_manage //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {

        authorizeManageList.add(AuthorizeManageBean("哈哈哈", 1, 1, "aaa", 0))
        authorizeManageList.add(AuthorizeManageBean("哈哈哈", 1, 1, "aaa", 0))
        authorizeManageList.add(AuthorizeManageBean("哈哈哈", 1, 1, "aaa", 0))
        authorizeManageList.add(AuthorizeManageBean("哈哈哈", 1, 1, "aaa", 0))
        authorizeManageList.add(AuthorizeManageBean("哈哈哈", 1, 1, "aaa", 0))
        authorizeManageList.add(AuthorizeManageBean("哈哈哈", 1, 1, "aaa", 0))
        authorizeManageList.add(AuthorizeManageBean("哈哈哈", 1, 1, "aaa", 0))
        authorizeManageList.add(AuthorizeManageBean("哈哈哈", 1, 1, "aaa", 0))
        rcyAuthorizeManage.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rcyAuthorizeManage.adapter = authorizeManageAdapter

        toolBar.setOnToolBarClickListener(object : MyToolBar.OnToolBarClick() {
            override fun onRightClick() {
                //选择成员
                launchActivity(Intent(this@AuthorizeManageActivity, SelectMemberActivity::class.java))
            }
        })
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
