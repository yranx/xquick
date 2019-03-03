package com.ranx.chowder.utils;

import java.io.Serializable;

/**
 * http请求返回的最外层对象
 * @author ranx
 * @create 2018-05-23 13:07
 **/
public class Result<T> implements Serializable{
    //序列化的时候保证唯一
    private static final long serialVersionUID = 30688373945L;
    //错误码
    private Integer code;
    //提示信息
    private String msg;
    //具体内容
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result() {
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
