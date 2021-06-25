package com.vision.server.model;

import com.vision.server.constant.TXConstant;

/**
 * Created by hanqq on 2021/6/8
 * Email:yin13753884368@163.com
 * CSDN:http://blog.csdn.net/yin13753884368/article
 * Github:https://github.com/taxiao213
 */
public enum ResultEnum {

    SUCCESS(TXConstant.RESULT_CODE_SUCCESS, TXConstant.RESULT_MSG_SUCCESS),
    UNKNOWN_ERROR(TXConstant.RESULT_CODE_ERROR, TXConstant.RESULT_MSG_ERROR),
    NO_API_ERROR(TXConstant.RESULT_CODE_NO_API_ERROR, TXConstant.RESULT_MSG_NO_API_ERROR);


    private int resCode;

    private String resMsg;

    ResultEnum(int resCode, String resMsg) {
        this.resCode = resCode;
        this.resMsg = resMsg;
    }

    public int getResCode() {
        return resCode;
    }

    public void setResCode(int resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }
}