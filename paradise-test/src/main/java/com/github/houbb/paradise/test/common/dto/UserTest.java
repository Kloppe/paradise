package com.github.houbb.paradise.test.common.dto;

import org.junit.Test;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

public class UserTest {

    @Test
    public void toStringTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        System.out.println(buildUser());
    }

    private User buildUser() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        user.setName("asdfasdf");
        return user;
//        Class clazz = user.getClass();
//        Method method = clazz.getMethod("getName");
//        Class clazz2 = method.getReturnType();
//        System.out.println(clazz2.getName());
//        Object object = method.invoke(user);
//        return null;


    }

    public static void main(String[] args) {
        System.out.println(File.separator);
    }
}
