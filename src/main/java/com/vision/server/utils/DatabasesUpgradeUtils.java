package com.vision.server.utils;

import com.vision.server.model.FeedBackModel;
import com.vision.server.model.UpgradeModel;
import com.vision.server.module.feedback.dao.IFeedBackDao;
import com.vision.server.module.upgrade.dao.IUpgradeDao;
import org.apache.ibatis.session.SqlSession;

/**
 * upgrade 数据库操作
 * Created by hanqq on 2021/6/8
 * Email:yin13753884368@163.com
 * CSDN:http://blog.csdn.net/yin13753884368/article
 * Github:https://github.com/taxiao213
 */
public class DatabasesUpgradeUtils {
    private static DatabasesUpgradeUtils mDatabasesUpgradeUtils;

    public static DatabasesUpgradeUtils getInstance() {
        if (mDatabasesUpgradeUtils == null) {
            synchronized (DatabasesUpgradeUtils.class) {
                if (mDatabasesUpgradeUtils == null) {
                    mDatabasesUpgradeUtils = new DatabasesUpgradeUtils();
                }
            }
        }
        return mDatabasesUpgradeUtils;
    }

    /**
     * 创建表
     */
    public void createUpgradeTable() {
        try {
            if (isExistsUpgradeTable()) {
                deleteUpgradeTable();
            }
            SqlSession sqlSession = DatabasesUtils.getInstance().getSqlSession();
            if (sqlSession == null) return;
            IUpgradeDao mapper = sqlSession.getMapper(IUpgradeDao.class);
            mapper.createTable();
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            System.out.println(" createTable exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 删除表
     */
    public void deleteUpgradeTable() {
        try {
            SqlSession sqlSession = DatabasesUtils.getInstance().getSqlSession();
            if (sqlSession == null) return;
            IUpgradeDao mapper = sqlSession.getMapper(IUpgradeDao.class);
            mapper.deleteTable();
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            System.out.println(" deleteTable exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 插入数据
     */
    public void insertUpgradeBack(UpgradeModel feedBackModel) {
        try {
            SqlSession sqlSession = DatabasesUtils.getInstance().getSqlSession();
            if (sqlSession == null) return;
            IUpgradeDao mapper = sqlSession.getMapper(IUpgradeDao.class);
            mapper.insertTable(feedBackModel);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            System.out.println(" insertProvisionSip exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 是否存在表
     */
    public boolean isExistsUpgradeTable() {
        boolean existsTable = false;
        try {
            SqlSession sqlSession = DatabasesUtils.getInstance().getSqlSession();
            if (sqlSession == null) return false;
            IUpgradeDao mapper = sqlSession.getMapper(IUpgradeDao.class);
            existsTable = mapper.isExistsTable();
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            System.out.println(" isExistsTable exception: " + e.getMessage());
            e.printStackTrace();
        }
        return existsTable;
    }
}
