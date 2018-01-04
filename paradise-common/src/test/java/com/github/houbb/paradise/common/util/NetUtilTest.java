package com.github.houbb.paradise.common.util;

import com.github.houbb.paradise.common.util.net.NetUtil;
import org.junit.Test;

public class NetUtilTest {

    /**
     * 测试是否可以连接谷歌翻译
     * @throws Exception
     */
    @Test
    public void isReachableTest() throws Exception {
        final String address = "translate.google.cn";
        System.out.println(NetUtil.isReachable(address));
    }

}
