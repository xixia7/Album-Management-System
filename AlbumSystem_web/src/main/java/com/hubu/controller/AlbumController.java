package com.hubu.controller;

import com.hubu.pojo.Album;
import com.hubu.pojo.Msg;
import com.hubu.pojo.Users;
import com.hubu.service.AlbumService;
import com.hubu.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: ；吕庆龙
 * @Date: 2019/4/4
 * @Description: 相册管理控制器，控制不同用户的操作:
 *               1.显示所有相册，2.创建相册 3.删除相册
 * @version: 1.0
 */

@Controller
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    /**
     * 功能描述: 进入用户个人界面之后，显示此用户所有相册
     * @param:
     * @return:
     * @author: 吕庆龙
     * @date: 2019/4/4
     */
    @ResponseBody
    @RequestMapping("/showAllAlbum")
    public Msg getAllAlbumByuid(HttpServletRequest request){
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        List<Album> list = albumService.getAllAlbumByuid(user);
        //新用户如果没有相册，只需要在前端提示即可，这里不需要判断list是否为空
        return Msg.success().add("selAllAlbum",list).add("albumSize",list.size());
    }


    /**
     * 功能描述: 根据Album的用户uid创建不同用户的相册
     * @param:
     * @return:
     * @author: 吕庆龙
     * @date: 2019/4/4
     */
    @ResponseBody
    @RequestMapping("/createAlbum")
    public Msg createAlbumByuid(HttpServletRequest request,Album album){
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("userCreate",user);
        map.put("albumCreate",album);
        int index = albumService.createAlbumByuid(map);

        if(index > 0){
            System.out.println("成功创建相册");
        }else {
            System.out.println("创建相册失败");
        }
        return Msg.success();
    }

    /**
     * 功能描述: 根据Album的用户uid创建不同用户的相册
     * @param:
     * @return:
     * @author: 吕庆龙
     * @date: 2019/4/4
     */
    @ResponseBody
    @RequestMapping("/deleteAlbumByExample")
    public Msg deleteAlbumByuid(HttpServletRequest request,Album album){
        System.out.println(album.getId());
        HttpSession session = request.getSession();

        //“user”这个参数，都是从UsersController传过来的
        Users user = (Users) session.getAttribute("user");
        Map<String,Object> map = new HashMap<String,Object>();

        //为了避免Attribute名字一样，导致覆盖，出现其它问题。所以起不同的名字
        map.put("userDelete",user);
        map.put("albumDelete",album);
        int index = albumService.deleteAlbumByuid(map);
        System.out.println("删除操作:" + index);
        if(index > 0){
            System.out.println("删除相册成功");
        }else {
            System.out.println("删除相册失败");
        }
        return Msg.success();
    }




    /**
     * 功能描述: 编辑相册信息
     * @param:
     * @return:
     * @author: 吕庆龙
     * @date: 2019/4/10
     */
    @ResponseBody
    @RequestMapping("/editAlbumInform")
    public Msg updateAlbum(Album album,HttpServletRequest request){
        System.out.println(album);
        int index = albumService.updateAlbumById(album);
        if(index > 0){
            System.out.println("相册信息更新成功!");
            return Msg.success();
        }else{
            System.out.println("相册信息更新失败！");
            return Msg.fail();
        }

    }
}
