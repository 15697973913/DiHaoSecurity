package com.fengdi.baseproject.mvp.contract.message

import com.jess.arms.mvp.IView
import com.jess.arms.mvp.IModel


/**
 * Description:
 * <p>
 * Created by YangJie on 09/15/2020 14:25
 *
 * ================================================
 */
interface UnLockMessageContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    interface View : IView

    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,即是否使用缓存
    interface Model : IModel

}
