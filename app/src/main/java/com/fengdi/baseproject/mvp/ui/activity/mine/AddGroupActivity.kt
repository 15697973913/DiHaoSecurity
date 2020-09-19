package com.fengdi.baseproject.mvp.ui.activity.mine

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.fengdi.baseproject.di.component.DaggerAddGroupComponent
import com.fengdi.baseproject.di.module.AddGroupModule
import com.fengdi.baseproject.mvp.contract.mine.AddGroupContract
import com.fengdi.baseproject.mvp.presenter.mine.AddGroupPresenter

import com.fengdi.baseproject.R
import com.fengdi.baseproject.mvp.ui.widget.MyToolBar
import kotlinx.android.synthetic.main.activity_add_group.*
import kotlinx.android.synthetic.main.activity_add_group.toolBar
import kotlinx.android.synthetic.main.activity_my_group.*


/**
 * Description:
 * <p>
 * Created by YangJie on 09/19/2020 10:37
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
class AddGroupActivity : BaseActivity<AddGroupPresenter>(), AddGroupContract.View {

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerAddGroupComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .addGroupModule(AddGroupModule(this))
                .build()
                .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_add_group //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {

        toolBar.setOnToolBarClickListener(object : MyToolBar.OnToolBarClick() {
            override fun onRightClick() {
                finish()
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
