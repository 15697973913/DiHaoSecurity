package com.fengdi.baseproject.mvp.ui.activity.mine

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.fengdi.baseproject.di.component.DaggerSelectMemberComponent
import com.fengdi.baseproject.di.module.SelectMemberModule
import com.fengdi.baseproject.mvp.contract.mine.SelectMemberContract
import com.fengdi.baseproject.mvp.presenter.mine.SelectMemberPresenter

import com.fengdi.baseproject.R
import com.fengdi.baseproject.mvp.ui.widget.MyToolBar
import kotlinx.android.synthetic.main.activity_select_member.*
import kotlinx.android.synthetic.main.activity_select_member.btConfirm
import kotlinx.android.synthetic.main.activity_select_member.ivGroup1
import kotlinx.android.synthetic.main.activity_select_member.ivGroup2
import kotlinx.android.synthetic.main.activity_select_member.linGroup1
import kotlinx.android.synthetic.main.activity_select_member.linGroup2

/**
 * Description:选择成员
 * <p>
 * Created by YangJie on 09/19/2020 11:30
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
class SelectMemberActivity : BaseActivity<SelectMemberPresenter>(), SelectMemberContract.View {

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerSelectMemberComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .selectMemberModule(SelectMemberModule(this))
                .build()
                .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_select_member //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        linGroup1.setOnClickListener {
            ivGroup1.setImageResource(R.drawable.ic_checkbox_yes)

        }

        linGroup2.setOnClickListener {
            ivGroup2.setImageResource(R.drawable.ic_checkbox_yes)
        }

        btConfirm.setOnClickListener {
            finish()
        }

        toolBar.setOnToolBarClickListener(object : MyToolBar.OnToolBarClick() {
            override fun onRightClick() {
                //添加
                launchActivity(Intent(this@SelectMemberActivity, AddMemberActivity::class.java))
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
