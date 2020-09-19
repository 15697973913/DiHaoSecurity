package com.fengdi.baseproject.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.fengdi.baseproject.mvp.contract.home.AlertMessageContract
import com.fengdi.baseproject.mvp.model.home.AlertMessageModel


/**
 * Description:
 * <p>
 * Created by YangJie on 09/18/2020 18:30
 *
 * ================================================
 */
@Module
//构建AlertMessageModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class AlertMessageModule(private val view: AlertMessageContract.View) {
    @ActivityScope
    @Provides
    fun provideAlertMessageView(): AlertMessageContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAlertMessageModel(model: AlertMessageModel): AlertMessageContract.Model {
        return model
    }
}
