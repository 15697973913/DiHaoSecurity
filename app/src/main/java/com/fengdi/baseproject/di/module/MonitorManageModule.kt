package com.fengdi.baseproject.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.fengdi.baseproject.mvp.contract.home.MonitorManageContract
import com.fengdi.baseproject.mvp.model.home.MonitorManageModel


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/10/2020 11:36
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@Module
//构建MonitorManageModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class MonitorManageModule(private val view: MonitorManageContract.View) {
    @ActivityScope
    @Provides
    fun provideMonitorManageView(): MonitorManageContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideMonitorManageModel(model: MonitorManageModel): MonitorManageContract.Model {
        return model
    }
}
