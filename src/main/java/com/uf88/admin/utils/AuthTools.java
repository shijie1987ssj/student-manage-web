package com.uf88.admin.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.uf88.uf88core.util.DateUtils;
import com.uf88.uf88core.util.StrUtil; 

public class AuthTools {
    public static final String SESSION_NAME_USER = "loginUser";

    public static final String SESSION_NAME_AUTH = "authUser";
   
    public static void removeLoginUser(HttpServletRequest request) {
        deleteObjFromSession(request.getSession(), SESSION_NAME_USER);
    }

    public static Auth getAuth(HttpServletRequest request) {
        return getAuth(request.getSession());
    }

    public static Auth getAuth(HttpSession session) {
        Auth auth = (Auth) getObjFromSession(session, SESSION_NAME_AUTH);

        return auth;
    }

    public static void saveAuthToSession(HttpSession session, Auth auth) {
        setObjFromSession(session, SESSION_NAME_AUTH, auth);
    }

    public static void saveAuthToSession(HttpServletRequest request, Auth auth) {
        saveAuthToSession(request.getSession(), auth);
    }

    public static void removeAuth(HttpServletRequest request) {
        deleteObjFromSession(request.getSession(), SESSION_NAME_AUTH);
    }

    private static Object getObjFromSession(HttpSession session, String key) {
        return session.getAttribute(key);
    }

    private static void setObjFromSession(HttpSession session, String key, Object value) {
        session.setAttribute(key, value);
    }

    private static void deleteObjFromSession(HttpSession session, String key) {
        session.removeAttribute(key);
    }

}
