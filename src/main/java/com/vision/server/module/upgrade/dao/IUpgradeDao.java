package com.vision.server.module.upgrade.dao;

import com.vision.server.model.ProvisionSipModel;
import com.vision.server.model.UpgradeModel;
import org.springframework.stereotype.Repository;

/**
 * 升级
 * Created by hanqq on 2021/6/9
 * Email:yin13753884368@163.com
 * CSDN:http://blog.csdn.net/yin13753884368/article
 * Github:https://github.com/taxiao213
 */
@Repository
public interface IUpgradeDao {
    // 创建表
    void createTable();

    // 删除表
    void deleteTable();

    // 插入数据
    void insertTable(UpgradeModel model);

    // 表是否存在
    boolean isExistsTable();

    // 查询升级
    UpgradeModel queryUpgrade(int visionType);

    // 删除升级数据
    void deleteUpgrade(int visionType);
}
