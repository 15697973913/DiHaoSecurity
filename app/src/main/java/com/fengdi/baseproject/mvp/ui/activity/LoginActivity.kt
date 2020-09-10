package com.fengdi.baseproject.mvp.ui.activity

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import com.fengdi.baseproject.R
import com.fengdi.baseproject.di.component.DaggerLoginComponent
import com.fengdi.baseproject.di.module.LoginModule
import com.fengdi.baseproject.mvp.contract.LoginContract
import com.fengdi.baseproject.mvp.presenter.LoginPresenter
import com.fengdi.baseproject.mvp.util.CountDownTimerUtils
import com.fengdi.baseproject.mvp.util.VerifyCodeUtil
import com.fengdi.baseproject.wxapi.bean.WeiXin
import com.fengdi.baseproject.wxapi.bean.WeiXinUtil
import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsToast
import com.jess.arms.utils.ArmsUtils
import com.jess.arms.utils.ObjectUtils
import com.qmuiteam.qmui.util.QMUIStatusBarHelper
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog
import com.tbruyelle.rxpermissions2.RxPermissions
import com.tencent.mm.opensdk.modelmsg.SendAuth
import kotlinx.android.synthetic.main.activity_login.*
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import org.simple.eventbus.Subscriber
import timber.log.Timber
import javax.inject.Inject


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 08/07/2020 17:05
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
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
class LoginActivity : BaseActivity<LoginPresenter>(), LoginContract.View {

    @Inject
    lateinit var mRxPermissions: RxPermissions

    @Inject
    lateinit var mErrorHandler: RxErrorHandler

    /**
     * 登录类型  1：验证码登录  2账号登录
     */
    var loginMode = 1;


    override fun setupActivityComponent(appComponent: AppComponent) {

        DaggerLoginComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .loginModule(LoginModule(this))
                .build()
                .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_login
    }


    override fun initData(savedInstanceState: Bundle?) {


        getSmsCode.setOnClickListener {
            CountDownTimerUtils(getSmsCode, 60000, 1000).start()
        }

        changeLoginModeUi()

        initEvent()

        setImageCode("23543")

    }

    private fun initEvent() {


        //验证码登录
        tvSmsLogin.setOnClickListener {
            loginMode = 1;
            changeLoginModeUi()
        }

        tvAccountLogin.setOnClickListener {
            loginMode = 2;
            changeLoginModeUi()
        }


        //登录
        btLogin.setOnClickListener {
            val phone = etPhone.text.toString()
            val password = etPassword.text.toString()
            if (phone.isEmpty()) {
                ArmsToast.show(R.string.str_please_input_account)
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                ArmsToast.show(R.string.login_hint_input_pwd)
                return@setOnClickListener
            }

            val tipDialog = QMUITipDialog.Builder(this)
                    .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
                    .setTipWord("正在加载")
                    .create()
            tipDialog.show()

            btLogin.postDelayed(Runnable {
                tipDialog.dismiss()
                mPresenter?.login(phone, password)
                finish()
            }, 1500)
        }
        //微信登录
        lv_login_type_wx.setOnClickListener {
            val req = SendAuth.Req()
            req.scope = "snsapi_userinfo"
            req.state = System.currentTimeMillis().toString()
            WeiXinUtil.getWxApiInstance().sendReq(req)
        }

    }

    //切换账号登录和验证码登录
    fun changeLoginModeUi() {
        if (loginMode == 1) {
            tvSmsLogin.textSize = 24f
            tvSmsLogin.setTextColor(ArmsUtils.getColor(this, R.color.c_333333))
            linPassword.visibility = View.GONE

            tvAccountLogin.textSize = 20f
            tvAccountLogin.setTextColor(ArmsUtils.getColor(this, R.color.c_7a88a0))
            linImgCode.visibility = View.VISIBLE
            linSmsCode.visibility = View.VISIBLE
        } else {
            tvAccountLogin.textSize = 24f
            tvAccountLogin.setTextColor(ArmsUtils.getColor(this, R.color.c_333333))
            linPassword.visibility = View.VISIBLE

            tvSmsLogin.textSize = 20f
            tvSmsLogin.setTextColor(ArmsUtils.getColor(this, R.color.c_7a88a0))
            linImgCode.visibility = View.GONE
            linSmsCode.visibility = View.GONE
        }

    }


    /**
     * 设置图片验证码
     *
     * @param code
     */
    private fun setImageCode(code: String) {
        val codeBitmap: Bitmap = VerifyCodeUtil.getInstance().createBitmap(code)
        imgAuthCode.setImageBitmap(codeBitmap)
    }

    override fun getActivity(): Activity? {
        return this
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


    /**
     * w微信登录，支付，分享返回事件
     *
     * @param weiXin
     */
    @Subscriber
    fun handleEvent(weiXin: WeiXin) {
        if (!ObjectUtils.isEmpty(weiXin)) {
            Timber.i("weixin收到eventbus请求 type:%s", weiXin.type)
            when (weiXin.type) {
                1 -> if (!ObjectUtils.isEmpty(weiXin.code)) {
                    Timber.i("weixin,授权成功.....")
                } else {
                    Timber.i("weixin,授权失败.....")
                }
            }
        }
    }


}
