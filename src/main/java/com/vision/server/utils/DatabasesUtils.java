package com.vision.server.utils;

import com.vision.server.constant.TXConstant;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库连接工具
 * Created by hanqq on 2021/6/8
 * Email:yin13753884368@163.com
 * CSDN:http://blog.csdn.net/yin13753884368/article
 * Github:https://github.com/taxiao213
 */
public class DatabasesUtils {
    private static DatabasesUtils mDatabasesUtils;
    private final String DRIVER;
    private final String URL;
    private final String USERNAME;
    private final String PASSWORD;

    private DatabasesUtils() {
        DRIVER = ConfigManager.getInstance().getValue("spring.datasource.driver-class-name");
        URL = ConfigManager.getInstance().getValue("spring.datasource.url");
        USERNAME = ConfigManager.getInstance().getValue("spring.datasource.username");
        PASSWORD = ConfigManager.getInstance().getValue("spring.datasource.password");
    }

    public static DatabasesUtils getInstance() {
        if (mDatabasesUtils == null) {
            synchronized (DatabasesUtils.class) {
                if (mDatabasesUtils == null) {
                    mDatabasesUtils = new DatabasesUtils();
                }
            }
        }
        return mDatabasesUtils;
    }

    /**
     * 获取连接库
     *
     * @return Connection
     */
    public Connection getConnection() {
        Connection connection = null;
        try {
            if (URL != null && USERNAME != null && PASSWORD != null) {
                // 注册JDBC驱动程序
                Class.forName(DRIVER);
                // 建立连接
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void query(Connection connection) {
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String sql = "CREATE TABLE Persons\n" +
                        "(\n" +
                        "Id_P int,\n" +
                        "LastName varchar(255),\n" +
                        "FirstName varchar(255),\n" +
                        "Address varchar(255),\n" +
                        "City varchar(255)\n" +
                        ")";
                boolean execute = statement.execute(sql);
                System.out.println(" 创建 ：" + execute);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 获取 mybatis session
     *
     * @return
     */
    public SqlSession getSqlSession() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(TXConstant.MYBATIS_CONFIG_NAME);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory.openSession();
    }

}
