package com.ryo.paradise.response.code.core;

/**
 * 响应码接口定义
 * Created by bbhou on 2017/9/30.
 * @since 1.0.0
 * @version 1.0.0
 * @author bbhou
 */
public interface RspCode {

    /**
     * 错误编码
     * 1. 对于所有的错误码都应该按照约定，便于区分，尽量按照大家都公认的方向进行设计。
     * @return
     */
    String getCode();

    /**
     * 错误消息
     * 1. 对于错误的描述，简明扼要。可以直接展现给客户看。
     * @return
     */
    String getMsg();

    /**
     * 备注信息
     * 1. 对于错误场景的详细描述。可也以不填写，按需可灵活修改。
     * @return
     */
    String getRemark() ;

}
