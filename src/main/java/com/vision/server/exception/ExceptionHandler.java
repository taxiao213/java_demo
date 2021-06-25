package com.vision.server.exception;

import com.vision.server.model.Result;
import com.vision.server.model.ResultEnum;
import com.vision.server.utils.ResultUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hanqq on 2021/6/8
 * Email:yin13753884368@163.com
 * CSDN:http://blog.csdn.net/yin13753884368/article
 * Github:https://github.com/taxiao213
 */
//@ControllerAdvice
public class ExceptionHandler {
    /**
     * 处理基本信息相关的异常
     *//*
    @ExceptionHandler(BasicInfoException.class)
    @ResponseBody
    public Result handleBasicInfoException(BasicInfoException ex) {
        return ResultUtils.error(ex.getCode(), ex.getMessage());
    }

    *//**
     * 处理测试数据相关的异常
     *//*
    @ExceptionHandler(DetailsDataException.class)
    @ResponseBody
    public Result handleDetailsDataException(DetailsDataException ex) {
        return ResultUtils.error(ex.getCode(), ex.getMessage());
    }


    *//**
     * 处理未知异常
     *//*
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handleUnKnowException(Exception ex) {
        return ResultUtils.error(ResultEnum.UNKNOWN_ERROR.getCode(), ex.getMessage());
    }*/

}
