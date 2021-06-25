package com.vision.server.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.vision.server.model.Result;
import com.vision.server.model.ResultEnum;

/**
 * 返回数据封装工具
 * Created by hanqq on 2021/6/8
 * Email:yin13753884368@163.com
 * CSDN:http://blog.csdn.net/yin13753884368/article
 * Github:https://github.com/taxiao213
 */
public class ResultUtils {

    /**
     * 成功时生成result的方法,有返回数据
     */
    public static <T> Result<T> success(T t) {
        Result<T> result = new Result<>();
        result.setResCode(ResultEnum.SUCCESS.getResCode());
        result.setResMsg(ResultEnum.SUCCESS.getResMsg());
        if (t == null) {
            result.setData((T) new JSONObject());
        } else {
            result.setData(t);
        }
        return result;
    }

    /**
     * 成功时生成result的方法,无返回数据
     */
    public static <T> Result<T> success() {
        return success(null);
    }


    /**
     * 失败时生成result的方法
     */
    public static <T> Result<T> error(int code, String msg) {
        Result<T> result = new Result<>();
        result.setResCode(code);
        result.setResMsg(msg);
        result.setData((T) new JSONObject());
        return result;
    }

    public static <T> Result<T> error() {
        return error(ResultEnum.UNKNOWN_ERROR.getResCode(), ResultEnum.UNKNOWN_ERROR.getResMsg());
    }

}
