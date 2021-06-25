package com.vision.server.model;

/**
 * 反馈问题
 * Created by hanqq on 2021/6/9
 * Email:yin13753884368@163.com
 * CSDN:http://blog.csdn.net/yin13753884368/article
 * Github:https://github.com/taxiao213
 */
public class FeedBackModel {
    // 主键 唯一
    private int id;
    // visionType 区分版本
    private int visionType;
    // ip
    private String ip;
    // mac 地址 唯一
    private String macAddress;
    // 呼叫问题
    private int callProblem;
    // 视频花屏或蓝屏
    private int videoBlur;
    // 其他视频问题
    private int otherVideoIssues;
    // 升级问题
    private int upgradeIssues;
    // 其他问题
    private int otherProblem;
    // 音频问题
    private int audioProblem;
    // 双流花屏或蓝屏
    private int dualStream;
    // 配置问题
    private int configurationProblem;
    // 摄像头或麦克风问题
    private int cameraProblem;

    public int getVisionType() {
        return visionType;
    }

    public void setVisionType(int visionType) {
        this.visionType = visionType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public int getCallProblem() {
        return callProblem;
    }

    public void setCallProblem(int callProblem) {
        this.callProblem = callProblem;
    }

    public int getVideoBlur() {
        return videoBlur;
    }

    public void setVideoBlur(int videoBlur) {
        this.videoBlur = videoBlur;
    }

    public int getOtherVideoIssues() {
        return otherVideoIssues;
    }

    public void setOtherVideoIssues(int otherVideoIssues) {
        this.otherVideoIssues = otherVideoIssues;
    }

    public int getUpgradeIssues() {
        return upgradeIssues;
    }

    public void setUpgradeIssues(int upgradeIssues) {
        this.upgradeIssues = upgradeIssues;
    }

    public int getOtherProblem() {
        return otherProblem;
    }

    public void setOtherProblem(int otherProblem) {
        this.otherProblem = otherProblem;
    }

    public int getAudioProblem() {
        return audioProblem;
    }

    public void setAudioProblem(int audioProblem) {
        this.audioProblem = audioProblem;
    }

    public int getDualStream() {
        return dualStream;
    }

    public void setDualStream(int dualStream) {
        this.dualStream = dualStream;
    }

    public int getConfigurationProblem() {
        return configurationProblem;
    }

    public void setConfigurationProblem(int configurationProblem) {
        this.configurationProblem = configurationProblem;
    }

    public int getCameraProblem() {
        return cameraProblem;
    }

    public void setCameraProblem(int cameraProblem) {
        this.cameraProblem = cameraProblem;
    }

    @Override
    public String toString() {
        return "FeedBackModel{" +
                "id=" + id +
                ", visionType=" + visionType +
                ", ip='" + ip + '\'' +
                ", macAddress='" + macAddress + '\'' +
                ", callProblem=" + callProblem +
                ", videoBlur=" + videoBlur +
                ", otherVideoIssues=" + otherVideoIssues +
                ", upgradeIssues=" + upgradeIssues +
                ", otherProblem=" + otherProblem +
                ", audioProblem=" + audioProblem +
                ", dualStream=" + dualStream +
                ", configurationProblem=" + configurationProblem +
                ", cameraProblem=" + cameraProblem +
                '}';
    }
}
