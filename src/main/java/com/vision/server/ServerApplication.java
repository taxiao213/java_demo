package com.vision.server;

import com.vision.server.constant.TXConstant;
import com.vision.server.model.ProvisionSipModel;
import com.vision.server.utils.DatabasesFeedBackUtils;
import com.vision.server.utils.DatabasesProvisionSipUtils;
import com.vision.server.utils.DatabasesUpgradeUtils;
import com.vision.server.utils.DatabasesUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.Connection;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = {"com.vision.server.**.dao"})
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
//        Connection connection = DatabasesUtils.getInstance().getConnection();
//        DatabasesUtils.getInstance().query(connection);

//        DatabasesProvisionSipUtils.getInstance().createProvisionSipTable();
//        DatabasesFeedBackUtils.getInstance().createFeedBackTable();
//        DatabasesUpgradeUtils.getInstance().createUpgradeTable();

//        if (DatabasesProvisionSipUtils.getInstance().isExistsProvisionSipTable()) {
//        for (int i = 0; i < 30; i++) {
//            int username = TXConstant.SIP_USER_NAME_PREFIX + i;
//            ProvisionSipModel sipModel = new ProvisionSipModel(TXConstant.PRODUCT_VE_210, TXConstant.SIP_PROXY_SERVER, TXConstant.SIP_DOMAIN_SERVER, String.valueOf(username), String.valueOf(username), TXConstant.SIP_PASSWORD);
//            DatabasesProvisionSipUtils.getInstance().insertProvisionSip(sipModel);
//        }
//        }
    }

}
