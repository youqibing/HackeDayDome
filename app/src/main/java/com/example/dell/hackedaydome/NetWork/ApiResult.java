package com.example.dell.hackedaydome.NetWork;

import java.io.Serializable;

/**
 * Created by dell on 2016/10/29.
 */

public class ApiResult<T> implements Serializable {

    private int code;
    private String msg;
    //private int msg_show;
    private T data;


    public ApiResult(){
        this.code = 0;
        this.msg = "成功";
    }

    public ApiResult(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public ApiResult(int code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }

    public T getData(){
        return data;
    }

    /*
    public int getMsg_show(){
        return msg_show;
    }
    */

    @Override
    public String toString() {
        return "ApiResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                //", msg_show=" + msg_show +
                ", data=" + data +
                '}';
    }
}
