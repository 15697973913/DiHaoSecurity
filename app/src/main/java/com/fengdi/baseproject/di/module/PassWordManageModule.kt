package com.fengdi.baseproject.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.fengdi.baseproject.mvp.contract.home.PassWordManageContract
import com.fengdi.baseproject.mvp.model.home.PassWordManageModel


/**
 * Description:
 * <p>
 * Created by YangJie on 09/18/2020 14:29
 *
 * ================================================
 */
@Module
//构建PassWordManageModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class PassWordManageModule(private val view: PassWordManageContract.View) {
    @ActivityScope
    @Provides
    fun providePassWordManageView(): PassWordManageContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun providePassWordManageModel(model: PassWordManageModel): PassWordManageContract.Model {
        return model
    }
}
