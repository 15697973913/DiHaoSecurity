package com.fengdi.baseproject.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.fengdi.baseproject.mvp.contract.message.MyVideoContract
import com.fengdi.baseproject.mvp.model.message.MyVideoModel


/**
 * Description:
 * <p>
 * Created by YangJie on 09/16/2020 16:18
 *
 * ================================================
 */
@Module
//构建MyVideoModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class MyVideoModule(private val view: MyVideoContract.View) {
    @ActivityScope
    @Provides
    fun provideMyVideoView(): MyVideoContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideMyVideoModel(model: MyVideoModel): MyVideoContract.Model {
        return model
    }
}
