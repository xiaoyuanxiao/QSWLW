package com.qs.qswlw.utils;

import com.qs.qswlw.MyApplication;

/**
 * Created by xiaoyu on 2017/12/19.
 */

public class RoleJudgeUtil {
    public static String roleJudeg(String role){
        if (role.equals("0")) {
            MyApplication.USERROLE = "消费者";
        }else if (role.equals("7")) {
            MyApplication.USERROLE = "董事局";
        } else if (role.equals("8")) {
            MyApplication.USERROLE = "创业董事";
        } else if (role.equals("9")) {
            MyApplication.USERROLE = "创业总监";
        }else if (role.equals("10")) {
            MyApplication.USERROLE = "商家";
        }else if(role.equals("11")){
            MyApplication.USERROLE = "创业主任";
        }else if(role.equals("12")){
            MyApplication.USERROLE = "省管理中心";
        }else if(role.equals("13")){
            MyApplication.USERROLE = "市管理中新";
        }else if(role.equals("14")){
            MyApplication.USERROLE = "区管理中心";
        }else if(role.equals("15")){
            MyApplication.USERROLE = "创业经理";
        }else if(role.equals("25")){
            MyApplication.USERROLE = "平台";
        }
        return MyApplication.USERROLE;
    }
}
