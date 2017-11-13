package com.github.houbb.paradise.test.common.dto;

import com.github.houbb.paradise.common.dto.CommonDto;

import java.util.List;
import java.util.Map;

public class User extends CommonDto {

    private String name;
    private int age;
    private String hobby;

    private String[] arrays;

    private List<String> stringList;

    private Map<String, String> map;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String[] getArrays() {
        return arrays;
    }

    public void setArrays(String[] arrays) {
        this.arrays = arrays;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
