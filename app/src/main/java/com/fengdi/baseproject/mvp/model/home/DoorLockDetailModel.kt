package com.fengdi.baseproject.mvp.model.home

import android.app.Application
import com.google.gson.Gson
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel

import com.jess.arms.di.scope.FragmentScope
import javax.inject.Inject

import com.fengdi.baseproject.mvp.contract.home.DoorLockDetailContract


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/09/2020 17:15
 

 * ================================================
 */
@FragmentScope
class DoorLockDetailModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), DoorLockDetailContract.Model{
    @Inject
    lateinit var mGson:Gson;
    @Inject
    lateinit var mApplication:Application;

    override fun onDestroy() {
          super.onDestroy();
    }
}
