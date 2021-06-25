package com.vision.server.module.provision.service;

import com.vision.server.model.ProvisionSipModel;

/**
 * 预配置接口
 * Created by hanqq on 2021/6/8
 * Email:yin13753884368@163.com
 * CSDN:http://blog.csdn.net/yin13753884368/article
 * Github:https://github.com/taxiao213
 */
public interface ProvisionSipService {

    ProvisionSipModel querySipProvisionForMac(int visionType, String macAddress);

    ProvisionSipModel updateProvisionSipMacAddress(ProvisionSipModel provisionSipModel);
}
