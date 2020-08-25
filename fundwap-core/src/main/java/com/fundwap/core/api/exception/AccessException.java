package com.fundwap.core.api.exception;


import com.fundwap.core.api.enums.MsgEnum;

/**
 * @description 
 * @date 8/4/20 9:10 AM
 * @author by carrey.mu
 * 
 * @param null
 * @return 
 */
public class AccessException  extends RuntimeException {
    private static final long serialVersionUID = 891168742033342843L;

    /**
     * {"code":401,"msg":"未经过身份认证"}
     */
    public AccessException() {
        super(MsgEnum.AUTH_ERROR.toString());
    }

    /**
     * {"code":401,"msg":"${message}"}
     *
     * @param message
     */
    public AccessException(String message) {
        super(MsgEnum.AUTH_ERROR.msg(message));
    }

    /**
     * HTTP状态码为401的业务异常类，如果需要自定义返回的code和msg，那肯定是通过MsgEnum枚举来定义操作的
     * <p>
     * {"code":${ienum.code},"msg":"${ienum.msg}"}
     *
     * @param ienum
     */
    public AccessException(MsgEnum ienum) {
        super(ienum.toString());
    }
}
