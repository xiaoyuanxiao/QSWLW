package com.qs.qswlw.bean;

/**
 * Created by xiaoyu on 2017/8/28.
 */

public class RegisterGetCodeBean {

    /**
     * message : ok
     * remainpoint : 12064
     * returnstatus : Success
     * successCounts : 1
     * taskID : 1711757
     */

    private String message;
    private String remainpoint;
    private String returnstatus;
    private String successCounts;
    private String taskID;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRemainpoint() {
        return remainpoint;
    }

    public void setRemainpoint(String remainpoint) {
        this.remainpoint = remainpoint;
    }

    public String getReturnstatus() {
        return returnstatus;
    }

    public void setReturnstatus(String returnstatus) {
        this.returnstatus = returnstatus;
    }

    public String getSuccessCounts() {
        return successCounts;
    }

    public void setSuccessCounts(String successCounts) {
        this.successCounts = successCounts;
    }

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }
}
