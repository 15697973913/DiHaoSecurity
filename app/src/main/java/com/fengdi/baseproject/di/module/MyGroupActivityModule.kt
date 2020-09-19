package com.fengdi.baseproject.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.fengdi.baseproject.mvp.contract.mine.MyGroupContract
import com.fengdi.baseproject.mvp.model.mine.MyGroupModel


/**
 * Description:
 * <p>
 * Created by YangJie on 09/18/2020 17:15
 *
 * ================================================
 */
@Module
//构建MyGroupModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class MyGroupModule(private val view: MyGroupContract.View) {
    @ActivityScope
    @Provides
    fun provideMyGroupView(): MyGroupContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideMyGroupModel(model: MyGroupModel): MyGroupContract.Model {
        return model
    }
}
