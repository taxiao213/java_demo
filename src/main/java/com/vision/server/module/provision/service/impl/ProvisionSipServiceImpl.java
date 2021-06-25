package com.vision.server.module.provision.service.impl;

import com.vision.server.model.ProvisionSipModel;
import com.vision.server.module.provision.dao.IProvisionSipDao;
import com.vision.server.module.provision.service.ProvisionSipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 预配置接口
 * Created by hanqq on 2021/6/8
 * Email:yin13753884368@163.com
 * CSDN:http://blog.csdn.net/yin13753884368/article
 * Github:https://github.com/taxiao213
 */
@Service
public class ProvisionSipServiceImpl implements ProvisionSipService {

    @Autowired
    private IProvisionSipDao iProvisionSipDao;

    @Override
    public ProvisionSipModel querySipProvisionForMac(int visionType, String macAddress) {
        return iProvisionSipDao.querySipProvisionForMac(visionType, macAddress);
    }

    @Override
    public ProvisionSipModel updateProvisionSipMacAddress(ProvisionSipModel provisionSipModel) {
        iProvisionSipDao.updateTable(provisionSipModel);
        return null;
    }
}
