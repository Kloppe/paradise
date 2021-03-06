package com.github.houbb.paradise.common.support.rspcode;

import com.github.houbb.paradise.common.annotation.dev.API;

/**
 * 响应码接口定义
 *
 * @version 1.1.1
 * @author bbhou
 */
@API(status = API.Status.MAINTAINED)
public interface RspCode {

    /**
     * 错误编码
     * 1. 对于所有的错误码都应该按照约定，便于区分，尽量按照大家都公认的方向进行设计。
     * @return 错误编码
     */
    String getCode();

    /**
     * 错误消息
     * 1. 对于错误的描述，简明扼要。可以直接展现给客户看。
     * @return 错误消息
     */
    String getMsg();

    /**
     * 备注信息
     * 1. 对于错误场景的详细描述。可也以不填写，按需可灵活修改。
     * @return 备注信息
     */
    String getRemark() ;

}
