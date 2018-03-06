package com.wjc.library.basekit.activity

import android.content.Context
import android.os.Bundle
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import com.wjc.library.common.AppManager

/**
 * @author : MarkFrank01
 * @Description : Activity Basic
 */
abstract class BaseActivity: RxAppCompatActivity() {

    val mContext:Context by lazy { this  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppManager.instance.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.instance.finishActivity(this)
    }
}