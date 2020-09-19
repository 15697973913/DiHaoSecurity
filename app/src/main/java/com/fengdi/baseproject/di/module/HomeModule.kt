package com.fengdi.baseproject.di.module

import androidx.recyclerview.widget.LinearLayoutManager
import com.fengdi.baseproject.app.entity.MonitorBean
import com.fengdi.baseproject.app.entity.SmartLockBean
import com.jess.arms.di.scope.FragmentScope

import dagger.Module
import dagger.Provides

import com.fengdi.baseproject.mvp.contract.home.HomeContract
import com.fengdi.baseproject.mvp.model.home.HomeModel
import com.fengdi.baseproject.mvp.ui.adapter.MonitorAdapter
import com.fengdi.baseproject.mvp.ui.adapter.SmartLockAdapter
import com.jess.arms.di.scope.NoSington
import javax.inject.Singleton


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/07/2020 16:27
 

 * ================================================
 */
@Module
//构建HomeModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class HomeModule(private val view: HomeContract.View) {
    @FragmentScope
    @Provides
    fun provideHomeView(): HomeContract.View {
        return this.view
    }

    @FragmentScope
    @Provides
    fun provideHomeModel(model: HomeModel): HomeContract.Model {
        return model
    }

    @NoSington
    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager {
        return LinearLayoutManager(view.requireActivity(), LinearLayoutManager.VERTICAL, false)
    }

    @FragmentScope
    @Provides
    fun provideMonitorListList(): MutableList<MonitorBean> {
        return mutableListOf()
    }

    @FragmentScope
    @Provides
    fun provideSmartLockList(): MutableList<SmartLockBean> {
        return mutableListOf()
    }


    @FragmentScope
    @Provides
    fun provideSmartLockAdapter(list: MutableList<SmartLockBean>): SmartLockAdapter {
        return SmartLockAdapter(list)
    }


    @FragmentScope
    @Provides
    fun provideMonitorAdapter(list: MutableList<MonitorBean>): MonitorAdapter {
        return MonitorAdapter(list)
    }

}
