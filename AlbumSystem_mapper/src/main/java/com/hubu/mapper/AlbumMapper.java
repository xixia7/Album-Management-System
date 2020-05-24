package com.hubu.mapper;

import com.hubu.pojo.Album;
import com.hubu.pojo.Users;

import java.util.List;
import java.util.Map;

/**
 * @Author: ；吕庆龙
 * @Date: 2019/4/4
 * @Description: com.hubu.mapper
 * @version: 1.0
 */
public interface AlbumMapper {

    List<Album> selectAllAlbumByuid(Users user);

    int insertAlbumByuid(Map<String,Object> map);

    int deleteAlbumByuid(Map<String, Object> map);

    int updateAlbumById(Album album);
}
