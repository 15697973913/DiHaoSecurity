package com.fengdi.baseproject.mvp.contract.home

import com.jess.arms.mvp.IView
import com.jess.arms.mvp.IModel


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/10/2020 10:17
 

 * ================================================
 */
interface MonitorDetailContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    interface View : IView

    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,即是否使用缓存
    interface Model : IModel

}
