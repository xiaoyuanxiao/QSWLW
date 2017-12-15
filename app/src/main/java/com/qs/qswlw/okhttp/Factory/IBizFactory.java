package com.qs.qswlw.okhttp.Factory;

import com.qs.qswlw.okhttp.Moudle.BizAngelRanking;
import com.qs.qswlw.okhttp.Moudle.BizBusinessTurnover;
import com.qs.qswlw.okhttp.Moudle.BizComplimentaryMerchandiseRecord;
import com.qs.qswlw.okhttp.Moudle.BizConsumptionLimit;
import com.qs.qswlw.okhttp.Moudle.BizConsumptionLimitRecharge;
import com.qs.qswlw.okhttp.Moudle.BizConsumptionRecord;
import com.qs.qswlw.okhttp.Moudle.BizEntrepreneurial;
import com.qs.qswlw.okhttp.Moudle.BizGoodProduct;
import com.qs.qswlw.okhttp.Moudle.BizImproveCity;
import com.qs.qswlw.okhttp.Moudle.BizImproveDocumentation;
import com.qs.qswlw.okhttp.Moudle.BizMain;
import com.qs.qswlw.okhttp.Moudle.BizMerchantAudit;
import com.qs.qswlw.okhttp.Moudle.BizMerchantAuditClick;
import com.qs.qswlw.okhttp.Moudle.BizMyBankList;
import com.qs.qswlw.okhttp.Moudle.BizMyProfit;
import com.qs.qswlw.okhttp.Moudle.BizMyRole;
import com.qs.qswlw.okhttp.Moudle.BizMySliverBean;
import com.qs.qswlw.okhttp.Moudle.BizMySpendingLimit;
import com.qs.qswlw.okhttp.Moudle.BizNotices;
import com.qs.qswlw.okhttp.Moudle.BizOldMember;
import com.qs.qswlw.okhttp.Moudle.BizPersonalSetting;
import com.qs.qswlw.okhttp.Moudle.BizPopRanking;
import com.qs.qswlw.okhttp.Moudle.BizRanking;
import com.qs.qswlw.okhttp.Moudle.BizRecommendRecord;
import com.qs.qswlw.okhttp.Moudle.BizRecordList;
import com.qs.qswlw.okhttp.Moudle.BizScanCodeRecord;
import com.qs.qswlw.okhttp.Moudle.BizSetModify;
import com.qs.qswlw.okhttp.Moudle.BizSettingNew;
import com.qs.qswlw.okhttp.Moudle.BizValidateOldMember;
import com.qs.qswlw.okhttp.Moudle.BizVentureGold;
import com.qs.qswlw.okhttp.Moudle.BizWithDrawalsRecord;
import com.qs.qswlw.okhttp.Moudle.BizWithdrawals;
import com.qs.qswlw.okhttp.Moudle.BizWithdrawalsAdd;
import com.qs.qswlw.okhttp.Moudle.BizWithdrawalsCity;
import com.qs.qswlw.okhttp.Moudle.BizWithdrawalsFailedModify;
import com.qs.qswlw.okhttp.Moudle.IAngelRankingBiz;
import com.qs.qswlw.okhttp.Moudle.IBusinessTurnoverBiz;
import com.qs.qswlw.okhttp.Moudle.IComplimentaryMerchandiseRecordBiz;
import com.qs.qswlw.okhttp.Moudle.IConsumptionLimitBiz;
import com.qs.qswlw.okhttp.Moudle.IConsumptionLimitRechargeBiz;
import com.qs.qswlw.okhttp.Moudle.IConsumptionRecordBiz;
import com.qs.qswlw.okhttp.Moudle.IEntrepreneurialBiz;
import com.qs.qswlw.okhttp.Moudle.IImproveCityBiz;
import com.qs.qswlw.okhttp.Moudle.IImproveDocumentationBiz;
import com.qs.qswlw.okhttp.Moudle.IMainBiz;
import com.qs.qswlw.okhttp.Moudle.IMerchantAuditBiz;
import com.qs.qswlw.okhttp.Moudle.IMerchantAuditClickBiz;
import com.qs.qswlw.okhttp.Moudle.IMyBankListBiz;
import com.qs.qswlw.okhttp.Moudle.IMyProfitBiz;
import com.qs.qswlw.okhttp.Moudle.IMyRoleBiz;
import com.qs.qswlw.okhttp.Moudle.IMySliverBeanBiz;
import com.qs.qswlw.okhttp.Moudle.IMySpendingLimitBiz;
import com.qs.qswlw.okhttp.Moudle.INoticesBiz;
import com.qs.qswlw.okhttp.Moudle.IOldMemberBiz;
import com.qs.qswlw.okhttp.Moudle.IPersonalSettingBiz;
import com.qs.qswlw.okhttp.Moudle.IPopRankingBiz;
import com.qs.qswlw.okhttp.Moudle.IProductBiz;
import com.qs.qswlw.okhttp.Moudle.IRankingBiz;
import com.qs.qswlw.okhttp.Moudle.IRecommendRecordBiz;
import com.qs.qswlw.okhttp.Moudle.IRecordListBiz;
import com.qs.qswlw.okhttp.Moudle.IScanCodeRecordBiz;
import com.qs.qswlw.okhttp.Moudle.ISetModifyBiz;
import com.qs.qswlw.okhttp.Moudle.ISettingNewBiz;
import com.qs.qswlw.okhttp.Moudle.ITestaBiz;
import com.qs.qswlw.okhttp.Moudle.IValidateOldMemberBiz;
import com.qs.qswlw.okhttp.Moudle.IVentureGoldBiz;
import com.qs.qswlw.okhttp.Moudle.IWithDrawalsRecordBiz;
import com.qs.qswlw.okhttp.Moudle.IWithdrawalsAddBiz;
import com.qs.qswlw.okhttp.Moudle.IWithdrawalsBiz;
import com.qs.qswlw.okhttp.Moudle.IWithdrawalsCityBiz;
import com.qs.qswlw.okhttp.Moudle.IWithdrawalsFailedModifyBiz;
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
    public static IMerchantAuditBiz getMerchantAuditList(){
        return BizMerchantAudit.getInstans();
    }
    public static IMerchantAuditClickBiz getMerchantAuditClickList(){
        return BizMerchantAuditClick.getInstans();
    }
    public static IScanCodeRecordBiz getScanCodeRecordList(){
        return BizScanCodeRecord.getInstans();
    }
    public static IImproveDocumentationBiz getImproveDocumentationList(){
        return BizImproveDocumentation.getInstans();
    }
    public static IBusinessTurnoverBiz getBusinessTurnoveList(){
        return BizBusinessTurnover.getInstans();
    }
    public static IWithdrawalsBiz getWithdrawalsList(){
        return BizWithdrawals.getInstans();
    }
    public static IWithDrawalsRecordBiz getWithdrawalsRecordList(){
        return BizWithDrawalsRecord.getInstans();
    }
    public static IImproveCityBiz getImproveCityList(){
        return BizImproveCity.getInstans();
    }
    public static IMyBankListBiz getMyBankList(){
        return BizMyBankList.getInstans();
    }
    public static IWithdrawalsAddBiz getWithdrawalsAddList(){
        return BizWithdrawalsAdd.getInstans();
    }
    public static IWithdrawalsCityBiz getWithdrawalsCityList(){
        return BizWithdrawalsCity.getInstans();
    }
    public static IWithdrawalsFailedModifyBiz getWithdrawalsFailedModifyList(){
        return BizWithdrawalsFailedModify.getInstans();
    }
    public static IConsumptionLimitBiz getConsumptionLimitList(){
        return BizConsumptionLimit.getInstans();
    }
    public static IConsumptionLimitRechargeBiz getConsumptionLimitRechargeList(){
        return BizConsumptionLimitRecharge.getInstans();
    }
    public static IMySpendingLimitBiz getMySpendingLimitList(){
        return BizMySpendingLimit.getInstans();
    }
    public static IComplimentaryMerchandiseRecordBiz getComplimentaryMerchandiseRecordList(){
        return BizComplimentaryMerchandiseRecord.getInstans();
    }

    public static INoticesBiz getNoticesList(){
        return BizNotices.getInstans();
    }
    public static IPopRankingBiz getPopRankingList(){
        return BizPopRanking.getInstans();
    }

    public static ISetModifyBiz getSetModifyList(){
        return BizSetModify.getInstans();
    }
    public static ISettingNewBiz getSettingNewList(){
        return BizSettingNew.getInstans();
    }
}
