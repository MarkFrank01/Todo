package com.wjc.library.basekit.presenter

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * @author : MarkFrank01
 * @Description : 基于Rxjava2的Presenter封装，控制订阅的生命周期
 */

open class RxPresenter : BasePresenter {

    /*
     * 注：
     * 如果有多个Disposable , RxJava中已经内置了一个容器CompositeDisposable,
     * 每当我们得到一个Disposable时就调用CompositeDisposable.add()将它添加到容器中,
     * 在退出的时候, 调用CompositeDisposable.clear() 即可切断所有的水管.
     * */

    private var mComposite: CompositeDisposable? = null

    /**
     * 切断水管,使得下游收不到事件
     */
    private fun unSubscribe() {
        if (mComposite != null) {
            mComposite?.clear()
        }
    }

    /**
     * 添加到容器中,方便控制
     *
     * @param disposable 用于解除订阅
     */
    protected fun addSubscribe(disposable: Disposable) {
        if (mComposite == null) {
            mComposite = CompositeDisposable()
        }
        mComposite?.add(disposable)
    }

    override fun onCreate() {
    }

    override fun onResume() {
    }

    override fun onDestroy() {
        unSubscribe()
    }

}