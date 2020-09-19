package com.fengdi.baseproject.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.fengdi.baseproject.mvp.contract.mine.AddMemberContract
import com.fengdi.baseproject.mvp.model.mine.AddMemberModel


/**
 * Description:
 * <p>
 * Created by YangJie on 09/19/2020 11:41
 *
 * ================================================
 */
@Module
//构建AddMemberModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class AddMemberModule(private val view: AddMemberContract.View) {
    @ActivityScope
    @Provides
    fun provideAddMemberView(): AddMemberContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAddMemberModel(model: AddMemberModel): AddMemberContract.Model {
        return model
    }
}
