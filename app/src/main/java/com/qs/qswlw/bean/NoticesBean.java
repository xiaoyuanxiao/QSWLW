package com.qs.qswlw.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by xiaoyu on 2017/12/12.
 */

public class NoticesBean implements Parcelable {

    public static final Parcelable.Creator<NoticesBean> CREATOR = new Parcelable.Creator<NoticesBean>() {
        @Override
        public NoticesBean createFromParcel(Parcel source) {
            return new NoticesBean(source);
        }

        @Override
        public NoticesBean[] newArray(int size) {
            return new NoticesBean[size];
        }
    };
    /**
     * id : 22
     * index_title : 公告
     * index_name : 广州市四申九物联网有限公司
     * index_faburen : 市场部
     * index_time : 2017年11月28日
     * index_content : 尊敬的各位会员：
     * 公司现阶段业务拓展迅速，有一些不法分子利用公司的名义对会员进行欺诈行为，造成恶劣影响。本公司在此慎重声明，会员凡在公司平台消费的付款方式以本公司对公账户为准，本公司从未用私人帐户接受过会员消费，如有违背者追查到底，严惩不贷！本公司会员入单后需要经过严格的审核流程，时间为2个工作日，望各位会员及市场领导知晓！钱盛国际将带领所有家人超越梦想、共赢未来。
     */

    private String id;
    private String index_title;
    private String index_name;
    private String index_faburen;
    private String index_time;
    private String index_content;

    public NoticesBean() {
    }

    protected NoticesBean(Parcel in) {
        this.id = in.readString();
        this.index_title = in.readString();
        this.index_name = in.readString();
        this.index_faburen = in.readString();
        this.index_time = in.readString();
        this.index_content = in.readString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIndex_title() {
        return index_title;
    }

    public void setIndex_title(String index_title) {
        this.index_title = index_title;
    }

    public String getIndex_name() {
        return index_name;
    }

    public void setIndex_name(String index_name) {
        this.index_name = index_name;
    }

    public String getIndex_faburen() {
        return index_faburen;
    }

    public void setIndex_faburen(String index_faburen) {
        this.index_faburen = index_faburen;
    }

    public String getIndex_time() {
        return index_time;
    }

    public void setIndex_time(String index_time) {
        this.index_time = index_time;
    }

    public String getIndex_content() {
        return index_content;
    }

    public void setIndex_content(String index_content) {
        this.index_content = index_content;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.index_title);
        dest.writeString(this.index_name);
        dest.writeString(this.index_faburen);
        dest.writeString(this.index_time);
        dest.writeString(this.index_content);
    }
}

