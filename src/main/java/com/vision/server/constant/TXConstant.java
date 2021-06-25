package com.vision.server.constant;

/**
 * 常量类
 * Created by hanqq on 2021/6/8
 * Email:yin13753884368@163.com
 * CSDN:http://blog.csdn.net/yin13753884368/article
 * Github:https://github.com/taxiao213
 */
public class TXConstant {

    // 创建表 PROVISION
    public static String MYBATIS_CREATE_PROVISION_SIP = "com.vision.server.module.provision.dao.IProvisionSipDao.createSipProvision";
    public static String MYBATIS_CONFIG_NAME = "config-mybatis.xml";

    // visionType
    public static int MT_TV = -1;
    public static int Phone = 0;
    public static int PRODUCT_VE_210 = 1;
    public static int PRODUCT_VE_880 = 2;
    public static int PRODUCT_VE_260 = 3;

    // sip 服务默认配置
    public static String SIP_USER_NAME = "root";
    public static String SIP_USER_PASS_WORD = "root";
    public static String SIP_ENABLE_SIP = "enable";
    public static String SIP_ENABLE_SVC = "true";
    public static String SIP_OUT_BOUND_CALL_RATE = "1024";
    public static String SIP_IN_BOUND_CALL_RATE = "1024";
    public static String SIP_SIP_SERVER_TYPE = "specify";
    public static String SIP_TRANSPORT = "TCP";
    public static String SIP_PROXY_SERVER = "172.21.0.121";
    public static String SIP_DOMAIN_SERVER = "172.21.0.121";
    public static String SIP_PASSWORD = "111111";
    //2001 2011 2021
    //2002 2012 2022
    //2003 2013 2023
    //2004 2014 2024
    //2005 2015 2025
    //2006 2016 2026
    //2007 2017 2027
    //2008 2018 2028
    //2009 2019 2029
    //2010 2020 2030
    public static int SIP_USER_NAME_PREFIX = 2001;

    // 统一接口返回信息
    public static int RESULT_CODE_SUCCESS = 1000;
    public static int RESULT_CODE_ERROR = 1001;
    public static int RESULT_CODE_NO_API_ERROR = 1002;

    public static String RESULT_MSG_SUCCESS = "成功";
    public static String RESULT_MSG_ERROR = "未知错误";
    public static String RESULT_MSG_NO_API_ERROR = "请求路径为空";
}
