package com.qs.qswlw.okhttp.Factory;

import com.qs.qswlw.okhttp.Moudle.BizAngelRanking;
import com.qs.qswlw.okhttp.Moudle.BizConsumptionRecord;
import com.qs.qswlw.okhttp.Moudle.BizEntrepreneurial;
import com.qs.qswlw.okhttp.Moudle.BizGoodProduct;
import com.qs.qswlw.okhttp.Moudle.BizMain;
import com.qs.qswlw.okhttp.Moudle.BizMyProfit;
import com.qs.qswlw.okhttp.Moudle.BizMyRole;
import com.qs.qswlw.okhttp.Moudle.BizMySliverBean;
import com.qs.qswlw.okhttp.Moudle.BizOldMember;
import com.qs.qswlw.okhttp.Moudle.BizPersonalSetting;
import com.qs.qswlw.okhttp.Moudle.BizRanking;
import com.qs.qswlw.okhttp.Moudle.BizRecommendRecord;
import com.qs.qswlw.okhttp.Moudle.BizRecordList;
import com.qs.qswlw.okhttp.Moudle.BizValidateOldMember;
import com.qs.qswlw.okhttp.Moudle.BizVentureGold;
import com.qs.qswlw.okhttp.Moudle.IAngelRankingBiz;
import com.qs.qswlw.okhttp.Moudle.IConsumptionRecordBiz;
import com.qs.qswlw.okhttp.Moudle.IEntrepreneurialBiz;
import com.qs.qswlw.okhttp.Moudle.IMainBiz;
import com.qs.qswlw.okhttp.Moudle.IMyProfitBiz;
import com.qs.qswlw.okhttp.Moudle.IMyRoleBiz;
import com.qs.qswlw.okhttp.Moudle.IMySliverBeanBiz;
import com.qs.qswlw.okhttp.Moudle.IOldMemberBiz;
import com.qs.qswlw.okhttp.Moudle.IPersonalSettingBiz;
import com.qs.qswlw.okhttp.Moudle.IProductBiz;
import com.qs.qswlw.okhttp.Moudle.IRankingBiz;
import com.qs.qswlw.okhttp.Moudle.IRecommendRecordBiz;
import com.qs.qswlw.okhttp.Moudle.IRecordListBiz;
import com.qs.qswlw.okhttp.Moudle.ITestaBiz;
import com.qs.qswlw.okhttp.Moudle.IValidateOldMemberBiz;
import com.qs.qswlw.okhttp.Moudle.IVentureGoldBiz;
import com.qs.qswlw.okhttp.Moudle.TestaMoudle;

/**
 * Created by 小猴子 on 2017/4/7.
 * <p>
 * <p>
 * 注
 * <p>
 * 所有I开头的JAVA文件皆是接口
 */

public class IBizFactory {
    public static ITestaBiz getItestBiz() {
        return TestaMoudle.getInstans();
    }

    public static IMainBiz getMainBiz() {
        return BizMain.getInstans();
    }
    public static IProductBiz getProductBiz() {
        return BizGoodProduct.getInstans();
    }
    public static IRankingBiz getRankingBiz() {
        return BizRanking.getInstans();
    }
    public static IAngelRankingBiz getAngelRankingBiz() {
        return BizAngelRanking.getInstans();
    }
    public static IPersonalSettingBiz getPersonalSettingBiz() {
        return BizPersonalSetting.getInstans();
    }
    public static IRecommendRecordBiz getRecommendRecordsBiz(){
        return BizRecommendRecord.getInstans();
    }
    public static IOldMemberBiz getOldMemberBiz(){
        return BizOldMember.getInstans();
    }

    public static IValidateOldMemberBiz getValidateOldMemberBiz(){
        return BizValidateOldMember.getInstans();
    }
    public static IMyRoleBiz getMyRoleBiz(){
        return BizMyRole.getInstans();
    }
    public static IMySliverBeanBiz getMySliverBeanBiz(){
        return BizMySliverBean.getInstans();
    }
    public static IEntrepreneurialBiz getEntrepreneurial(){
        return BizEntrepreneurial.getInstans();
    }
    public static IVentureGoldBiz getVentureGold(){
        return BizVentureGold.getInstans();
    }
    public static IConsumptionRecordBiz getConsumptionRecord(){
        return BizConsumptionRecord.getInstans();
    }
    public static IRecordListBiz getRecordList(){
        return BizRecordList.getInstans();
    }
    public static IMyProfitBiz getMyProfitList(){
        return BizMyProfit.getInstans();
    }
}
