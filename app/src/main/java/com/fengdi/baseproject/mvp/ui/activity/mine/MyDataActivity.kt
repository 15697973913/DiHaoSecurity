package com.fengdi.baseproject.mvp.ui.activity.mine

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import com.fengdi.baseproject.R
import com.fengdi.baseproject.app.utils.ImageChoiceUtil
import com.fengdi.baseproject.di.component.DaggerMyDataComponent
import com.fengdi.baseproject.di.module.MyDataModule
import com.fengdi.baseproject.mvp.contract.mine.MyDataContract
import com.fengdi.baseproject.mvp.presenter.mine.MyDataPresenter
import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.http.imageloader.ImageLoader
import com.jess.arms.http.imageloader.glide.ImageConfigImpl
import com.jess.arms.utils.ArmsUtils
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.listener.OnResultCallbackListener
import kotlinx.android.synthetic.main.activity_my_data.*
import javax.inject.Inject


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/11/2020 16:29


 * ================================================
 */
/**
 * 如果没presenter
 * 你可以这样写
 *
 * @ActivityScope(請注意命名空間) class NullObjectPresenterByActivity
 * @Inject constructor() : IPresenter {
 * override fun onStart() {
 * }
 *
 * override fun onDestroy() {
 * }
 * }
 */
class MyDataActivity : BaseActivity<MyDataPresenter>(), MyDataContract.View {


    @Inject
    lateinit var mImageLoader: ImageLoader

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerMyDataComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .myDataModule(MyDataModule(this))
                .build()
                .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_my_data //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        linHead.setOnClickListener {

            //图片选择器
            ImageChoiceUtil.goToPictureSelector(false, false, 500, 500
                    , object : OnResultCallbackListener<LocalMedia?> {
                override fun onResult(result: List<LocalMedia?>) {
                    for (media in result) {
                        if (media == null) {
                            continue
                        }

                        //加载头像

                        ivHead.setImageBitmap(BitmapFactory.decodeFile(media.compressPath))

                    }
                }

                override fun onCancel() {

                }
            })
        }
    }


    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showMessage(message: String) {
        ArmsUtils.snackbarText(message)
    }

    override fun launchActivity(intent: Intent) {
        ArmsUtils.startActivity(intent)
    }

    override fun killMyself() {
        finish()
    }
}
