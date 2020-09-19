package com.fengdi.baseproject.mvp.ui.activity.message

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fengdi.baseproject.R
import com.fengdi.baseproject.app.entity.AlertMessageBean
import com.fengdi.baseproject.di.component.DaggerAlertManageComponent
import com.fengdi.baseproject.di.module.AlertManageModule
import com.fengdi.baseproject.mvp.contract.message.AlertManageContract
import com.fengdi.baseproject.mvp.presenter.message.AlertManagePresenter
import com.fengdi.baseproject.mvp.ui.adapter.AlertMessageAdapter
import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils
import kotlinx.android.synthetic.main.activity_alert_manage.*


/**
 * Description:报警消息界面
 * <p>
 * Created by YangJie on 09/15/2020 15:27
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
class AlertManageActivity : BaseActivity<AlertManagePresenter>(), AlertManageContract.View {

    var unLockMessages = mutableListOf<AlertMessageBean>()

    var alertMessageAdapter = AlertMessageAdapter(unLockMessages)

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerAlertManageComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .alertManageModule(AlertManageModule(this))
                .build()
                .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_alert_manage //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        unLockMessages.add(AlertMessageBean("哈哈哈",1,1,"aaa",0))
        unLockMessages.add(AlertMessageBean("哈哈哈",1,1,"aaa",0))
        unLockMessages.add(AlertMessageBean("哈哈哈",1,1,"aaa",0))
        unLockMessages.add(AlertMessageBean("哈哈哈",1,1,"aaa",0))
        unLockMessages.add(AlertMessageBean("哈哈哈",1,1,"aaa",0))
        unLockMessages.add(AlertMessageBean("哈哈哈",1,1,"aaa",0))
        unLockMessages.add(AlertMessageBean("哈哈哈",1,1,"aaa",0))
        unLockMessages.add(AlertMessageBean("哈哈哈",1,1,"aaa",0))
        rcyAlertMessage.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rcyAlertMessage.adapter = alertMessageAdapter
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
