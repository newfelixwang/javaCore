package com.wang.userapp.entity;

/**
 * 用户基本信息
 */
public class User {

    private Integer id;

    private String name;

    private String idCard;


    public User() {
    }

    public User(Integer id, String name, String idCard) {
        this.id = id;
        this.name = name;
        this.idCard = idCard;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
