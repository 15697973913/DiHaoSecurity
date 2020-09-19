package com.fengdi.baseproject.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.fengdi.baseproject.mvp.contract.home.VideoPlayerContract
import com.fengdi.baseproject.mvp.model.home.VideoPlayerModel


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/09/2020 15:27
 

 * ================================================
 */
@Module
//构建VideoPlayerModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class VideoPlayerModule(private val view: VideoPlayerContract.View) {
    @ActivityScope
    @Provides
    fun provideVideoPlayerView(): VideoPlayerContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideVideoPlayerModel(model: VideoPlayerModel): VideoPlayerContract.Model {
        return model
    }
}
