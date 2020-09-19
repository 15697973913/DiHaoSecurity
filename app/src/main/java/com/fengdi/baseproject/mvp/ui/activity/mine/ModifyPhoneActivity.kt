package com.fengdi.baseproject.mvp.ui.activity.mine

import android.os.Bundle
import com.fengdi.baseproject.R
import com.fengdi.baseproject.di.component.DaggerModifyPhoneComponent
import com.fengdi.baseproject.di.module.ModifyPhoneModule
import com.fengdi.baseproject.mvp.contract.mine.ModifyPhoneContract
import com.fengdi.baseproject.mvp.presenter.mine.ModifyPhonePresenter
import com.fengdi.baseproject.mvp.util.CountDownTimerUtils
import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import kotlinx.android.synthetic.main.activity_login.*

class ModifyPhoneActivity : BaseActivity<ModifyPhonePresenter>(), ModifyPhoneContract.View {

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerModifyPhoneComponent.builder()
                .appComponent(appComponent)
                .modifyPhoneModule(ModifyPhoneModule(this))
                .build()
                .inject(this)
    }

    override fun initData(savedInstanceState: Bundle?) {
        getSmsCode.setOnClickListener {
            CountDownTimerUtils(getSmsCode, 60000, 1000).start()
        }
    }

    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_modify_phone
    }

    override fun showMessage(message: String) {
        TODO("Not yet implemented")
    }
}