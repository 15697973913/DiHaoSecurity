package com.fengdi.baseproject.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.fengdi.baseproject.mvp.contract.home.HistoryVideoContract
import com.fengdi.baseproject.mvp.model.home.HistoryVideoModel


/**
 * Description:
 * <p>
 * Created by YangJie on 09/18/2020 16:40
 *
 * ================================================
 */
@Module
//构建HistoryVideoModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class HistoryVideoModule(private val view: HistoryVideoContract.View) {
    @ActivityScope
    @Provides
    fun provideHistoryVideoView(): HistoryVideoContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideHistoryVideoModel(model: HistoryVideoModel): HistoryVideoContract.Model {
        return model
    }
}
