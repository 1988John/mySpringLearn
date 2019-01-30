package com.foo.test.base;


import java.util.Arrays;

public enum FeedbackOrderTransferTarget  {

    LIVE_STREAM_COMMON(1, "直播", "livestream"),

    PHOTO_COMMON(2, "视频", "photo"),
    PHOTO_AUDIT(4, "视频-审核", "photoAudit"),
    PHOTO_OPERATE(5, "视频-运营", "photoOperate"),

    USER_COMMON(3, "用户", "user"),

    MOMENT_COMMON(6, "说说", "moment"),

    COMMERCE_ANTISPAM_COMMON(7, "商业风控", "commerceAntispam"),

    INTOWN_COMMON(8, "同乡", "intown"),

    UNKNOWN(0, "未知", "unknown");

    private int value;
    private String desc;
    private String alias;

    public static FeedbackOrderTransferTarget getTargetByAlias(String alias){
        return Arrays.stream(FeedbackOrderTransferTarget.values())
                .filter(value -> value.getAlias().equals(alias))
                .findAny()
                .orElse(null);

    }


    FeedbackOrderTransferTarget(int value, String desc, String alias) {
        this.value = value;
        this.desc = desc;
        this.alias = alias;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public String getAlias() {
        return alias;
    }
}
