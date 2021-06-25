package com.vision.server.model;

/**
 * 升级
 * Created by hanqq on 2021/6/8
 * Email:yin13753884368@163.com
 * CSDN:http://blog.csdn.net/yin13753884368/article
 * Github:https://github.com/taxiao213
 */
public class UpgradeModel {
    // 主键 唯一
    private int id;
    private int visionType;
    private int versionCode;
    private String versionName;
    private String apkSize;
    private String apkUrl;
    private String pkgSize;
    private String pkgUrl;

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

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getApkSize() {
        return apkSize;
    }

    public void setApkSize(String apkSize) {
        this.apkSize = apkSize;
    }

    public String getApkUrl() {
        return apkUrl;
    }

    public void setApkUrl(String apkUrl) {
        this.apkUrl = apkUrl;
    }

    public String getPkgSize() {
        return pkgSize;
    }

    public void setPkgSize(String pkgSize) {
        this.pkgSize = pkgSize;
    }

    public String getPkgUrl() {
        return pkgUrl;
    }

    public void setPkgUrl(String pkgUrl) {
        this.pkgUrl = pkgUrl;
    }

    @Override
    public String toString() {
        return "UpgradeModel{" +
                "id=" + id +
                ", visionType=" + visionType +
                ", versionCode=" + versionCode +
                ", versionName='" + versionName + '\'' +
                ", apkSize='" + apkSize + '\'' +
                ", apkUrl='" + apkUrl + '\'' +
                ", pkgSize='" + pkgSize + '\'' +
                ", pkgUrl='" + pkgUrl + '\'' +
                '}';
    }
}
