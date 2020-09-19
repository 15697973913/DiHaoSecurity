package com.fengdi.baseproject.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.fengdi.baseproject.mvp.contract.mine.SelectMemberContract
import com.fengdi.baseproject.mvp.model.mine.SelectMemberModel


/**
 * Description:
 * <p>
 * Created by YangJie on 09/19/2020 11:30
 *
 * ================================================
 */
@Module
//构建SelectMemberModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class SelectMemberModule(private val view: SelectMemberContract.View) {
    @ActivityScope
    @Provides
    fun provideSelectMemberView(): SelectMemberContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideSelectMemberModel(model: SelectMemberModel): SelectMemberContract.Model {
        return model
    }
}
