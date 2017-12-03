package com.github.houbb.paradise.common.support.validator.annotation;

import org.junit.Assert;
import org.junit.Test;

/**
 * Valid Tester.
 *
 * @author author
 * @version 1.0
 * @since 2017-12-03 11:08:55.818
 */
public class ValidTest {

    private static final String ERROR_MSG = "当前字段校验失败！！！";

    /**
     * 只用来测试注解本身的信息
     * 1. 不对校验是否正确进行测试。
     */
    @Valid(errMsg = ERROR_MSG,
            notNull = true,
            notEmpty = true,
            isNumber = true,
            matchRegex = "",
            inRange = "(10, 20)",
            atLeastOne = {"info", "name", "age"},
            restriction = {"10", "11", "12"}
    )
    private String info;

    /**
     * Method: errMsg()
     */
    @Test
    public void errMsgTest() throws Exception {
        Assert.assertEquals(ERROR_MSG, getValid().errMsg());
    }

    /**
     * Method: notNull()
     */
    @Test
    public void notNullTest() throws Exception {
        Assert.assertEquals(true, getValid().notNull());
    }

    /**
     * Method: notEmpty()
     */
    @Test
    public void notEmptyTest() throws Exception {
        Assert.assertEquals(true, getValid().notEmpty());
    }

    /**
     * Method: isNumber()
     */
    @Test
    public void isNumberTest() throws Exception {
        Assert.assertEquals(true, getValid().isNumber());
    }

    /**
     * Method: matchRegex()
     */
    @Test
    public void matchRegexTest() throws Exception {
        Assert.assertEquals("", getValid().matchRegex());
    }

    /**
     * Method: inRange()
     */
    @Test
    public void inRangeTest() throws Exception {
        Assert.assertEquals("(10, 20)", getValid().inRange());
    }

    /**
     * Method: atLeastOne()
     */
    @Test
    public void atLeastOneTest() throws Exception {
        Assert.assertEquals(3, getValid().atLeastOne().length);
    }

    /**
     * Method: restriction()
     */
    @Test
    public void restrictionTest() throws Exception {
        Assert.assertEquals(3, getValid().restriction().length);
    }


    private Valid getValid() {
        try {
            Valid valid = ValidTest.class.getDeclaredField("info").getAnnotation(Valid.class);
            return valid;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }


}
