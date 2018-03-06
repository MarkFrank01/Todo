package com.wjc.library.basekit.activity

import android.view.View
import android.widget.LinearLayout
import com.wjc.library.widgets.LoadingDialog
import com.wjc.library.widgets.TitleBar
import kotlinx.android.synthetic.main.layout_header_bar.view.*
import org.jetbrains.anko.dip

/**
 * @author : MarkFrank01
 * @Description :with toolbar Activity
 */
abstract class TitleBarActivity : BaseActivity(), TitleBar.TitleBarListener {
    private val mDialog by lazy { LoadingDialog.create(this) }
    private lateinit var mTitleBar: TitleBar

    override fun setContentView(layoutResID: Int) {
        mTitleBar = TitleBar(this)
        mTitleBar.visibility = View.VISIBLE
        mTitleBar.setHeaderListener(this)
        val rootLayout = LinearLayout(this)
        rootLayout.orientation = LinearLayout.VERTICAL
        val paramView = View.inflate(this, layoutResID, null)
        rootLayout.addView(mTitleBar, LinearLayout.LayoutParams.MATCH_PARENT, dip(50))
        rootLayout.addView(paramView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        setContentView(rootLayout)

        title = getThisTitle()
    }

    abstract fun getThisTitle(): CharSequence

    override fun onBackClick() {
        finish()
    }

    override fun onRightClick() {

    }

    /**
     * 显示加载中对话框
     */
    fun showLoading() {
        mDialog.show()
    }

    /**
     * 隐藏加载中对话框
     */
    fun hideLoading() {
        mDialog.hide()
    }

    /**
     * 设置标题
     */
    override fun setTitle(title: CharSequence) {
        mTitleBar.setTitleText(title.toString())
    }

    /**
     * 设置右侧按钮是否可见
     */
    fun setRightTvVisible(isShow: Boolean) {
        mTitleBar.mRightTv.visibility = if (isShow) View.VISIBLE else View.GONE
    }

    /**
     * 设置是否可以返回
     */
    fun setBackVisible(isShow: Boolean) {
        mTitleBar.mBackIv.visibility = if (isShow) View.VISIBLE else View.GONE
    }
}