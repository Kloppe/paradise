package com.github.houbb.paradise.common.support.validator.bean;

import com.github.houbb.paradise.common.support.validator.annotation.Valid;

/**
 * 2017/12/3
 *
 * @author houbinbin
 * @version 1.0
 * @since 1.7
 */
public class User {

    @Valid(notEmpty = true, errMsg = "姓名不可为空", matchRegex = "ryo*")
    private String name;

    @Valid(notNull = true, errMsg = "password 不可为null，且不得低于6位的英文或者数字", matchRegex = "[0-9,a-z,A-Z]{6,}")
    private String password;

    private String newPassword;

    @Valid(inRange = "[0,150]", isNumber = true, matchRegex = "[0-9]{1,}")
    private String age;


    @Valid(notNull = false, atLeastOne = {"name", "phone"}, errMsg = "email or phone at least one!")
    private String email;

    @Valid(restriction = {"1111111", "2222222"})
    private String phone;

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

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
