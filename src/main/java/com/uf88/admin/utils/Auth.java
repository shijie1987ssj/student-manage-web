package com.uf88.admin.utils;

public class Auth {
    private String userId;
    private String userName;
    private String phone;
    private String usertype;
    private String userRoles;
    // private String companyType;
    // private String companyLinkName;
    private String realName;
    // private String regType;
    // private String userStatus;
    // private String type;
    // private String bankNo;
    // private String bankName;
    // private String bankType;
    // private String hzSponsorNo;
    private String ip;

    // private String certiCard;
    // private String bankCode;
    // private String spare4;
    // private String spare6;
    // private String spare2;
    // private int passwdChangeCount;
    // private String styleCode;
    // private String serNo;
    // private String payPassStatus;
    // private String spare10;

    /**
     * 证书ID
     */
    private String credentialsId;

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsertype() {
        return this.usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getRealName() {
        return this.realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        String s = "userId=" + this.userId + ", userName=" + this.userName + ", userPhone=" + this.phone
                + ", usertype=" + this.usertype + ", realName=" + this.realName;

        return s;
    }

    /**
     * aaAdmin,bbbRole 逗号隔开
     * 
     * @return
     */
    public String getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(String userRoles) {
        this.userRoles = userRoles;
    }

    public String getCredentialsId() {
        return credentialsId;
    }

    public void setCredentialsId(String credentialsId) {
        this.credentialsId = credentialsId;
    }

}
