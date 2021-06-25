package com.vision.server.utils;

import com.vision.server.model.FeedBackModel;
import com.vision.server.module.feedback.dao.IFeedBackDao;
import org.apache.ibatis.session.SqlSession;

/**
 * feed_back 数据库操作
 * Created by hanqq on 2021/6/8
 * Email:yin13753884368@163.com
 * CSDN:http://blog.csdn.net/yin13753884368/article
 * Github:https://github.com/taxiao213
 */
public class DatabasesFeedBackUtils {
    private static DatabasesFeedBackUtils mDatabasesFeedBackUtils;

    public static DatabasesFeedBackUtils getInstance() {
        if (mDatabasesFeedBackUtils == null) {
            synchronized (DatabasesFeedBackUtils.class) {
                if (mDatabasesFeedBackUtils == null) {
                    mDatabasesFeedBackUtils = new DatabasesFeedBackUtils();
                }
            }
        }
        return mDatabasesFeedBackUtils;
    }

    /**
     * 创建表
     */
    public void createFeedBackTable() {
        try {
            if (isExistsFeedBackTable()) {
                deleteFeedBackTable();
            }
            SqlSession sqlSession = DatabasesUtils.getInstance().getSqlSession();
            if (sqlSession == null) return;
            IFeedBackDao mapper = sqlSession.getMapper(IFeedBackDao.class);
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
    public void deleteFeedBackTable() {
        try {
            SqlSession sqlSession = DatabasesUtils.getInstance().getSqlSession();
            if (sqlSession == null) return;
            IFeedBackDao mapper = sqlSession.getMapper(IFeedBackDao.class);
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
    public void insertFeedBack(FeedBackModel feedBackModel) {
        try {
            SqlSession sqlSession = DatabasesUtils.getInstance().getSqlSession();
            if (sqlSession == null) return;
            IFeedBackDao mapper = sqlSession.getMapper(IFeedBackDao.class);
            mapper.insertTable(feedBackModel);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            System.out.println(" insertProvisionSip exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 更新数据
     */
    public void updateFeedBackMacAddress(FeedBackModel feedBackModel) {
        try {
            SqlSession sqlSession = DatabasesUtils.getInstance().getSqlSession();
            if (sqlSession == null) return;
            IFeedBackDao mapper = sqlSession.getMapper(IFeedBackDao.class);
            mapper.updateTable(feedBackModel);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            System.out.println(" updateProvisionSip exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 是否存在表
     */
    public boolean isExistsFeedBackTable() {
        boolean existsTable = false;
        try {
            SqlSession sqlSession = DatabasesUtils.getInstance().getSqlSession();
            if (sqlSession == null) return false;
            IFeedBackDao mapper = sqlSession.getMapper(IFeedBackDao.class);
            existsTable = mapper.isExistsTable();
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            System.out.println(" isExistsTable exception: " + e.getMessage());
            e.printStackTrace();
        }
        return existsTable;
    }

    /**
     * 根据 macAddress 查询
     */
    public FeedBackModel queryForMac(int visionType, String macAddress) {
        try {
            SqlSession sqlSession = DatabasesUtils.getInstance().getSqlSession();
            if (sqlSession == null) return null;
            IFeedBackDao mapper = sqlSession.getMapper(IFeedBackDao.class);
            FeedBackModel sipModel = mapper.queryForMac(visionType, macAddress);
            sqlSession.commit();
            sqlSession.close();
            if (sipModel != null) {
                if (null == sipModel.getMacAddress()) {
                    sipModel.setMacAddress(macAddress);
                    sipModel.setVisionType(visionType);
                    updateFeedBackMacAddress(sipModel);
                }
            }
            return sipModel;
        } catch (Exception e) {
            System.out.println(" querySipProvisionForMac exception: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
