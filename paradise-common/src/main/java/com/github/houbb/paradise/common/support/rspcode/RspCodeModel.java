package com.github.houbb.paradise.common.support.rspcode;

import com.github.houbb.paradise.common.annotation.dev.API;

/**
 * 响应码实体
 *
 * @version 1.1.4
 * @since 1.1.4, 2018-06-24 09:19:28
 * @author bbhou
 */
@API(status = API.Status.MAINTAINED)
public class RspCodeModel {

    /**
     * 错误编码
     * 1. 对于所有的错误码都应该按照约定，便于区分，尽量按照大家都公认的方向进行设计。
     */
    private String code;

    /**
     * 错误消息
     * 1. 对于错误的描述，简明扼要。可以直接展现给客户看。
     */
    private String msg;

    /**
     * 备注信息
     * 1. 对于错误场景的详细描述。可也以不填写，按需可灵活修改。
     */
    private  String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
