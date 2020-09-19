package com.fengdi.baseproject.mvp.ui.activity.message

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fengdi.baseproject.R
import com.fengdi.baseproject.app.entity.MaintenanceMeassageBean
import com.fengdi.baseproject.di.component.DaggerMaintenanceComponent
import com.fengdi.baseproject.di.module.MaintenanceModule
import com.fengdi.baseproject.mvp.contract.message.MaintenanceContract
import com.fengdi.baseproject.mvp.presenter.message.MaintenancePresenter
import com.fengdi.baseproject.mvp.ui.adapter.MaintenanceMessageAdapter
import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils
import kotlinx.android.synthetic.main.activity_alert_manage.*


/**
 * Description: 维保信息
 * <p>
 * Created by YangJie on 09/15/2020 16:47
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
class MaintenanceActivity : BaseActivity<MaintenancePresenter>(), MaintenanceContract.View {

    var maintenanceMeassageList = mutableListOf<MaintenanceMeassageBean>()

    var maintenanceMessageAdapter = MaintenanceMessageAdapter(maintenanceMeassageList)


    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerMaintenanceComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .maintenanceModule(MaintenanceModule(this))
                .build()
                .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_maintenance //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        maintenanceMeassageList.add(MaintenanceMeassageBean("哈哈哈",1,1,"aaa",0))
        maintenanceMeassageList.add(MaintenanceMeassageBean("哈哈哈",1,1,"aaa",0))
        maintenanceMeassageList.add(MaintenanceMeassageBean("哈哈哈",1,1,"aaa",0))
        maintenanceMeassageList.add(MaintenanceMeassageBean("哈哈哈",1,1,"aaa",0))
        maintenanceMeassageList.add(MaintenanceMeassageBean("哈哈哈",1,1,"aaa",0))
        maintenanceMeassageList.add(MaintenanceMeassageBean("哈哈哈",1,1,"aaa",0))
        maintenanceMeassageList.add(MaintenanceMeassageBean("哈哈哈",1,1,"aaa",0))
        maintenanceMeassageList.add(MaintenanceMeassageBean("哈哈哈",1,1,"aaa",0))
        rcyAlertMessage.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rcyAlertMessage.adapter = maintenanceMessageAdapter
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
