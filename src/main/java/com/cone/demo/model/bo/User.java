package com.cone.demo.model.bo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by pactera on 2017/2/7.
 */
@Table(name="t_user")
public class User implements Serializable{
    private static final long serialVersionUID = 88092212720973267L;

    @Id
    private Integer id;
    @Column(name="username")
    private String userName;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
