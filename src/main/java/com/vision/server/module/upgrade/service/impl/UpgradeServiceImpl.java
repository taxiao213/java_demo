package com.vision.server.module.upgrade.service.impl;

import com.vision.server.model.UpgradeModel;
import com.vision.server.module.upgrade.dao.IUpgradeDao;
import com.vision.server.module.upgrade.service.UpgradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hanqq on 2021/6/8
 * Email:yin13753884368@163.com
 * CSDN:http://blog.csdn.net/yin13753884368/article
 * Github:https://github.com/taxiao213
 */
@Service
public class UpgradeServiceImpl implements UpgradeService {
    @Autowired
    IUpgradeDao iUpgradeDao;

    @Override
    public UpgradeModel queryUpgrade(int visionType) {
        return iUpgradeDao.queryUpgrade(visionType);
    }

    @Override
    public void insertUpgrade(UpgradeModel model) {
        if (model != null) {
            if (iUpgradeDao.queryUpgrade(model.getVisionType()) != null) {
                deleteUpgrade(model.getVisionType());
            }
            iUpgradeDao.insertTable(model);
        }
    }

    @Override
    public void deleteUpgrade(int visionType) {
        if (iUpgradeDao.isExistsTable()) {
            iUpgradeDao.deleteUpgrade(visionType);
        }
    }
}
