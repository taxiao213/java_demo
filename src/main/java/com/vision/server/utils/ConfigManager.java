package com.vision.server.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * application.properties 文件加载
 * Created by hanqq on 2021/6/8
 * Email:yin13753884368@163.com
 * CSDN:http://blog.csdn.net/yin13753884368/article
 * Github:https://github.com/taxiao213
 */
public class ConfigManager {
    private static ConfigManager mConfigManager;
    private Properties properties;
    private InputStream inputStream;

    private ConfigManager() {
        properties = new Properties();
        inputStream = ConfigManager.class.getClassLoader().getResourceAsStream("application.properties");
        try {
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConfigManager getInstance() {
        if (mConfigManager == null) {
            synchronized (ConfigManager.class) {
                if (mConfigManager == null) {
                    mConfigManager = new ConfigManager();
                }
            }
        }
        return mConfigManager;
    }

    /**
     * 获取 value 值
     * @param key
     * @return
     */
    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
