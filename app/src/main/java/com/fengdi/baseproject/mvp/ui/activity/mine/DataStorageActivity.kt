package com.fengdi.baseproject.mvp.ui.activity.mine

import android.graphics.Paint
import android.graphics.Typeface
import android.os.Bundle
import com.fengdi.baseproject.R
import com.fengdi.baseproject.di.component.DaggerDataStorageComponent
import com.fengdi.baseproject.di.module.DataStorageModule
import com.fengdi.baseproject.mvp.contract.mine.DataStorageContrace
import com.fengdi.baseproject.mvp.presenter.mine.DataStoragePresenter
import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsToast
import kotlinx.android.synthetic.main.activity_data_storage.*

class DataStorageActivity : BaseActivity<DataStoragePresenter>(), DataStorageContrace.View {
    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerDataStorageComponent.builder()
                .appComponent(appComponent)
                .dataStorageModule(DataStorageModule(this))
                .build()
                .inject(this)
    }

    override fun initData(savedInstanceState: Bundle?) {
        //添加删除线
        tv1TOldPrice.paint.flags = Paint.STRIKE_THRU_TEXT_FLAG
        tv500GOldPrice.paint.flags = Paint.STRIKE_THRU_TEXT_FLAG

        lin1TCapacity.setOnClickListener {
            //500G容量

        }

        lin500GCapacity.setOnClickListener {
            //500G容量
            //项目基础框架的搭建
            //对历史项目进行内存优化，启动优化，apk优化
            //对历史项目的重构
            //整个项目的进度把控
            //通过SVN对项目进行版本控制

        }

    }

    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_data_storage
    }

    override fun showMessage(message: String) {
        ArmsToast.show(message)
    }

}