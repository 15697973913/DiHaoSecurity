package com.fengdi.baseproject.mvp.model.mine

import android.app.Application
import com.fengdi.baseproject.mvp.contract.mine.ModifyPassWordContract
import com.google.gson.Gson
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import javax.inject.Inject

@ActivityScope
class ModifyPassWordModel
@Inject
constructor(repositoryManager: IRepositoryManager):BaseModel(repositoryManager), ModifyPassWordContract.Model{
    @Inject
    lateinit var mGson: Gson

    @Inject
    lateinit var mApplication: Application


    override fun onDestroy() {
        super.onDestroy()
    }


}