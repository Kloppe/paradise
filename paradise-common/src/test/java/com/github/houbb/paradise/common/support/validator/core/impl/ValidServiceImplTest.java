package com.github.houbb.paradise.common.support.validator.core.impl;

import com.github.houbb.paradise.common.support.validator.bean.User;
import com.github.houbb.paradise.common.support.validator.bean.UserPrepare;
import com.github.houbb.paradise.common.support.validator.exception.ValidException;
import org.junit.Assert;
import org.junit.Test;

/**
* ValidServiceImpl Tester.
*
* @author author
* @since 2017-12-03 11:08:55.807
* @version 1.0
*/
public class ValidServiceImplTest {

    /**
    *
    * Method: getInstance()
    */
    @Test
    public void getInstanceTest() throws Exception {
        ValidServiceImpl.getInstance();
    }


    @Test
    public void passTest() throws Exception {
        User user = UserPrepare.buildFitUser();
        ValidServiceImpl.getInstance().valid(user);
    }

    /**
     * Method: errMsg()
     */
    @Test
    public void errMsgTest() throws Exception {
        User user = UserPrepare.buildFitUser();
        user.setName(null);

        try {
            ValidServiceImpl.getInstance().valid(user);
        } catch (IllegalArgumentException e) {
            String errMsg = "<name>: 姓名不可为空";
            Assert.assertEquals(errMsg, e.getMessage());
        }
    }

    /**
     * Method: notNull()
     */
    @Test
    public void notNullTest() throws Exception {
        User user = UserPrepare.buildFitUser();
        user.setName(null);

        try {
            ValidServiceImpl.getInstance().valid(user);
        } catch (IllegalArgumentException e) {
            String errMsg = "<name>: 姓名不可为空";
            Assert.assertEquals(errMsg, e.getMessage());
        }
    }

    /**
     * Method: notEmpty()
     */
    @Test
    public void notEmptyTest() throws Exception {
        User user = UserPrepare.buildFitUser();
        user.setName("");

        try {
            ValidServiceImpl.getInstance().valid(user);
        } catch (IllegalArgumentException e) {
            String errMsg = "<name>: 姓名不可为空";
            Assert.assertEquals(errMsg, e.getMessage());
        }
    }

    /**
     * Method: isNumber()
     */
    @Test
    public void isNumberTest() throws Exception {
        User user = UserPrepare.buildFitUser();
        user.setAge("one");

        try {
            ValidServiceImpl.getInstance().valid(user);
        } catch (IllegalArgumentException e) {
            String errMsg = "<age>: 参数校验不合法";
            Assert.assertEquals(errMsg, e.getMessage());
        }
    }

    /**
     * Method: matchRegex()
     */
    @Test
    public void matchRegexTest() throws Exception {
        User user = UserPrepare.buildFitUser();
        user.setPassword("dddd_");

        try {
            ValidServiceImpl.getInstance().valid(user);
        } catch (IllegalArgumentException e) {
            String errMsg = "<password>: password 不可为null，且不得低于6位的英文或者数字";
            Assert.assertEquals(errMsg, e.getMessage());
        }
    }

    /**
     * Method: inRange()
     */
    @Test
    public void inRangeTest() throws Exception {
        User user = UserPrepare.buildFitUser();
        user.setAge("190");

        try {
            ValidServiceImpl.getInstance().valid(user);
        } catch (IllegalArgumentException e) {
            String errMsg = "<age>: 参数校验不合法";
            Assert.assertEquals(errMsg, e.getMessage());
        }
    }

    /**
     * Method: atLeastOne()
     */
    @Test
    public void atLeastOneTest() throws Exception {
        User user = UserPrepare.buildFitUser();
        user.setPhone("");

        try {
            ValidServiceImpl.getInstance().valid(user);
        } catch (ValidException e) {
            String errMsg = "<phone>: 参数校验不合法";
            Assert.assertEquals(errMsg, e.getMessage());
        }
    }

    /**
     * Method: restriction()
     */
    @Test
    public void restrictionTest() throws Exception {
        User user = UserPrepare.buildFitUser();
        user.setPhone("1234567");

        try {
            ValidServiceImpl.getInstance().valid(user);
        } catch (ValidException e) {
            String errMsg = "<phone>: 参数校验不合法";
            Assert.assertEquals(errMsg, e.getMessage());
        }
    }

}
