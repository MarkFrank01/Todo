package com.wjc.library.common

import android.app.Activity
import android.content.Context
import java.util.*

/**
 * @author : MarkFrank01
 * @Description : manager Activity Stack
 */

class AppManager private constructor(){
    val mActivityStack = Stack<Activity>()

    companion object {
        val instance : AppManager by lazy { AppManager() }
    }

    fun addActivity(activity: Activity) {
        mActivityStack.add(activity)
    }

    fun finishActivity(activity: Activity) {
        activity.finish()
        mActivityStack.remove(activity)
    }

    fun finishAllActivity() {
        mActivityStack.forEach {
            it.finish()
        }
        mActivityStack.clear()
    }

    fun exitApp(context: Context) {
        finishAllActivity()
        System.exit(0)
    }
}