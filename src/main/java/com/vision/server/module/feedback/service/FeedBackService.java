package com.vision.server.module.feedback.service;

import com.vision.server.model.FeedBackModel;

/**
 * 反馈问题接口
 * Created by hanqq on 2021/6/8
 * Email:yin13753884368@163.com
 * CSDN:http://blog.csdn.net/yin13753884368/article
 * Github:https://github.com/taxiao213
 */
public interface FeedBackService {
    void insertFeedBack(int visionType, FeedBackModel feedBackModel);
}
