package com.fengdi.baseproject.mvp.model.home

import android.app.Application
import com.google.gson.Gson
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel

import com.jess.arms.di.scope.FragmentScope
import javax.inject.Inject

import com.fengdi.baseproject.mvp.contract.home.HomeContract


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/07/2020 16:27


 * ================================================
 */
@FragmentScope
class HomeModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), HomeContract.Model {
    @Inject
    lateinit var mGson: Gson;

    @Inject
    lateinit var mApplication: Application;

    override fun onDestroy() {
        super.onDestroy();
    }
}
