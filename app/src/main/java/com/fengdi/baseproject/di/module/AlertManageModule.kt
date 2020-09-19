package com.fengdi.baseproject.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.fengdi.baseproject.mvp.contract.message.AlertManageContract
import com.fengdi.baseproject.mvp.model.message.AlertManageModel


/**
 * Description:
 * <p>
 * Created by YangJie on 09/15/2020 15:27
 *
 * ================================================
 */
@Module
//构建AlertManageModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class AlertManageModule(private val view: AlertManageContract.View) {
    @ActivityScope
    @Provides
    fun provideAlertManageView(): AlertManageContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAlertManageModel(model: AlertManageModel): AlertManageContract.Model {
        return model
    }
}
