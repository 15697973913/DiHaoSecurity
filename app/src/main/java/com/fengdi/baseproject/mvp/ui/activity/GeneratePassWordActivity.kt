package com.fengdi.baseproject.mvp.ui.activity

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.fengdi.baseproject.di.component.DaggerGeneratePassWordComponent
import com.fengdi.baseproject.di.module.GeneratePassWordModule
import com.fengdi.baseproject.mvp.contract.GeneratePassWordContract
import com.fengdi.baseproject.mvp.presenter.GeneratePassWordPresenter

import com.fengdi.baseproject.R
import com.jess.arms.utils.ArmsToast
import kotlinx.android.synthetic.main.activity_generate_pass_word.*


/**
 * Description:
 * <p>
 * Created by YangJie on 09/19/2020 14:29
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
class GeneratePassWordActivity : BaseActivity<GeneratePassWordPresenter>(), GeneratePassWordContract.View {

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerGeneratePassWordComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .generatePassWordModule(GeneratePassWordModule(this))
                .build()
                .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_generate_pass_word //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        tvCopyPassWord.setOnClickListener {
            ArmsToast.show("复制成功")
            finish()
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
