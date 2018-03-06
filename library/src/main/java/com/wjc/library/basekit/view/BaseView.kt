package com.wjc.library.basekit.view

/**
 * @author : MarkFrank01
 * @Description : View Basic interface
 */
interface BaseView{

    /**
     * 显示正在加载的布局
     */
    fun showLoading()

    /**
     * 关闭正在加载
     */
    fun hideLoading()

    /**
     * 显示错误信息
     */
    fun showErrorMsg(errorMsg:String)

    /**
     * 显示空布局
     */
    fun showEmptyView()

    /**
     * 显示未联网布局
     */
    fun showOffline()

    /**
     * 显示内容区域
     */
    fun showContent()
}