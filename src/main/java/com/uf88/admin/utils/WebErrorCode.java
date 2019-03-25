package com.uf88.admin.utils;

public interface WebErrorCode {
    //没有找到对应的结算账户
    public static final String NO_SETTLE_ACCOUNT="web.000001";
    
    //用户已经存在
    public static final String USERNAME_EXSIT="web.regist.000001";

    //手机号已经存在
    public static final String PHONE_EXSIT="web.regist.000002";
    
    //文件太大
    public static final String FILE_TO_BIG="web.file.000001";
}
