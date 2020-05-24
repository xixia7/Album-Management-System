package com.hubu.pojo;

/**
 * 2 * @Author: 刘钦华
 * 3 * @Date: 2019/4/6 23:07
 * 3 * @Dscription
 */
public class Photo {
    private int id;//照片Id
    private String headline;//
    private String path;//照片的文件路径
    private String createTime;//照片上传时间
    private String photoSize;//照片大小
    private String discription;//照片描述
    private int albumId;//照片对应的相册id
    private String updateTime;//照片最近的删改时间
    private int state=0;//照片状态（是否删除，0-已删，1-未删）



    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", headline='" + headline + '\'' +
                ", path='" + path + '\'' +
                ", createTime='" + createTime + '\'' +
                ", photoSize='" + photoSize + '\'' +
                ", discription='" + discription + '\'' +
                ", albumId=" + albumId +
                ", updateTime='" + updateTime + '\'' +
                ", state=" + state +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPhotoSize() {
        return photoSize;
    }

    public void setPhotoSize(String photoSize) {
        this.photoSize = photoSize;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}