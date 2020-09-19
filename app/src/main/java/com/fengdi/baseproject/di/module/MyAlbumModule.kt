package com.fengdi.baseproject.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.fengdi.baseproject.mvp.contract.message.MyAlbumContract
import com.fengdi.baseproject.mvp.model.message.MyAlbumModel


/**
 * Description:
 * <p>
 * Created by YangJie on 09/16/2020 16:11
 *
 * ================================================
 */
@Module
//构建MyAlbumModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class MyAlbumModule(private val view: MyAlbumContract.View) {
    @ActivityScope
    @Provides
    fun provideMyAlbumView(): MyAlbumContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideMyAlbumModel(model: MyAlbumModel): MyAlbumContract.Model {
        return model
    }
}
