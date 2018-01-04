package com.github.houbb.paradise.common.util.net;

import java.net.InetAddress;

/**
 * 网络工具类
 *
 * @author bbhou
 * @version 1.1.2
 * @since 1.1.2, 2018/01/04
 */
public class NetUtil {

    /**
     * 传入需要连接的IP，返回是否连接成功
     *
     * @param remoteInetAddress 远程地址
     * @return {@code true} 是
     */
    public static boolean isReachable(String remoteInetAddress) {
        return isReachable(remoteInetAddress, 5000);
    }

    /**
     * 传入需要连接的IP，返回是否连接成功
     * @param remoteInetAddress 远程地址
     * @param timeoutInMills   超时时间(milliseconds)
     * @return {@code true} 是
     */
    public static boolean isReachable(String remoteInetAddress, int timeoutInMills) {
        boolean reachable = false;
        try {
            InetAddress address = InetAddress.getByName(remoteInetAddress);
            reachable = address.isReachable(timeoutInMills);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reachable;
    }

}
