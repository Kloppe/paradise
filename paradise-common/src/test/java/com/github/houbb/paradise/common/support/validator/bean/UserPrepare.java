package com.github.houbb.paradise.common.support.validator.bean;

/**
 * 2017/12/3
 *
 * @author houbinbin
 * @version 1.0
 * @since 1.7
 */
public class UserPrepare {


    /**
     * 满足校验的数据
     * @return
     */
    public static User buildFitUser() {
        User user = new User();

        user.setName("ryo");
        user.setPassword("123456");
        user.setAge("23");
        user.setPhone("1111111");
        return user;
    }

}
