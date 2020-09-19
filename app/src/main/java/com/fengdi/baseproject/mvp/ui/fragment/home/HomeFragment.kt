package com.fengdi.baseproject.mvp.ui.fragment.home

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.recyclerview.widget.LinearLayoutManager
import com.fengdi.baseproject.R
import com.fengdi.baseproject.app.entity.MonitorBean
import com.fengdi.baseproject.app.entity.SmartLockBean
import com.fengdi.baseproject.di.component.DaggerHomeComponent
import com.fengdi.baseproject.di.module.HomeModule
import com.fengdi.baseproject.mvp.contract.home.HomeContract
import com.fengdi.baseproject.mvp.presenter.home.HomePresenter
import com.fengdi.baseproject.mvp.ui.activity.home.*
import com.fengdi.baseproject.mvp.ui.activity.mine.MyGroupActivity
import com.fengdi.baseproject.mvp.ui.adapter.MonitorAdapter
import com.fengdi.baseproject.mvp.ui.adapter.SmartLockAdapter
import com.jess.arms.base.BaseFragment
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils
import com.qmuiteam.qmui.layout.QMUIFrameLayout
import com.qmuiteam.qmui.skin.QMUISkinManager
import com.qmuiteam.qmui.util.QMUIDisplayHelper
import com.qmuiteam.qmui.widget.popup.QMUIFullScreenPopup
import com.qmuiteam.qmui.widget.popup.QMUIPopups
import kotlinx.android.synthetic.main.dialog_device_manage.view.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.popup_switch_group.view.*
import javax.inject.Inject


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/07/2020 16:27


 * ================================================
 */
/**
 * 如果没presenter
 * 你可以这样写
 *
 * @FragmentScope(請注意命名空間) class NullObjectPresenterByFragment
 * @Inject constructor() : IPresenter {
 * override fun onStart() {
 * }
 *
 * override fun onDestroy() {
 * }
 * }
 */
class HomeFragment : BaseFragment<HomePresenter>(), HomeContract.View {

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var linearLayoutManager1: LinearLayoutManager

    /**
     * 智能锁列表
     */
    @Inject
    lateinit var smartLockList: MutableList<SmartLockBean>

    /**
     * 监控设备列表
     */
    @Inject
    lateinit var monitorList: MutableList<MonitorBean>


    /**
     * 智能锁Adapter
     */
    @Inject
    lateinit var smartLockAdapter: SmartLockAdapter


    /**
     * 监控Adapter
     */
    @Inject
    lateinit var monitorAdapter: MonitorAdapter


    private lateinit var popup: QMUIFullScreenPopup

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }


    override fun setupFragmentComponent(appComponent: AppComponent) {
        DaggerHomeComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .homeModule(HomeModule(this))
                .build()
                .inject(this)
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    override fun initData(savedInstanceState: Bundle?) {

        rcySmartLock.layoutManager = linearLayoutManager

        rcySmartLock.adapter = smartLockAdapter
        smartLockAdapter.setOnItemClickListener { view, viewType, data, position ->
            //门锁管理
            launchActivity(Intent(requireActivity(), DoorLockManageActivity::class.java))
        }


        rcyMonitor.layoutManager = linearLayoutManager1
        rcyMonitor.adapter = monitorAdapter.also {
            it.setOnItemClickListener { view, viewType, data, position ->
                when (view.id) {
                    R.id.ivMore -> {
                        showDevideManagePopup()
                    }
                    else -> {
                        //跳转到播放界面
                        launchActivity(Intent(requireActivity(), VideoPlayerActivity::class.java))
                    }
                }
            }
        }


        gbDeviceType.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rbSmartLock -> {
                    rcySmartLock.visibility = View.VISIBLE
                    rcyMonitor.visibility = View.GONE
                }
                R.id.rbMonitor -> {
                    rcySmartLock.visibility = View.GONE
                    rcyMonitor.visibility = View.VISIBLE
                }
            }
        }

        ivAddDevice.setOnClickListener {
            //添加设备
            launchActivity(Intent(requireActivity(), AddDeviceActivity::class.java))
        }

        tvHouseName.setOnClickListener {
            val view = LayoutInflater.from(requireContext()).inflate(R.layout.popup_switch_group, null)
            val popup = PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
            view.vOther.setOnClickListener {
                popup.dismiss()
            }
            popup.isOutsideTouchable = true

            view.linManageGroup.setOnClickListener {
                launchActivity(Intent(requireActivity(), MyGroupActivity::class.java))
            }

            view.linGroup1.setOnClickListener {
                view.ivGroup1.visibility = View.VISIBLE
                view.ivGroup2.visibility = View.GONE
            }

            view.linGroup2.setOnClickListener {
                view.ivGroup1.visibility = View.GONE
                view.ivGroup2.visibility = View.VISIBLE
            }


            popup.showAsDropDown(it)
            val alphaAnim: ObjectAnimator = ObjectAnimator.ofFloat(view.linGroup, "translationY", -500f, 0f)
            //执行事件
            alphaAnim.duration = 200
            alphaAnim.start()

        }
    }

    //显示设备管理对话框
    fun showDevideManagePopup() {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_device_manage, null, false)

        val frameLayout = QMUIFrameLayout(context)
        //设置圆角
        frameLayout.radius = QMUIDisplayHelper.dp2px(context, 12)

        dialogView.tvDeviceDetail.setOnClickListener {
            //调整到设备详情对话框
            launchActivity(Intent(requireActivity(), MonitorManageActivity::class.java))

            popup.dismiss()
        }

        dialogView.tvAllVideo.setOnClickListener {
            //全部视频
            launchActivity(Intent(requireActivity(), HistoryVideoActivity::class.java))
            popup.dismiss()
        }


        dialogView.tvAlertMsg.setOnClickListener {
            //报警消息
            launchActivity(Intent(requireActivity(), AlertMessageActivity::class.java))
            popup.dismiss()
        }


        //设置宽高
        val lp = FrameLayout.LayoutParams(QMUIDisplayHelper.dp2px(context, 350), QMUIDisplayHelper.dp2px(context, 200))
        frameLayout.addView(dialogView, lp)

        //创建PopupWindow
        popup = QMUIPopups.fullScreenPopup(context)
                .addView(frameLayout)
                .closeBtn(false)
                .skinManager(QMUISkinManager.defaultInstance(context))
                .onBlankClick {
                    popup.dismiss()
                }

        popup.show(view)

    }

    /**
     * 设置数据
     */
    override fun setData(data: Any?) {

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

    }
}
