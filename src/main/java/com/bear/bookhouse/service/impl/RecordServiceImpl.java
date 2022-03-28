package com.bear.bookhouse.service.impl;


import com.bear.bookhouse.dao.DownloadDao;
import com.bear.bookhouse.dao.FavoriteDao;
import com.bear.bookhouse.dao.LoginLogDao;
import com.bear.bookhouse.dao.UploadDao;
import com.bear.bookhouse.dao.impl.DownloadDaoImpl;
import com.bear.bookhouse.dao.impl.FavoriteDaoImpl;
import com.bear.bookhouse.dao.impl.LoginLogLogDaoImpl;
import com.bear.bookhouse.dao.impl.UploadDaoImpl;
import com.bear.bookhouse.pojo.*;
import com.bear.bookhouse.service.RecordService;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/26 10:49
 */
public class RecordServiceImpl implements RecordService {
    private final DownloadDao downloadDao = new DownloadDaoImpl();
    private final UploadDao uploadDao = new UploadDaoImpl();
    private final LoginLogDao loginLogDao = new LoginLogLogDaoImpl();
    private final FavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Override
    public boolean saveDownload(Download download) {
        return downloadDao.saveDownload(download) == 1;
    }

    @Override
    public Page<Download> getDownloadPageData(int userId, int pageNum, int pageSize) {
        Page<Download> page = new Page<>();
        page.setPageSize(pageSize);

        // 获取用户下载登录总记录数
        int downloadCounts = downloadDao.getDownloadCountsByUserId(userId);
        if (downloadCounts <= 0) {
            return null;
        }
        // 根据总记录数和每页显示的数量求解总页数
        int pageTotal = downloadCounts / pageSize;
        if (downloadCounts % pageSize != 0) {
            pageTotal++;
        }
        // 设置当前总记录数和总页数
        page.setRecordTotal(downloadCounts);
        page.setPageTotal(pageTotal);
        // 当前页码数据边界性检查
        if (pageNum <= 0) {
            pageNum = 1;
        } else if (pageNum > pageTotal && pageTotal != 0) {
            pageNum = pageTotal;
        }
        page.setPageNum(pageNum);
        // 获取当前页的用户下载记录数据
        page.setPageData(downloadDao.listDownloadThoughUserIdByBeginAndOffset(userId, pageNum, pageSize));
        return page;
    }

    @Override
    public boolean saveUpload(Upload upload) {
        return uploadDao.saveUpload(upload) == 1;
    }

    @Override
    public Page<Upload> getUploadPageData(int userId, int pageNum, int pageSize) {
        Page<Upload> page = new Page<>();
        page.setPageSize(pageSize);

        // 获取用户上传登录总记录数
        int userUploadCounts = uploadDao.getUploadCountsByUserId(userId);
        if (userUploadCounts <= 0) {
            return null;
        }
        // 根据总记录数和每页显示的数量求解总页数
        int pageTotal = userUploadCounts / pageSize;
        if (userUploadCounts % pageSize != 0) {
            pageTotal++;
        }
        // 设置当前总记录数和总页数
        page.setRecordTotal(userUploadCounts);
        page.setPageTotal(pageTotal);
        // 当前页码数据边界性检查
        if (pageNum <= 0) {
            pageNum = 1;
        } else if (pageNum > pageTotal && pageTotal != 0) {
            pageNum = pageTotal;
        }
        page.setPageNum(pageNum);
        // 获取当前页的用户上传记录数据
        page.setPageData(uploadDao.listUploadThoughUserIdByBeginAndOffset(userId, pageNum, pageSize));
        return page;
    }

    @Override
    public boolean saveLoginLog(LoginLog loginLog) {
        return loginLogDao.saveLoginLog(loginLog) == 1;
    }

    @Override
    public Page<LoginLog> getLoginLogPageData(int userId, int pageNum, int pageSize) {
        Page<LoginLog> page = new Page<>();
        page.setPageSize(pageSize);

        // 获取用户登录总记录数
        int userLoginLogCounts = loginLogDao.getUserLoginLogCounts(userId);
        if (userLoginLogCounts <= 0) {
            return null;
        }
        // 根据总记录数和每页显示的数量求解总页数
        int pageTotal = userLoginLogCounts / pageSize;
        if (userLoginLogCounts % pageSize != 0) {
            pageTotal++;
        }
        // 设置当前总记录数和总页数
        page.setRecordTotal(userLoginLogCounts);
        page.setPageTotal(pageTotal);
        // 当前页码数据边界性检查
        if (pageNum <= 0) {
            pageNum = 1;
        } else if (pageNum > pageTotal && pageTotal != 0) {
            pageNum = pageTotal;
        }
        page.setPageNum(pageNum);
        // 获取当前页的用户登录数据
        page.setPageData(loginLogDao.listLoginLogsThoughUserIdByBeginAndOffset(userId, pageNum, pageSize));
        return page;
    }

    @Override
    public List<Upload> listUploadForAdmin() {
        return uploadDao.listUploadByState(Upload.NOT_PROCESSED);
    }

    @Override
    public boolean updateUploadState(int id) {
        return uploadDao.updateUploadStateById(id, Upload.PROCESSED) == 1;
    }

    @Override
    public Upload getFirstNotProcessedUpload(String state) {
        return uploadDao.getOneUploadByState(Upload.NOT_PROCESSED);
    }

    @Override
    public boolean addFavorite(Favorite favorite) {
        return favoriteDao.saveFavorite(favorite) == 1;
    }

    @Override
    public boolean isFavoriteExists(int userId, int booId) {
        return favoriteDao.getFavoriteByUserIdAndBookId(userId, booId) != null;
    }

    @Override
    public List<Favorite> getUserFavorites(int userId) {
        return favoriteDao.listFavoritesByUserId(userId);
    }

    @Override
    public boolean deleteUserFavorite(int userId, int bookId) {
        return favoriteDao.deleteFavoriteByUserIdAndBookId(userId, bookId) == 1;
    }
}
