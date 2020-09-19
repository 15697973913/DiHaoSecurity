package com.fengdi.baseproject.di.module

import androidx.recyclerview.widget.LinearLayoutManager
import com.fengdi.baseproject.app.entity.MyDevicesBean
import com.fengdi.baseproject.mvp.contract.mine.MyDevicesContrace
import com.fengdi.baseproject.mvp.model.mine.MyDevicesModel
import com.fengdi.baseproject.mvp.ui.adapter.MyDevicesAdapter
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.di.scope.NoSington
import dagger.Module
import dagger.Provides

@Module
class MyDevicesModule(private val view: MyDevicesContrace.View) {

    @ActivityScope
    @Provides
    fun providesMyDevicesView(): MyDevicesContrace.View {
        return view
    }


    @ActivityScope
    @Provides
    fun providesMyDevicesModel(model: MyDevicesModel): MyDevicesContrace.Model {
        return model
    }


    @ActivityScope
    @Provides
    fun provicesMyDeviceList(): MutableList<MyDevicesBean>{
        return mutableListOf()
    }


    @ActivityScope
    @Provides
    fun provicesMyDevicesAdapter(devices:MutableList<MyDevicesBean>):MyDevicesAdapter{
        return MyDevicesAdapter(devices)
    }


    @NoSington
    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager {
        return LinearLayoutManager(view.getActivity(), LinearLayoutManager.VERTICAL, false)
    }
}