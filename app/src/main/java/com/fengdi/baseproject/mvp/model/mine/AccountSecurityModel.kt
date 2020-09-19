package com.fengdi.baseproject.mvp.model.mine

import android.app.Application
import com.google.gson.Gson
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel

import com.jess.arms.di.scope.ActivityScope
import javax.inject.Inject

import com.fengdi.baseproject.mvp.contract.mine.AccountSecurityContract


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/11/2020 17:46


 * ================================================
 */
@ActivityScope
class AccountSecurityModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), AccountSecurityContract.Model {
    @Inject
    lateinit var mGson: Gson

    @Inject
    lateinit var mApplication: Application;

    override fun onDestroy() {
        super.onDestroy()
    }
}
