package com.wjc.library.data.bean

import java.io.Serializable

/**
 * @author : MarkFrank01
 * @Description : 服务器 通用 返参 res
 */
open class BaseResp<T>:Serializable{
    var errorCode: Int = 0
    var errorMsg: String = ""
    var data: T? = null
}