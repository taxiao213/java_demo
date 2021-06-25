package com.vision.server.model;

import com.vision.server.constant.TXConstant;

import java.util.List;

/**
 * sip 预配置
 * Created by hanqq on 2021/6/9
 * Email:yin13753884368@163.com
 * CSDN:http://blog.csdn.net/yin13753884368/article
 * Github:https://github.com/taxiao213
 */
public class ProvisionSipModel {

    /**
     * authorizationName : 2020
     * domain : 172.21.0.121
     * enableSIP : enable
     * enableSVC : true
     * inboundCallRate : 4096
     * isEnableLpr : true
     * outboundCallRate : 4096
     * password :
     * sipProxyServer : 172.21.0.121
     * sipRegistrarServer :
     * sipServerType : specify
     * transport : TCP
     * userName : 2020
     */

    // 主键 唯一
    private int id;
    // visionType 区分版本
    private int visionType;
    // mac 地址 唯一
    private String macAddress;
    // 代理服务器
    private String sipProxyServer;
    // 域名
    private String domainServer;
    // 验证用户名
    private String authorizationName;
    // 用户名
    private String userName;
    // 密码
    private String password;
    private String enableSIP;
    private String enableSVC;
    private String inboundCallRate;
    private String isEnableLpr;
    private String outboundCallRate;
    private String sipRegistrarServer;
    private String sipServerType;
    private String transport;

    public ProvisionSipModel(int visionType, String sipProxyServer, String domainServer, String authorizationName, String userName, String password) {
        this.visionType = visionType;
        this.sipProxyServer = sipProxyServer;
        this.domainServer = domainServer;
        this.authorizationName = authorizationName;
        this.userName = userName;
        this.password = password;
        this.enableSIP = TXConstant.SIP_ENABLE_SIP;
        this.enableSVC = TXConstant.SIP_ENABLE_SVC;
        this.outboundCallRate = TXConstant.SIP_OUT_BOUND_CALL_RATE;
        this.inboundCallRate = TXConstant.SIP_IN_BOUND_CALL_RATE;
        this.sipServerType = TXConstant.SIP_SIP_SERVER_TYPE;
        this.transport = TXConstant.SIP_TRANSPORT;
    }

    public String getAuthorizationName() {
        return authorizationName;
    }

    public void setAuthorizationName(String authorizationName) {
        this.authorizationName = authorizationName;
    }

    public String getDomainServer() {
        return domainServer;
    }

    public void setDomainServer(String domainServer) {
        this.domainServer = domainServer;
    }

    public String getEnableSIP() {
        return enableSIP;
    }

    public void setEnableSIP(String enableSIP) {
        this.enableSIP = enableSIP;
    }

    public String getEnableSVC() {
        return enableSVC;
    }

    public void setEnableSVC(String enableSVC) {
        this.enableSVC = enableSVC;
    }

    public String getInboundCallRate() {
        return inboundCallRate;
    }

    public void setInboundCallRate(String inboundCallRate) {
        this.inboundCallRate = inboundCallRate;
    }

    public String getIsEnableLpr() {
        return isEnableLpr;
    }

    public void setIsEnableLpr(String isEnableLpr) {
        this.isEnableLpr = isEnableLpr;
    }

    public String getOutboundCallRate() {
        return outboundCallRate;
    }

    public void setOutboundCallRate(String outboundCallRate) {
        this.outboundCallRate = outboundCallRate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSipProxyServer() {
        return sipProxyServer;
    }

    public void setSipProxyServer(String sipProxyServer) {
        this.sipProxyServer = sipProxyServer;
    }

    public String getSipRegistrarServer() {
        return sipRegistrarServer;
    }

    public void setSipRegistrarServer(String sipRegistrarServer) {
        this.sipRegistrarServer = sipRegistrarServer;
    }

    public String getSipServerType() {
        return sipServerType;
    }

    public void setSipServerType(String sipServerType) {
        this.sipServerType = sipServerType;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public int getVisionType() {
        return visionType;
    }

    public void setVisionType(int visionType) {
        this.visionType = visionType;
    }

    @Override
    public String toString() {
        return "ProvisionSipModel{" +
                "id=" + id +
                ", visionType=" + visionType +
                ", macAddress='" + macAddress + '\'' +
                ", sipProxyServer='" + sipProxyServer + '\'' +
                ", domainServer='" + domainServer + '\'' +
                ", authorizationName='" + authorizationName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", enableSIP='" + enableSIP + '\'' +
                ", enableSVC='" + enableSVC + '\'' +
                ", inboundCallRate='" + inboundCallRate + '\'' +
                ", isEnableLpr='" + isEnableLpr + '\'' +
                ", outboundCallRate='" + outboundCallRate + '\'' +
                ", sipRegistrarServer='" + sipRegistrarServer + '\'' +
                ", sipServerType='" + sipServerType + '\'' +
                ", transport='" + transport + '\'' +
                '}';
    }
}
