package com.fengdi.baseproject.di.module

import com.jess.arms.di.scope.FragmentScope

import dagger.Module
import dagger.Provides

import com.fengdi.baseproject.mvp.contract.home.MonitorDetailContract
import com.fengdi.baseproject.mvp.model.home.MonitorDetailModel


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/10/2020 10:17
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@Module
//构建MonitorDetailModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class MonitorDetailModule(private val view: MonitorDetailContract.View) {
    @FragmentScope
    @Provides
    fun provideMonitorDetailView(): MonitorDetailContract.View {
        return this.view
    }

    @FragmentScope
    @Provides
    fun provideMonitorDetailModel(model: MonitorDetailModel): MonitorDetailContract.Model {
        return model
    }
}
