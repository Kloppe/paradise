package com.github.houbb.paradise.enhance.core.splitter.impl;

import com.github.houbb.paradise.common.util.CollectionUtil;
import com.github.houbb.paradise.enhance.core.splitter.Splitter;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * SplitterFactory Tester.
 *
 * @author houbinbin
 * @version 1.0
 * @since 08/16/2018
 */
public class SplitterFactoryTest {

    /**
     * Method: newSplitter(final String name)
     */
    @Test
    public void newSplitterTest() throws Exception {
        final String string = "VERSION";
        Splitter splitter = SplitterFactory.newSplitter(string);
        List<String> stringList = splitter.split();
        Assert.assertEquals("VERSION", stringList.get(0));
    }

    /**
     * Method: newSplitter(final String name)
     */
    @Test
    public void newSplitter2Test() throws Exception {
        final String string = "VERSION_SIDE";
        Splitter splitter = SplitterFactory.newSplitter(string);
        List<String> stringList = splitter.split();
        Assert.assertEquals("VERSION", stringList.get(0));
    }

    /**
     * Method: newSplitter(final String name)
     */
    @Test
    public void newSplitter3Test() throws Exception {
        final String string = "versionSide";
        Splitter splitter = SplitterFactory.newSplitter(string);
        List<String> stringList = splitter.split();
        Assert.assertEquals("version", stringList.get(0));
    }

    /**
     * Method: newSplitter(final String name)
     */
    @Test
    public void newSplitter4Test() throws Exception {
        final String string = null;
        Splitter splitter = SplitterFactory.newSplitter(string);
        List<String> stringList = splitter.split();
        Assert.assertTrue(CollectionUtil.isEmpty(stringList));
    }

}
