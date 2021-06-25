package com.vision.server.module.feedback.service.impl;

import com.vision.server.model.FeedBackModel;
import com.vision.server.module.feedback.dao.IFeedBackDao;
import com.vision.server.module.feedback.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 反馈问题接口
 * Created by hanqq on 2021/6/8
 * Email:yin13753884368@163.com
 * CSDN:http://blog.csdn.net/yin13753884368/article
 * Github:https://github.com/taxiao213
 */
@Service
public class FeedBackServiceImpl implements FeedBackService {
    @Autowired
    private IFeedBackDao iFeedBackDao;

    @Override
    public void insertFeedBack(int visionType, FeedBackModel model) {
        if (model != null) {
            FeedBackModel feedBackModel = iFeedBackDao.queryForMac(visionType, model.getMacAddress());
            if (feedBackModel == null) {
                iFeedBackDao.insertTable(model);
            } else {
                feedBackModel.setCallProblem(model.getCallProblem() + feedBackModel.getCallProblem());
                feedBackModel.setAudioProblem(model.getAudioProblem() + feedBackModel.getAudioProblem());
                feedBackModel.setCameraProblem(model.getCameraProblem() + feedBackModel.getCameraProblem());
                feedBackModel.setConfigurationProblem(model.getConfigurationProblem() + feedBackModel.getConfigurationProblem());
                feedBackModel.setDualStream(model.getDualStream() + feedBackModel.getDualStream());
                feedBackModel.setOtherProblem(model.getOtherProblem() + feedBackModel.getOtherProblem());
                feedBackModel.setOtherVideoIssues(model.getOtherVideoIssues() + feedBackModel.getOtherVideoIssues());
                feedBackModel.setUpgradeIssues(model.getUpgradeIssues() + feedBackModel.getUpgradeIssues());
                feedBackModel.setVideoBlur(model.getVideoBlur() + feedBackModel.getVideoBlur());
                iFeedBackDao.updateTable(feedBackModel);
            }
        }
    }
}
