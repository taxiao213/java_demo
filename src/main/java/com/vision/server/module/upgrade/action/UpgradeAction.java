package com.vision.server.module.upgrade.action;

import com.vision.server.model.ProvisionSipModel;
import com.vision.server.model.UpgradeModel;
import com.vision.server.module.provision.service.ProvisionSipService;
import com.vision.server.module.upgrade.service.UpgradeService;
import com.vision.server.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * 升级接口
 * Created by hanqq on 2021/6/8
 * Email:yin13753884368@163.com
 * CSDN:http://blog.csdn.net/yin13753884368/article
 * Github:https://github.com/taxiao213
 */
@RestController
@RequestMapping(value = "/vision/upgrade", method = RequestMethod.POST)
public class UpgradeAction {

    @Autowired
    UpgradeService upgradeService;

    @GetMapping("/getUpgradeInfo")
    public UpgradeModel getUpgrade(int visionType) {
        return upgradeService.queryUpgrade(visionType);
    }

    /**
     * {
     * "visionType": 1,
     * "versionCode": 11,
     * "versionName": "1.0.0",
     * "apkSize": "15",
     * "apkUrl": "http:",
     * "pkgSize": "0",
     * "pkgUrl": "0"
     * }
     *
     * @param upgrade
     */
    @GetMapping("/setUpgradeInfo")
    public void setUpgrade(String upgrade) {
        if (!StringUtils.isEmpty(upgrade)) {
            UpgradeModel model = JsonUtils.string2Obj(upgrade, UpgradeModel.class);
            upgradeService.insertUpgrade(model);
        }
    }
}
