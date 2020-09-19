package com.fengdi.baseproject.mvp.ui.activity.mine

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.fengdi.baseproject.R
import com.fengdi.baseproject.app.entity.MyDevicesBean
import com.fengdi.baseproject.di.component.DaggerMyDevicesComponent
import com.fengdi.baseproject.di.module.MyDevicesModule
import com.fengdi.baseproject.mvp.contract.mine.MyDevicesContrace
import com.fengdi.baseproject.mvp.presenter.mine.MyDevicesPresenter
import com.fengdi.baseproject.mvp.ui.activity.home.DoorLockManageActivity
import com.fengdi.baseproject.mvp.ui.adapter.MyDevicesAdapter
import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsToast
import kotlinx.android.synthetic.main.activity_my_devices.*
import javax.inject.Inject

class MyDevicesActivity : BaseActivity<MyDevicesPresenter>(), MyDevicesContrace.View {
    @Inject
    lateinit var layoutManager: LinearLayoutManager

    @Inject
    lateinit var deviceList: MutableList<MyDevicesBean>

    @Inject
    lateinit var devicesAdapter: MyDevicesAdapter

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerMyDevicesComponent.builder()
                .appComponent(appComponent)
                .myDevicesModule(MyDevicesModule(this))
                .build()
                .inject(this)
    }

    override fun initData(savedInstanceState: Bundle?) {
        deviceList.add(MyDevicesBean("智能锁", "5421322", "尚美中心", 1))
        deviceList.add(MyDevicesBean("精致的电饭煲", "654678", "深圳北站", 0))
        deviceList.add(MyDevicesBean("智能监控", "678674", "南昌西站", 1))
        deviceList.add(MyDevicesBean("智能机器人", "438678", "赣州东站", 1))

        devicesAdapter.setOnItemClickListener { view, viewType, data, position ->
            launchActivity(Intent(this, DoorLockManageActivity::class.java))
        }
        recMyDevices.layoutManager = layoutManager
        recMyDevices.adapter = devicesAdapter
    }

    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_my_devices
    }

    override fun getActivity(): Activity {
        return this
    }

    override fun showMessage(message: String) {
        ArmsToast.show(message)
    }
}