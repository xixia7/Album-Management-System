package com.hubu.controller;
import com.hubu.pojo.Msg;
import com.hubu.pojo.Photo;
import com.hubu.pojo.Photo;
import com.hubu.pojo.Users;
import com.hubu.service.PhotoService;
import com.hubu.service.impl.PhotoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 2 * @Author: 刘钦华
 * 3 * @Date: 2019/4/7 0:06
 * 3 * @Dscription
 */
@Controller
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    /**
     * ajax post方式传参,通过@RequestParam接收
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/selectAllPhoto/{id}")
     public Msg selectAllPhoto(@PathVariable("id")Integer id){

        //根据相册Id查找所有的照片
       List<Photo> allPhoto =photoService.selectPhotoByAlbumId(id);

            //把查找结果的所有的照片，数量，加入到返回结果类Msg里面
        return Msg.success().add("Allphotos",allPhoto).add("size",allPhoto.size());
    }





    @ResponseBody
    @RequestMapping("/photoUpload")
    public Msg  photoUpload(@RequestParam(value = "file")MultipartFile file,
                               @RequestParam(value = "albumId") int albumId,
                               @RequestParam(value = "photoName")String headline,
                               @RequestParam(value = "photoExplain")String discription,
                               HttpServletRequest request)throws IOException {


        //指定上传的目录
        HttpSession session=request.getSession();
        String  filepath=session.getServletContext().getRealPath("/uploadimg");
        File path=new File(filepath);
                  if (!path.exists()){//检查上传路径是否存在
                    path.mkdir();//路径不存在就创建一个路径
                        }


        //获取源文件的名字
        String fileName=file.getOriginalFilename();


        //为了保证上传文件名字的唯一性
        String uuid= UUID.randomUUID().toString().replace("-","");
         fileName=uuid+"_"+fileName;


            //保存文件
        File savePhoto=new File(path,fileName);
        file.transferTo(savePhoto);

        //计算上传文件的大小
        String    Photo_Size=String.valueOf(savePhoto.length()/1024)+"K";

       //获取当前的上传时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time=(String)  df.format(new Date());//);// new Date()为获取当前系统时间

        //插入数据库
        photoService.insertPhoto(albumId,headline,discription,fileName,time,Photo_Size);


        return Msg.success();//上传成功返回一个空json字符串
    }




    /**
     * @author:LiMingGuang
     * 功能描述: 获取照片id,删除照片将照片移入回收站
     * @param:
     * @return:
     * @date:2019/4/9
     */
    @RequestMapping("/deletePhotoById")
    @ResponseBody
    public Msg deletePhotoById(HttpServletRequest request,@RequestParam(value = "id")int id)
    {
        //创建Photo对象
        Photo photo = new Photo();
        //设置新建photo对象id
        photo.setId(id);
        //当前修改照片的时间

        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取当前系统时间
        String currentTime = df.format(new Date());
        //设置新建photo对象updateTime
        photo.setUpdateTime(currentTime);
        //通过传入新创建的photo对象将照片移入回收站
        photoService.DeletePhotoById(photo);
        //返回json字符串
        return Msg.success();
    }


    /**
     * @author:LiMingGuang
     * 功能描述: 查询回收站内未过期的照片
     * @param:
     * @return:
     * @date:2019/4/9
     */
    @ResponseBody
    @RequestMapping("/queryRecyclePhoto")
    public  Msg ShowRecyclePhoto(HttpServletRequest request)
    {
        //获取session对象
        HttpSession session=request.getSession();
        //根据session对象获取users对象
        Users users=(Users) session.getAttribute("user");

        //创建List对象获取回收站中所有照片
        List<Photo> recycleList=photoService.SelectAllRecyclePhoto(users.getUserId());
       //返回json字符串
        return Msg.success().add("allPhoto",recycleList).add("size",recycleList.size());
    }



    /**
     * @author:LiMingGuang
     * 功能描述: 根据照片名字模糊查询
     * @param:
     * @return:
     * @date:2019/4/9
     */
    @ResponseBody
    @RequestMapping("/queryPhotoByHeadline/{headline}")
    public Msg queryPhotoByHeadline(Model model, @PathVariable("headline") String headline, HttpServletRequest request) throws UnsupportedEncodingException {

        String headline2 = new String(headline.getBytes("iso8859-1"),"UTF-8");
        //获取session对象
        HttpSession httpSession = request.getSession();
        //根据session对象获取user对象
        Users users = (Users) httpSession.getAttribute("user");
        //根据user对象获取id
        int uid = users.getUserId();
        //创建Map
        Map<String,Object> map = new HashMap<String, Object>();
        headline = "%"+headline2+"%";
        //将id和headline使用map存储
        map.put("headline",headline);
        map.put("uid",uid);
        //用photoList接收查询结果
        List<Photo> photoList = photoService.SelectPhotoInfoByHeadline(map);
        //返回json串
        return Msg.success().add("photoList",photoList).add("size",photoList.size());
    }

        /**
         * 功能描述:
         * @param: 根据照片Id展示图片
         * @return:
         * @author:LiMingGuang
         * @date: ${DATE}
         */

        @ResponseBody
        @RequestMapping("/selectPhotoById")
    public Msg showPhotoById(@RequestParam(value = "id")int id)
        {
            //获取photo对象
        Photo photo=photoService.selectPhotoById(id);
            //返回json串
        return Msg.success().add("photo",photo);

        }




    /**
     * @author:LiMingGuang
     * 功能描述: 恢复回收站的照片
     * @param:
     * @return:
     * @date:2019/4/9
     */
    @ResponseBody
    @RequestMapping("/restoreRecyclePhoto")
    public Msg RestoreRecyclePhoto(HttpServletRequest request,@RequestParam(value = "id")int id)
    {
        //创建Photo对象
        Photo photo = new Photo();
        //获取当前时间
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取系统当前时间
        String currentTime = df.format(new Date());
        //设置id
        photo.setId(id);
        //设置updateTime
        photo.setUpdateTime(currentTime);
        //从回收站恢复照片
        photoService.RestoreRecyclePhotoById(photo);
        //返回json串
        return Msg.success();
    }





}
