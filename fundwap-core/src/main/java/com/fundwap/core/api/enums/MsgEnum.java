package com.fundwap.core.api.enums;

public enum MsgEnum {
    SUCCESS(200, "操作成功"),

    ERROR(400, "操作失败"),

    AUTH_ERROR(401, "未经过身份认证"),

    NO_TOKEN(40101, "token参数不存在,无访问权限"),

    CHECK_TOKEN(40102, "token验证失败,无访问权限"),

    NO_SECRET_ID(40151, "accessKeyId参数不存在"),

    NO_SECRET_SIGN(40152, "sign签名参数不存在"),

    CHECK_SECRET(40153, "请求校验失败"),

    NOT_FOUND(404, "资源不存在"),

    SYSTEM_ERROR(500, "服务器异常,请稍后再试"),

    USERPRINCIPAL_RESOLVER_ERROR(50001, "用户信息解析异常,请稍后再试"),

    RPC_ERROR(503, "外部服务异常"),
    ;

    private final int code;
    private String msg;

    MsgEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static MsgEnum msgEnum(MsgEnum me,String msg){
        me.msg = msg;
        return me;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    /**
     * 简要字符串消息
     *
     * @param msg 自定义消息(一般是可直接供前端提示的信息)
     * @return JSON字符串
     */
    public String msg(String msg) {
        return this.toJson(msg);
    }

    /**
     * 带简要和详细消息的字符串消息
     *
     * @param msg       自定义消息(一般是可直接供前端提示的信息)
     * @param detailMsg 详细消息(供详细描述查看的消息)
     * @return JSON字符串
     */
    public String msg(String msg, String detailMsg) {
        return this.toJson(msg, detailMsg);
    }

    private static final String JSON_MSG = "{\"code\":%d,\"msg\":\"%s\",\"data\":\"%s\"}";

    @Override
    public String toString() {
        return String.format(JSON_MSG, this.getCode(), this.getMsg(), null);
    }


    public String toJson() {
        return String.format(JSON_MSG, this.getCode(), this.getMsg(), null);
    }

    private String toJson(String msg) {
        return String.format(JSON_MSG, this.getCode(), msg, null);
    }

    private String toJson(String msg, String detailMsg) {
        return String.format(JSON_MSG, this.getCode(), msg, detailMsg);
    }

}