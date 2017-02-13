package com.ssm.boot;

/**
 * Created by Administrator on 2017/2/13.
 */
public class SystemUtil {
    public static boolean isAdmin(String userId) {
        return userId.toLowerCase() == "admin";
    }

    public static void main(String[] args) {
        System.out.println(isAdmin("Admin"));
        java.util.HashMap map = new java.util.HashMap();
        map.put("name", null);
        map.put("name", "Jack");
        System.out.println(map.size());

    }
}