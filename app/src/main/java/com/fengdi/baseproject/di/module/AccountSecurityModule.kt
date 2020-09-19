package com.fengdi.baseproject.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.fengdi.baseproject.mvp.contract.mine.AccountSecurityContract
import com.fengdi.baseproject.mvp.model.mine.AccountSecurityModel


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/11/2020 17:46
 

 * ================================================
 */
@Module
//构建AccountSecurityModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class AccountSecurityModule(private val view: AccountSecurityContract.View) {
    @ActivityScope
    @Provides
    fun provideAccountSecurityView(): AccountSecurityContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAccountSecurityModel(model: AccountSecurityModel): AccountSecurityContract.Model {
        return model
    }
}
