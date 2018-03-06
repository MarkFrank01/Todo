package com.wjc.library.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.wjc.library.R
import kotlinx.android.synthetic.main.layout_header_bar.view.*

/**
 * @author : MarkFrank01
 * @Description : General purpose Toolbar
 */
class TitleBar @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : FrameLayout(context, attrs, defStyleAttr) {

    private var mTitleBarListener: TitleBarListener? = null

    init {
        View.inflate(context, R.layout.layout_header_bar, this)
        initView()
    }

    private fun initView() {
        mBackIv.setOnClickListener {
            mTitleBarListener?.onBackClick()
        }
        mRightTv.setOnClickListener {
            mTitleBarListener?.onRightClick()
        }
    }

    /**
     * title Listener
     */
    fun setHeaderListener(listener: TitleBarListener) {
        mTitleBarListener = listener
    }

    /**
     * set title
     */
    fun setTitleText(title: String) {
        mTitleTv.text = title
    }

    /**
     * set right text
     */
    fun setRightText(rightText: String) {
        mRightTv.text = rightText
    }

    interface TitleBarListener {
        fun onBackClick()
        fun onRightClick()
    }

}