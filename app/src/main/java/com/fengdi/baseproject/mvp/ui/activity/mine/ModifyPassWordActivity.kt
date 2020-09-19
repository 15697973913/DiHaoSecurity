package com.fengdi.baseproject.mvp.ui.activity.mine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fengdi.baseproject.R
import com.fengdi.baseproject.di.component.DaggerModifyPassWordComponent
import com.fengdi.baseproject.di.module.ModifyPassWordModule
import com.fengdi.baseproject.mvp.contract.mine.ModifyPassWordContract
import com.fengdi.baseproject.mvp.presenter.mine.ModifyPassWordPresenter
import com.fengdi.baseproject.mvp.util.CountDownTimerUtils
import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import kotlinx.android.synthetic.main.activity_login.*


/**
 *
 *author: YangJie
 *email: 2295360491@qq.com
 *time: 2020/9/11 18:34
 * descripton: 修改手机号
 *
 *
 */
class ModifyPassWordActivity : BaseActivity<ModifyPassWordPresenter>(), ModifyPassWordContract.View {

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerModifyPassWordComponent.builder()
                .appComponent(appComponent)
                .modifyPassWordModule(ModifyPassWordModule(this))
                .build()
                .inject(this)
    }

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_modify_pass_word
    }

    override fun showMessage(message: String) {
    }
}