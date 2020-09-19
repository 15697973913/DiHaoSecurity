package com.fengdi.baseproject.mvp.ui.activity.message

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.fengdi.baseproject.di.component.DaggerUnLockMessageComponent
import com.fengdi.baseproject.di.module.UnLockMessageModule
import com.fengdi.baseproject.mvp.contract.message.UnLockMessageContract
import com.fengdi.baseproject.mvp.presenter.message.UnLockMessagePresenter

import com.fengdi.baseproject.R
import com.fengdi.baseproject.app.entity.UnLockMessageBean
import com.fengdi.baseproject.mvp.ui.adapter.UnLockMessageAdapter
import kotlinx.android.synthetic.main.activity_un_lock_message.*


/**
 * Description:
 * <p>
 * Created by YangJie on 09/15/2020 14:25
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
class UnLockMessageActivity : BaseActivity<UnLockMessagePresenter>(), UnLockMessageContract.View {

    var unLockMessages = mutableListOf<UnLockMessageBean>()

    var unLockMessageAdapter = UnLockMessageAdapter(unLockMessages)

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerUnLockMessageComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .unLockMessageModule(UnLockMessageModule(this))
                .build()
                .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_un_lock_message //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        unLockMessages.add(UnLockMessageBean("哈哈哈",1,1,"aaa",0))
        unLockMessages.add(UnLockMessageBean("哈哈哈",1,1,"aaa",0))
        unLockMessages.add(UnLockMessageBean("哈哈哈",1,1,"aaa",0))
        unLockMessages.add(UnLockMessageBean("哈哈哈",1,1,"aaa",0))
        unLockMessages.add(UnLockMessageBean("哈哈哈",1,1,"aaa",0))
        unLockMessages.add(UnLockMessageBean("哈哈哈",1,1,"aaa",0))
        unLockMessages.add(UnLockMessageBean("哈哈哈",1,1,"aaa",0))
        unLockMessages.add(UnLockMessageBean("哈哈哈",1,1,"aaa",0))
        rcyUnLockMessage.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rcyUnLockMessage.adapter = unLockMessageAdapter
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
