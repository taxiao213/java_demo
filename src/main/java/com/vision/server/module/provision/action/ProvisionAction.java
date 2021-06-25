package com.vision.server.module.provision.action;

import com.vision.server.constant.TXConstant;
import com.vision.server.model.ProvisionSipModel;
import com.vision.server.module.provision.service.ProvisionSipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * 控制器
 * Created by hanqq on 2021/6/8
 * Email:yin13753884368@163.com
 * CSDN:http://blog.csdn.net/yin13753884368/article
 * Github:https://github.com/taxiao213
 */
@RestController
@RequestMapping(value = "/vision/provision", method = RequestMethod.POST)
public class ProvisionAction {

    @Autowired
    ProvisionSipService provisionSipService;

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }

    /**
     * 获取预配置项
     *
     * @param macAddress
     * @return
     */
    @ResponseBody
    @GetMapping("/getProvisionSip")
    public ProvisionSipModel getProvisionSip(int visionType, String macAddress, String userName, String passWord) {
        System.out.println("getProvisionSip mac: " + macAddress + " visionType: " + visionType + " userName: " + userName + " passWord: " + passWord);
        if (StringUtils.pathEquals(userName, TXConstant.SIP_USER_NAME) && StringUtils.pathEquals(passWord, TXConstant.SIP_USER_PASS_WORD)) {
            ProvisionSipModel provisionSipModel = provisionSipService.querySipProvisionForMac(visionType, macAddress);
            if (provisionSipModel != null) {
                if (null == provisionSipModel.getMacAddress()) {
                    provisionSipModel.setMacAddress(macAddress);
                    provisionSipService.updateProvisionSipMacAddress(provisionSipModel);
                }
            }
            return provisionSipModel;
        }
        return null;
    }
}
