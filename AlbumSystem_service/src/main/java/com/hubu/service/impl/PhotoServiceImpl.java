package com.hubu.service.impl;

import com.hubu.pojo.Album;
import com.hubu.pojo.Photo;
import com.hubu.service.PhotoService;
import com.hubu.mapper.PhotoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import  java.util.Map;
import java.util.List;

/**
 * 2 * @Author: 刘钦华
 * 3 * @Date: 2019/4/6 23:50
 * 3 * @Dscription
 */
@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoMapper photoMapper;



    /*根据相册的Id查找照片*/
    @Override
    public List<Photo> selectPhotoByAlbumId(int albumId){


      List<Photo> list=this.photoMapper.selectPhotoByAlbumId(albumId);
        //图片下次展示的是"http://localhost:9090/uploadimg/"+fileName
       for (int i=0;i<list.size();i++){
          list.get(i).setPath("uploadimg/"+list.get(i).getPath());
        }

        return list;
    }



    /*上传照片*/
   public void insertPhoto(int albumId,String headline,String discription,String fileName,String time,String Photo_Size)
   {
       /*接受photoController层的照片信息*/
       Photo photo=new Photo();
       photo.setPath(fileName);
       photo.setPhotoSize(Photo_Size);
       photo.setAlbumId(albumId);
       photo.setDiscription(discription);
       photo.setCreateTime(time);
       photo.setHeadline(headline);
       photo.setUpdateTime(photo.getCreateTime());//照片的updateTime开始和creatTime一样

       this.photoMapper.insertPhoto(photo);
   }


    /**
     * @author:LiMingGuang
     * 功能描述: 通过id将照片移到回收站
     *           将照片state置为1并更新updatetime为移入回收站时间
     * @param:
     * @return:
     * @date:2019/4/9
     */
    public void DeletePhotoById(Photo photo) {
        photoMapper.UpdatePhotoById(photo);
    }

    /**
     * @author:LiMingGuang
     * 功能描述: 查询该用户回收站内的所有未过期照片
     * @param:
     * @return:
     * @date:2019/4/9
     */
    public List<Photo> SelectAllRecyclePhoto(int uid) {
        //创建list对象获取该用户已删除过的照片（过期和未过期）
        List<Photo> noPastDue=this.photoMapper.SelectAllRecyclePhoto(uid);
        //创建list对象存储过期照片
        List<Photo> photoList = new ArrayList<Photo>();
        //设置日期格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Photo photo : noPastDue) {
            //获取当前毫秒数
            long currentTimeMillis = System.currentTimeMillis();
            //获取照片最后一次更新时间
            String updateTime = photo.getUpdateTime();
            //System.out.println(updateTime);
            try {
                //字符串格式时间转换毫秒数
                long time = simpleDateFormat.parse(updateTime).getTime();

                    //判断照片是否过期
                if ((currentTimeMillis - time) <(30 * 24 * 3600 * 1000L) ) {
                    //设置照片的存储路径
                    photo.setPath("/uploadimg/" + photo.getPath());
                    //将未过期照片对象存入photoList2中
                    photoList.add(photo);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return photoList;
    }


    /**
     * @author:LiMingGuang
     * 功能描述: 通过用户输入照片标题进行模糊查询
     * @param:
     * @return:
     * @date:2019/4/9
     */
    public List<Photo> SelectPhotoInfoByHeadline(Map<String, Object> map) {
        //获取模糊查询到的photo对象
        List<Photo> photoList = photoMapper.SelectPhotoInfoByHeadline(map);

        for (int i=0;i<photoList.size();i++){
            photoList.get(i).setPath("/uploadimg/"+photoList.get(i).getPath());
        }
        return photoList;
    }

    /*
    * 显示一张图片
    * */

    public Photo selectPhotoById(int id){

        Photo p= this.photoMapper.selectPhotoBy(id);
        p.setPath("/uploadimg/"+p.getPath());
        return p;
    }

    /**
     * @author:LiMingGuang
     * 功能描述: 通过id将照片移出回收站
     * @param:
     * @return:
     * @date:2019/4/9
     */
    public void RestoreRecyclePhotoById(Photo photo) {
        //将照片的state修改为0，并修改更新时间
        photoMapper.UpdateRecyclePhotoStateById(photo);
    }



}
