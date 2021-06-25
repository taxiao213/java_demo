package com.vision.server.utils;

import com.vision.server.model.ProvisionSipModel;
import com.vision.server.module.provision.dao.IProvisionSipDao;
import org.apache.ibatis.session.SqlSession;

/**
 * ProvisionSip 数据库操作
 * Created by hanqq on 2021/6/8
 * Email:yin13753884368@163.com
 * CSDN:http://blog.csdn.net/yin13753884368/article
 * Github:https://github.com/taxiao213
 */
public class DatabasesProvisionSipUtils {
    private static DatabasesProvisionSipUtils mDatabasesProvisionSipUtils;

    public static DatabasesProvisionSipUtils getInstance() {
        if (mDatabasesProvisionSipUtils == null) {
            synchronized (DatabasesProvisionSipUtils.class) {
                if (mDatabasesProvisionSipUtils == null) {
                    mDatabasesProvisionSipUtils = new DatabasesProvisionSipUtils();
                }
            }
        }
        return mDatabasesProvisionSipUtils;
    }

    /**
     * 创建表
     */
    public void createProvisionSipTable() {
        try {
            if (isExistsProvisionSipTable()) {
                deleteProvisionSipTable();
            }
            SqlSession sqlSession = DatabasesUtils.getInstance().getSqlSession();
            if (sqlSession == null) return;
            IProvisionSipDao mapper = sqlSession.getMapper(IProvisionSipDao.class);
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
    public void deleteProvisionSipTable() {
        try {
            SqlSession sqlSession = DatabasesUtils.getInstance().getSqlSession();
            if (sqlSession == null) return;
            IProvisionSipDao mapper = sqlSession.getMapper(IProvisionSipDao.class);
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
    public void insertProvisionSip(ProvisionSipModel provisionSipModel) {
        try {
            SqlSession sqlSession = DatabasesUtils.getInstance().getSqlSession();
            if (sqlSession == null) return;
            IProvisionSipDao mapper = sqlSession.getMapper(IProvisionSipDao.class);
            mapper.insertTable(provisionSipModel);
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
    public void updateProvisionSipMacAddress(ProvisionSipModel provisionSipModel) {
        try {
            SqlSession sqlSession = DatabasesUtils.getInstance().getSqlSession();
            if (sqlSession == null) return;
            IProvisionSipDao mapper = sqlSession.getMapper(IProvisionSipDao.class);
            mapper.updateTable(provisionSipModel);
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
    public boolean isExistsProvisionSipTable() {
        boolean existsTable = false;
        try {
            SqlSession sqlSession = DatabasesUtils.getInstance().getSqlSession();
            if (sqlSession == null) return false;
            IProvisionSipDao mapper = sqlSession.getMapper(IProvisionSipDao.class);
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
    public ProvisionSipModel querySipProvisionForMac(int visionType, String macAddress) {
        try {
            SqlSession sqlSession = DatabasesUtils.getInstance().getSqlSession();
            if (sqlSession == null) return null;
            IProvisionSipDao mapper = sqlSession.getMapper(IProvisionSipDao.class);
            ProvisionSipModel sipModel = mapper.querySipProvisionForMac(visionType, macAddress);
            sqlSession.commit();
            sqlSession.close();
            if (sipModel != null) {
                if (null == sipModel.getMacAddress()) {
                    sipModel.setMacAddress(macAddress);
                    sipModel.setVisionType(visionType);
                    updateProvisionSipMacAddress(sipModel);
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
