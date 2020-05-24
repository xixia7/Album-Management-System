package com.hubu.service;

import com.hubu.pojo.Album;
import com.hubu.pojo.Users;

import java.util.List;
import java.util.Map;

/**
 * @Author: ；吕庆龙
 * @Date: 2019/4/4
 * @Description: com.hubu.service
 * @version: 1.0
 */
public interface AlbumService {


    List<Album>  getAllAlbumByuid(Users user);

    int createAlbumByuid(Map<String,Object> map);

    int deleteAlbumByuid(Map<String, Object> map);

    int updateAlbumById(Album album);
}
