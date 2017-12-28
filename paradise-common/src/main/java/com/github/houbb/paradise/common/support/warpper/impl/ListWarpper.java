package com.github.houbb.paradise.common.support.warpper.impl;

import com.github.houbb.paradise.common.support.warpper.Warpper;

import java.util.LinkedList;
import java.util.List;

public class ListWarpper<T> implements Warpper {

    private List<T> list = new LinkedList<>();

    public void setList(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

}
