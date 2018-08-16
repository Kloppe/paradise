package com.github.houbb.paradise.common.util;

import org.junit.Assert;
import org.junit.Test;

/**
* StringUtil Tester.
*
* @author author
* @since 2017-12-03 11:08:55.825
* @version 1.0
*/
public class StringUtilTest {

    @Test
    public void isUppperCaseTest() {
        Assert.assertFalse(StringUtil.isUppperCase(""));
        Assert.assertTrue(StringUtil.isUppperCase("XXX"));
        Assert.assertFalse(StringUtil.isUppperCase("XxX"));
    }

    @Test
    public void isLowerCaseTest() {
        Assert.assertFalse(StringUtil.isLowerCase(""));
        Assert.assertTrue(StringUtil.isLowerCase("xxx"));
        Assert.assertFalse(StringUtil.isLowerCase("xxX"));
    }

    @Test
    public void containsUppperCaseTest() {
        Assert.assertFalse(StringUtil.containsUppercase(""));
        Assert.assertTrue(StringUtil.containsUppercase("Xxx"));
        Assert.assertTrue(StringUtil.containsUppercase("X00asdf_"));
    }

    @Test
    public void containsLowerCaseTest() {
        Assert.assertFalse(StringUtil.containsLowercase(""));
        Assert.assertFalse(StringUtil.containsLowercase("XXXX009090_"));
        Assert.assertTrue(StringUtil.containsLowercase("Xxx"));
        Assert.assertTrue(StringUtil.containsLowercase("x____00099"));
    }

    /**
    *
    * Method: isEmpty(string)
    */
    @Test
    public void isEmptyTest() throws Exception {
    }

    /**
    *
    * Method: isNotEmpty(string)
    */
    @Test
    public void isNotEmptyTest() throws Exception {
    }

    /**
    *
    * Method: isBlank(str)
    */
    @Test
    public void isBlankTest() throws Exception {
    }

    /**
    *
    * Method: isNotBlank(str)
    */
    @Test
    public void isNotBlankTest() throws Exception {
    }

    /**
    *
    * Method: trimList(stringList)
    */
    @Test
    public void trimListTest() throws Exception {
    }

    /**
    *
    * Method: splitByAnyBlank(string)
    */
    @Test
    public void splitByAnyBlankTest() throws Exception {
    }

    /**
    *
    * Method: getCamelCaseString(inputString, firstCharacterUppercase)
    */
    @Test
    public void getCamelCaseStringTest() throws Exception {
    }

    /**
    *
    * Method: firstToLowerCase(str)
    */
    @Test
    public void firstToLowerCaseTest() throws Exception {
    }

    /**
    *
    * Method: firstToUpperCase(str)
    */
    @Test
    public void firstToUpperCaseTest() throws Exception {
    }

    /**
    *
    * Method: defaultEmpty(string)
    */
    @Test
    public void defaultEmptyTest() throws Exception {
    }

    /**
    *
    * Method: join(array, separator, startIndex, endIndex)
    */
    @Test
    public void joinTest() throws Exception {
    }

    /**
    *
    * Method: camelToUnderline(camelStr)
    */
    @Test
    public void camelToUnderlineTest() throws Exception {
    }

    /**
    *
    * Method: underlineToCamel(underlineStr)
    */
    @Test
    public void underlineToCamelTest() throws Exception {
    }


}
