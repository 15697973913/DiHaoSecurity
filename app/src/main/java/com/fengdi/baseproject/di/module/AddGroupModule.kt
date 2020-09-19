package com.fengdi.baseproject.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.fengdi.baseproject.mvp.contract.mine.AddGroupContract
import com.fengdi.baseproject.mvp.model.mine.AddGroupModel


/**
 * Description:
 * <p>
 * Created by YangJie on 09/19/2020 10:37
 *
 * ================================================
 */
@Module
//构建AddGroupModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class AddGroupModule(private val view: AddGroupContract.View) {
    @ActivityScope
    @Provides
    fun provideAddGroupView(): AddGroupContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAddGroupModel(model: AddGroupModel): AddGroupContract.Model {
        return model
    }
}
