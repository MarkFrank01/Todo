package com.wjc.library.adapter.animation

import android.animation.Animator
import android.animation.ObjectAnimator
import android.view.View

/**
 * description：从上往下
 */
class SlideInTopAnimation : BaseAnimation {

    override fun getAnimators(view: View?): Array<Animator> {
        return arrayOf(ObjectAnimator.ofFloat(view, "translationY", -(view?.measuredHeight?.toFloat() ?: 0f),
                0f))
    }
}
