package com.qs.qswlw.bean;

/**
 * Created by xiaoyu on 2017/9/7.
 */

public class EntrepreneurialDialogBean {
    /**
     * user_id : 187
     * use_silver : 100000
     * bean : 200
     * model : model1
     * role : 10
     * add_time : 2017-09-01 18:12:32
     */

    private String user_id;
    private int use_silver;
    private int bean;
    private String model;
    private String role;
    private String add_time;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getUse_silver() {
        return use_silver;
    }

    public void setUse_silver(int use_silver) {
        this.use_silver = use_silver;
    }

    public int getBean() {
        return bean;
    }

    public void setBean(int bean) {
        this.bean = bean;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }
}
