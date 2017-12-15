package com.qs.qswlw.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by xiaoyu on 2017/12/15.
 */

public class SettingNewsBean {
    /**
     * customerservice : https://pbt.zoosnet.net/LR/Chatpre.aspx?id=PBT54011804&cid=1512619227136573083977&lng=cn&sid=1513301667642332488417&p=http%3A//www.qiansheng.com/index.php%3Fm%3DBusiness%26c%3DMessage%26a%3Dindex&rf1=&rf2=&msg=&skid=4&sk=%u610f%u89c1%u548c%u6295%u8bc9&e=%u610f%u89c1%u548c%u6295%u8bc9&d=1513309626766#_LR1_
     * message : [{"admin_id":"1","message":"恭喜您，您申请的商家入驻审核已经通过，快到http://www.qiansheng.com，管理您的店铺吧","message_id":"19400","send_time":"1506743596","type":"1"},{"admin_id":"1","message":"恭喜您，您申请的商家入驻审核已经通过，快到http://www.qiansheng.com，管理您的店铺吧","message_id":"19395","send_time":"1506663390","type":"1"},{"admin_id":"1","message":"恭喜您，您申请的商家入驻审核已经通过，快到http://www.qiansheng.com，管理您的店铺吧","message_id":"19373","send_time":"1506299868","type":"1"},{"admin_id":"1","message":"恭喜您，您申请的商家入驻审核已经通过，快到http://www.qiansheng.com，管理您的店铺吧","message_id":"19342","send_time":"1505954248","type":"1"},{"admin_id":"1","message":"恭喜您，您申请的商家入驻审核已经通过，快到http://www.qiansheng.com，管理您的店铺吧","message_id":"19333","send_time":"1505895869","type":"1"},{"admin_id":"1","message":"恭喜您，您申请的商家入驻审核已经通过，快到http://www.qiansheng.com，管理您的店铺吧","message_id":"19190","send_time":"1505262956","type":"1"},{"admin_id":"1","message":"恭喜您，您申请的商家入驻审核已经通过，快到http://www.qiansheng.com，管理您的店铺吧","message_id":"19179","send_time":"1505209331","type":"1"},{"admin_id":"1","message":"恭喜您，您申请的商家入驻审核已经通过，快到http://www.qiansheng.com，管理您的店铺吧","message_id":"16827","send_time":"1502949069","type":"1"},{"admin_id":"1","message":"恭喜您，您申请的商家入驻审核已经通过，快到http://www.qiansheng.com，管理您的店铺吧","message_id":"13032","send_time":"1497832685","type":"1"},{"admin_id":"1","message":"恭喜您，您申请的商家入驻审核已经通过，快到http://www.qiansheng.com，管理您的店铺吧","message_id":"6449","send_time":"1494344975","type":"1"},{"admin_id":"1","message":"恭喜您，您申请的商家入驻审核已经通过，快到http://www.qiansheng.com，管理您的店铺吧","message_id":"6422","send_time":"1494344744","type":"1"}]
     */

    private String customerservice;
    private List<MessageBean> message;

    public String getCustomerservice() {
        return customerservice;
    }

    public void setCustomerservice(String customerservice) {
        this.customerservice = customerservice;
    }

    public List<MessageBean> getMessage() {
        return message;
    }

    public void setMessage(List<MessageBean> message) {
        this.message = message;
    }

    public static class MessageBean implements Parcelable {
        public static final Parcelable.Creator<MessageBean> CREATOR = new Parcelable.Creator<MessageBean>() {
            @Override
            public MessageBean createFromParcel(Parcel source) {
                return new MessageBean(source);
            }

            @Override
            public MessageBean[] newArray(int size) {
                return new MessageBean[size];
            }
        };
        /**
         * admin_id : 1
         * message : 恭喜您，您申请的商家入驻审核已经通过，快到http://www.qiansheng.com，管理您的店铺吧
         * message_id : 19400
         * send_time : 1506743596
         * type : 1
         */

        private String admin_id;
        private String message;
        private String message_id;
        private String send_time;
        private String type;

        public MessageBean() {
        }

        protected MessageBean(Parcel in) {
            this.admin_id = in.readString();
            this.message = in.readString();
            this.message_id = in.readString();
            this.send_time = in.readString();
            this.type = in.readString();
        }

        public String getAdmin_id() {
            return admin_id;
        }

        public void setAdmin_id(String admin_id) {
            this.admin_id = admin_id;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getMessage_id() {
            return message_id;
        }

        public void setMessage_id(String message_id) {
            this.message_id = message_id;
        }

        public String getSend_time() {
            return send_time;
        }

        public void setSend_time(String send_time) {
            this.send_time = send_time;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.admin_id);
            dest.writeString(this.message);
            dest.writeString(this.message_id);
            dest.writeString(this.send_time);
            dest.writeString(this.type);
        }
    }
}
