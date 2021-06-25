package com.vision.server.module.feedback.action;

import com.vision.server.model.FeedBackModel;
import com.vision.server.model.ProvisionSipModel;
import com.vision.server.module.feedback.service.FeedBackService;
import com.vision.server.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * 反馈问题接口
 * Created by hanqq on 2021/6/8
 * Email:yin13753884368@163.com
 * CSDN:http://blog.csdn.net/yin13753884368/article
 * Github:https://github.com/taxiao213
 */
@RestController
@RequestMapping(value = "/vision/feedback", method = RequestMethod.POST)
public class FeedBackAction {
    @Autowired
    FeedBackService feedBackService;

    @GetMapping("/hello")
    public String hello() {
        return "hello FeedBackAction";
    }

    /**
     * 发送反馈报告
     * {
     * "visionType": 1,
     * "ip": "172.21.0.112",
     * "macAddress": "AA:BB:80:AB:BD:E2",
     * "callProblem": 1,
     * "videoBlur": 1,
     * "otherVideoIssues": 1,
     * "upgradeIssues": 1,
     * "otherProblem": "0",
     * "audioProblem": "0",
     * "dualStream": "0",
     * "configurationProblem": "0",
     * "cameraProblem": "0"
     * }
     *
     * @param feedback
     * @return
     */
    @ResponseBody
    @GetMapping("/sendFeekBack")
    public void insertFeedBack(int visionType, String feedback) {
        if (!StringUtils.isEmpty(feedback)) {
            FeedBackModel feedBackModel = JsonUtils.string2Obj(feedback, FeedBackModel.class);
            System.out.println("feedBackModel " + feedBackModel.toString());
            feedBackService.insertFeedBack(visionType, feedBackModel);
        }
    }
}
