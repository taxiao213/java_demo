package com.vision.server.module.feedback.dao;

import org.springframework.stereotype.Repository;

import com.vision.server.model.FeedBackModel;
import com.vision.server.model.ProvisionSipModel;

import java.util.Map;

/**
 * 反馈问题
 * Created by hanqq on 2021/6/9
 * Email:yin13753884368@163.com
 * CSDN:http://blog.csdn.net/yin13753884368/article
 * Github:https://github.com/taxiao213
 */
@Repository
public interface IFeedBackDao {
    // 创建表
    void createTable();

    // 删除表
    void deleteTable();

    // 插入数据
    void insertTable(FeedBackModel feedBackModel);

    // 更新数据
    void updateTable(FeedBackModel feedBackModel);
//    void updateTable(Map<String, Object> map);

    // 表是否存在
    boolean isExistsTable();

    // 查询预配置
//    FeedBackModel queryForMac(Map<String, Object> map);
    FeedBackModel queryForMac(int visionType, String macAddress);
}
