package com.hubu.mapper;

import com.hubu.pojo.Album;
import com.hubu.pojo.Photo;
import java.util.Map;
import java.util.List;

/**
 * 2 * @Author: 刘钦华
 * 3 * @Date: 2019/4/6 23:20
 * 3 * @Dscription
 */
public interface PhotoMapper {

    /*根据相册Id查找所有的照片*/
    List<Photo> selectPhotoByAlbumId(int albumId);


    /*上传照片*/
    void insertPhoto(Photo photo);


    //删除照片
    /**
     * @author:LiMingGuang
     * 功能描述: 通过id将照片移到回收站
     * @param:
     * @return:
     * @date:2019/4/9
     */
    void UpdatePhotoById(Photo photo);


    //展示回收站的图片
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
     * 功能描述:通过用户输入照片标题进行模糊查询
     * @param:
     * @return:
     * @date:2019/4/9
     * @param map
     */
    List<Photo> SelectPhotoInfoByHeadline(Map<String, Object> map);

/*
* 根据Id展示图片
* */
Photo  selectPhotoBy(int id);

    /**
     * @author:LiMingGuang
     * 功能描述:通过id将照片移出回收站
     * @param:
     * @return:
     * @date:2019/4/9
     */
    void UpdateRecyclePhotoStateById(Photo photo);



}
