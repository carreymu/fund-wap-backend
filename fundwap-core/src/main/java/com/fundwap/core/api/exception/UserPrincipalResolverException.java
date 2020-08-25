package com.fundwap.core.api.exception;

import com.fundwap.core.api.enums.MsgEnum;

public class UserPrincipalResolverException extends RuntimeException {

    private static final long serialVersionUID = -3476892562211755163L;

    public UserPrincipalResolverException() {
        super(MsgEnum.USERPRINCIPAL_RESOLVER_ERROR.toString());
    }

    public UserPrincipalResolverException(String message) {
        super(MsgEnum.USERPRINCIPAL_RESOLVER_ERROR.msg(message));
    }
}
