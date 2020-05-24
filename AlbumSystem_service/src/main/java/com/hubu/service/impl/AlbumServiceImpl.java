package com.hubu.service.impl;

import com.hubu.mapper.AlbumMapper;
import com.hubu.pojo.Album;
import com.hubu.pojo.Users;
import com.hubu.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: ；吕庆龙
 * @Date: 2019/4/4
 * @Description: com.hubu.service.impl
 * @version: 1.0
 */
@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumMapper albumMapper;

    @Override
    public List<Album> getAllAlbumByuid(Users user) {
        List<Album> lp = albumMapper.selectAllAlbumByuid(user);
        return lp;
    }

    @Override
    public int createAlbumByuid(Map<String,Object> map) {
        int index = albumMapper.insertAlbumByuid(map);
        return index;
    }

    @Override
    public int deleteAlbumByuid(Map<String, Object> map) {
        int index = albumMapper.deleteAlbumByuid(map);
        return index;
    }

    @Override
    public int updateAlbumById(Album album) {
        int index = albumMapper.updateAlbumById(album);
        return index;
    }
}
