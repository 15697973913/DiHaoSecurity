package com.fengdi.baseproject.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.fengdi.baseproject.mvp.contract.home.MonitorManageContract
import com.fengdi.baseproject.mvp.model.home.MonitorManageModel


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/10/2020 11:36
 

 * ================================================
 */
@Module
//构建MonitorManageModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class MonitorManageModule(private val view: MonitorManageContract.View) {
    @ActivityScope
    @Provides
    fun provideMonitorManageView(): MonitorManageContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideMonitorManageModel(model: MonitorManageModel): MonitorManageContract.Model {
        return model
    }
}
