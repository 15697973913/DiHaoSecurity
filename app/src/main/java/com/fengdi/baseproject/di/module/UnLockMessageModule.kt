package com.fengdi.baseproject.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.fengdi.baseproject.mvp.contract.message.UnLockMessageContract
import com.fengdi.baseproject.mvp.model.message.UnLockMessageModel


/**
 * Description:
 * <p>
 * Created by YangJie on 09/15/2020 14:25
 *
 * ================================================
 */
@Module
//构建UnLockMessageModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class UnLockMessageModule(private val view: UnLockMessageContract.View) {
    @ActivityScope
    @Provides
    fun provideUnLockMessageView(): UnLockMessageContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideUnLockMessageModel(model: UnLockMessageModel): UnLockMessageContract.Model {
        return model
    }
}
