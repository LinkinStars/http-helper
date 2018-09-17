package com.linkinstars;

/**
 * 定义所有请求错误类型
 * @author LinkinStar
 */
public enum Status {
    /** 请求成功 **/
    SUCCESS,
    /** 网路异常 **/
    NET_ERR,
    /** 返回数据异常 **/
    RESPONSE_FORMAT_ERR,
    /** 返回数据非json格式 **/
    JSON_FORMAT_ERR 
}
