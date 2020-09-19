package com.fengdi.baseproject.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.fengdi.baseproject.mvp.contract.message.MaintenanceContract
import com.fengdi.baseproject.mvp.model.MaintenanceModel


/**
 * Description:
 * <p>
 * Created by YangJie on 09/15/2020 16:47
 *
 * ================================================
 */
@Module
//构建MaintenanceModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class MaintenanceModule(private val view: MaintenanceContract.View) {
    @ActivityScope
    @Provides
    fun provideMaintenanceView(): MaintenanceContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideMaintenanceModel(model: MaintenanceModel): MaintenanceContract.Model {
        return model
    }
}
