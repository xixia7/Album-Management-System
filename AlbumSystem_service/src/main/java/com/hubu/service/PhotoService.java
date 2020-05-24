package com.hubu.service;

import com.hubu.pojo.Album;
import com.hubu.pojo.Photo;
import  java.util.Map;
import java.util.List;

/**
 * 2 * @Author: 刘钦华
 * 3 * @Date: 2019/4/6 23:49
 * 3 * @Dscription
 */
public interface PhotoService {

    //根据相册Id查找照片接口
    List<Photo> selectPhotoByAlbumId(int albumId);


    //上传照片接口
    void insertPhoto(int albumId, String headline, String explain, String fileName, String time, String Photo_Size);


    //删除照片（移入回收站）
    /**
     * @author:LiMingGuang
     * 功能描述: 通过id将照片移到回收站
     * @param:
     * @return:
     * @date:2019/4/9
     */
    void DeletePhotoById(Photo photo);


    /**
     * @author:LiMingGuang
     * 功能描述: 查询该用户回收站内的所有未过期照片
     * @param:
     * @return:
     * @date:2019/4/9
     */
    List<Photo> SelectAllRecyclePhoto(int uid);



    /**
     * @author:LiMingGuang
     * 功能描述: 通过用户输入照片标题进行模糊查询
     * @param:
     * @return:
     * @date:2019/4/9
     */
    List<Photo> SelectPhotoInfoByHeadline(Map<String, Object> map);

/*
* 显示一张图片
* */
Photo selectPhotoById(int id);



    /**
     * @author:LiMingGuang
     * 功能描述: 通过id将照片移出回收站
     * @param:
     * @return:
     * @date:2019/4/9
     */
    void RestoreRecyclePhotoById(Photo photo);


}
