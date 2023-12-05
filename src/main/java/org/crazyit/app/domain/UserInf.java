package org.crazyit.app.domain;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;

public class UserInf {
    @Id
    private Integer userId;
    private String name;
    // 指定password属性使用setter,getter方法访问，
    // 其他属性直接通过Field访问
    @AccessType(AccessType.Type.PROPERTY)
    private String password;
    private int age;

    public UserInf() {
    }

    public UserInf(String name, String password, int age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserInf{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
