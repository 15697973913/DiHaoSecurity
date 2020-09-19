package com.fengdi.baseproject.mvp.model

import android.app.Application
import com.google.gson.Gson
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel

import com.jess.arms.di.scope.ActivityScope
import javax.inject.Inject

import com.fengdi.baseproject.mvp.contract.GeneratePassWordContract


/**
 * Description:
 * <p>
 * Created by YangJie on 09/19/2020 14:29
 *
 * ================================================
 */
@ActivityScope
class GeneratePassWordModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), GeneratePassWordContract.Model {
    @Inject
    lateinit var mGson: Gson;

    @Inject
    lateinit var mApplication: Application;

    override fun onDestroy() {
        super.onDestroy();
    }
}
