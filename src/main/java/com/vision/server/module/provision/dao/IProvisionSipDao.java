package com.vision.server.module.provision.dao;

import com.vision.server.model.ProvisionSipModel;
import org.springframework.stereotype.Repository;

/**
 * 预配置
 * Created by hanqq on 2021/6/9
 * Email:yin13753884368@163.com
 * CSDN:http://blog.csdn.net/yin13753884368/article
 * Github:https://github.com/taxiao213
 */
@Repository
public interface IProvisionSipDao {
    // 创建表
    void createTable();

    // 删除表
    void deleteTable();

    // 插入数据
    void insertTable(ProvisionSipModel provisionSipModel);

    // 更新数据
    void updateTable(ProvisionSipModel provisionSipModel);

    // 表是否存在
    boolean isExistsTable();

    // 查询预配置
//    ProvisionSipModel querySipProvisionForMac(String macAddress);
    ProvisionSipModel querySipProvisionForMac(int visionType, String macAddress);


}
