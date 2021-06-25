package com.vision.server.module.upgrade.service;

import com.vision.server.model.ProvisionSipModel;
import com.vision.server.model.UpgradeModel;

/**
 * 升级接口
 * Created by hanqq on 2021/6/8
 * Email:yin13753884368@163.com
 * CSDN:http://blog.csdn.net/yin13753884368/article
 * Github:https://github.com/taxiao213
 */
public interface UpgradeService {

    UpgradeModel queryUpgrade(int visionType);

    void insertUpgrade(UpgradeModel model);

    void deleteUpgrade(int visionType);
}
