package com.hubu.pojo;

/**
 * @Author: ；吕庆龙
 * @Date: 2019/4/4
 * @Description: com.hubu.pojo   用户照片
 * @version: 1.0
 */
public class Album {

    private int id;   //必备的ID
    private String name;  //相册名字
    private String createTime; //相册创建时间
    private String updateTime; //相册更新时间
    private String discription; //相关描述
    private int uid; //每个相册都对应用户的userId

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", discription='" + discription + '\'' +
                ", uid=" + uid +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
