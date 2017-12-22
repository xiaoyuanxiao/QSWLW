package com.qs.qswlw.mynet;


import com.qs.qswlw.bean.AngelRankingBean;
import com.qs.qswlw.bean.BusinessTurnoverBean;
import com.qs.qswlw.bean.ComplimentaryMerchandiseRecordBean;
import com.qs.qswlw.bean.ConsumptionLimitBean;
import com.qs.qswlw.bean.ConsumptionLimitRechargeBean;
import com.qs.qswlw.bean.ConsumptionRecordBean;
import com.qs.qswlw.bean.EntrepreneurialDialogBean;
import com.qs.qswlw.bean.EntrepreneurialIncentiveBean;
import com.qs.qswlw.bean.ForgetPassWordBean;
import com.qs.qswlw.bean.GoodProductBean;
import com.qs.qswlw.bean.ImproveCityBean;
import com.qs.qswlw.bean.ImproveDocumentationBean;
import com.qs.qswlw.bean.LoginBean;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.Maindatabean;
import com.qs.qswlw.bean.MerchantAuditBean;
import com.qs.qswlw.bean.MerchantAuditClickBean;
import com.qs.qswlw.bean.MyBankListBean;
import com.qs.qswlw.bean.MyBonusBean;
import com.qs.qswlw.bean.MyOrganizationBean;
import com.qs.qswlw.bean.MyProfitBean;
import com.qs.qswlw.bean.MyRoleBean;
import com.qs.qswlw.bean.MyRoleDatailBean;
import com.qs.qswlw.bean.MySliverBean;
import com.qs.qswlw.bean.MySpendingLimitBean;
import com.qs.qswlw.bean.NoticesBean;
import com.qs.qswlw.bean.OldMemberBean;
import com.qs.qswlw.bean.PersonalSettingBean;
import com.qs.qswlw.bean.PopRankingBean;
import com.qs.qswlw.bean.RankingBean;
import com.qs.qswlw.bean.ReceivingAddressBean;
import com.qs.qswlw.bean.RecommendedRecordsBean;
import com.qs.qswlw.bean.RecordListBaseBean;
import com.qs.qswlw.bean.RegisterBean;
import com.qs.qswlw.bean.RegisterCheckIdBean;
import com.qs.qswlw.bean.RegisterGetCodeBean;
import com.qs.qswlw.bean.ScanCodeRecordBean;
import com.qs.qswlw.bean.SetModifyBean;
import com.qs.qswlw.bean.SettingNewsBean;
import com.qs.qswlw.bean.ValidateOldMemberBean;
import com.qs.qswlw.bean.VenturegoldBean;
import com.qs.qswlw.bean.WithDrawalsRecordBean;
import com.qs.qswlw.bean.WithdrawalsAddBean;
import com.qs.qswlw.bean.WithdrawalsBean;
import com.qs.qswlw.bean.WithdrawalsCityBean;
import com.qs.qswlw.bean.WithdrawalsFailedModifyBean;

import java.io.File;
import java.util.List;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by buring on 2017/5/26.
 */

public interface MyRetroService {
    @GET("index.php?m=Appapi&c=Index&a=index")
    Observable<TestBean> getCommissionSummaryDaily();

    @GET
    Observable<TestBean> getCommissionSummaryDaily(@Url String url);

    /**
     * 给上注释
     *
     * @return
     */
    @POST("index.php?m=Appapi&c=Index&a=index")
    Observable<MainBean<Maindatabean>> getALLdata();

    /**
     * 联盟商家排行榜
     *
     * @param a
     * @return
     * @Multipart对应from-data
     */
    @Multipart// 参数格式
    @POST("index.php?m=Appapi&c=Index&a=ranking_list4")
    Observable<MainBean<RankingBean>> getRankingData(@Part("time_slot") String a);

    /**
     *
     */
    @POST("index.php?m=Appapi&c=Index&a=qsnotice")
    Observable<MainBean<List<NoticesBean>>> getNotices();

    /**
     * 获取短信验证码
     *
     * @param a
     * @return
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Login&a=get_register_send")
    Observable<MainBean<RegisterGetCodeBean>> getCodeData(@Field("mobile") String a, @Field("type") int type);


    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Login&a=get_register_send")
    Observable<MainBean<RegisterGetCodeBean>> getForgetPwCodeData(@Field("mobile") String a, @Field("type") int type);

    /**
     * 创业种子
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=UserBonus&a=love")
    Observable<MainBean<EntrepreneurialIncentiveBean>> getEntrepreneurialData(@Field("token") String token, @Field("p") int p, @Field("model") String model);

    /**
     * 录单记录
     */

    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Single&a=formlist")
    Observable<MainBean<RecordListBaseBean>> getRecordListData(@Field("token") String token, @Field("p") int p, @Field("type") String type, @Field("is_go") String is_go);

    /**
     * 我要提现,对应x-www-form-urlencoded
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Bankroll&a=cash")
    Observable<MainBean<WithdrawalsBean>> getWithDrawalsData(@Field("token") String token);

    /**
     * 提现申请
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Bankroll&a=docash")
    Observable<MainBean> PostWithDrawalsData(@Field("token") String token, @Field("amoney") float amoney, @Field("pass") String pass, @Field("gold_model") String gold_model);


    /**
     * 提现记录
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Bankroll&a=cashlist")
    Observable<MainBean<WithDrawalsRecordBean>> getWithDrawalsRecordData(@Field("token") String token, @Field("p") int p, @Field("status") String status);

    /**
     * 撤销提现
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Bankroll&a=del_cash_info")
    Observable<MainBean> PostWithdrawaslRecall(@Field("token") String token, @Field("id") int id);

    /**
     * 提现失败修改
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Bankroll&a=cashlist_edit")
    Observable<MainBean<WithdrawalsFailedModifyBean>> getWithdrawalsFailedModify(@Field("token") String token, @Field("id") int id);

    /**
     * 处理修改提现信息
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Bankroll&a=do_cashlist_edit")
    Observable<MainBean> PostWithdrawalsFailedModify(@Field("token") String token, @Field("id") int id, @Field("cardholder") String cardholder, @Field("to_bank") String to_bank,
                                                     @Field("region") int region, @Field("city") int city, @Field("branch") String branch, @Field("bank_card") String bank_card);

    /**
     * 重新提交提现
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Bankroll&a=cash_fail_again_sub")
    Observable<MainBean> PostPostWithdrawalsFailedResubmit(@Field("token") String token, @Field("wid") int wid);

    /**
     * 我的银行卡列表
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Bankroll&a=card")
    Observable<MainBean<MyBankListBean>> getMyBankListData(@Field("token") String token);

    /**
     * 添加或编辑银行卡
     */

    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Bankroll&a=add_bank")
    Observable<MainBean<WithdrawalsAddBean>> getWithdrawalsAddData(@Field("token") String token, @Field("id") int id);

    /**
     * 获取市列表信息
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Bankroll&a=ajaxcheckc_new")
    Observable<MainBean<WithdrawalsCityBean>> getWithdrawalsCityData(@Field("token") String token, @Field("pid") int pid);

    /**
     * 添加处理银行卡信息
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Bankroll&a=do_bank")
    Observable<MainBean> PostWithdrawalsAddData(@Field("token") String token, @Field("id") int id, @Field("cname") String cname, @Field("card") String card,
                                                @Field("pcity") int pcity, @Field("ccity") int ccity, @Field("account") String account, @Field("cardnumber") String cardnumber);

    /**
     * 设置默认提现银行卡
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Bankroll&a=steup_card")
    Observable<MainBean> PostWithdrawalsDefault(@Field("token") String token, @Field("id") int id);

    /**
     * 删除银行卡
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Bankroll&a=del_bank")
    Observable<MainBean> PostWithdrawalsDel(@Field("token") String token, @Field("id") int id);

    /**
     * 商家审核消费录单
     */
    @GET("index.php?m=Appapi&c=Single&a=shop_review_edit")
    Observable<MainBean<MerchantAuditClickBean>> getMerchantAuditClickData(@Query("token") String token, @Query("id") int id);

    /**
     * 消费金豆额度
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Taxgold&a=my_taxgold")
    Observable<MainBean<ConsumptionLimitBean>> getConsumptionLimitData(@Field("token") String token, @Field("p") int p);

    /**
     * 消费金豆额度充值
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Taxgold&a=get_money")
    Observable<MainBean<ConsumptionLimitRechargeBean>> getConsumptionLimitRechargeData(@Field("token") String token, @Field("recharge_type") String recharge_type);

    /**
     * 消费金豆额度充值提交
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Taxgold&a=do_get_money")
    Observable<MainBean> PostConsumptionLimitRecharge(@Field("token") String token, @Field("ratio") String ratio, @Field("none") String none, @Field("money") String money,
                                                      @Field("recharge_type") String recharge_type, @Field("remittance") File remittance);

    /**
     * 商家营业额
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Shop&a=turnover")
    Observable<MainBean<BusinessTurnoverBean>> getBusinessTurnoverData(@Field("token") String token, @Field("p") int p, @Field("is_history") int is_history);

    /**
     * 获得消费银豆记录
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=UserBonus&a=silver")
    Observable<MainBean<MySliverBean>> getMySliverBeanData(@Field("token") String token, @Field("p") int p);


    /**
     * 商家审核
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Single&a=shop_review")
    Observable<MainBean<MerchantAuditBean>> getMerchantAuditData(@Field("token") String token, @Field("p") int p, @Field("is_ok") int is_ok);

    /**
     * 选送商品记录
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=HappyGame&a=send_goods_record")
    Observable<MainBean<ComplimentaryMerchandiseRecordBean>> getComplimentaryMerchandiseData(@Field("token") String token, @Field("p") int p, @Field("is_review") int is_review);

    /**
     * 我的管理费
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Single&a=my_none")
    Observable<MainBean<MyProfitBean>> getMyProfitData(@Field("token") String token, @Field("p") int p);


    /**
     * 兑换创业种子数
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=UserBonus&a=do_love")
    Observable<MainBean<EntrepreneurialDialogBean>> postEntrepreneurialDialog(@Field("token") String token, @Field("model") String model, @Field("love") int love);


    /**
     * 我的角色
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=User&a=my_user")
    Observable<MainBean<MyRoleBean>> getMyRoleData(@Field("token") String token);

    /**
     * 我的消费额度
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=ConsumeQuota&a=index")
    Observable<MainBean<MySpendingLimitBean>> getMySpendingLimitData(@Field("token") String token, @Field("p") int p, @Field("tab_status") int tab_status);


    /**
     * 线下消费录单
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Single&a=getmoney")
    Observable<MainBean<ConsumptionRecordBean>> getConsumptionRecordData(@Field("token") String token);

    /**
     * 提交消费录单
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Single&a=do_money")
    Observable<MainBean> PostConsumptionData(@Field("token") String token, @Field("uid") int uid, @Field("money") float money, @Field("ratio") float ratio,
                                             @Field("none") float none, @Field("ratio_key") String ratio_key, @Field("pay_type") String pay_type, @Field("pay_time") String pay_time,
                                             @Field("pay_name") String pay_name, @Field("remittance") File remittance);

    /**
     * 商家审核提交消费录单
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Single&a=shop_review_audited")
    Observable<MainBean> PostConsumptionData1(@Field("token") String token, @Field("id") int id, @Field("goods_id") int goods_id, @Field("uid") int uid,
                                              @Field("money") float money, @Field("ratio") float ratio, @Field("none") float none, @Field("ratio_key") String ratio_key,
                                              @Field("pay_type") String pay_type, @Field("pay_name") String pay_name, @Field("pay_time") String pay_time, @Field("msales_su") int msales_su,
                                             @Field("remittance") File remittance);

    /**
     * 线下门店扫码
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Single&a=user_review")
    Observable<MainBean<ScanCodeRecordBean>> getScanCodeRecordData(@Field("token") String token, @Field("p") int p, @Field("is_ok") int is_ok);

    /**
     * 提交密码重设
     *
     * @param mobile
     * @param roles
     * @param pass
     * @param repass
     * @param type
     * @param mobile_code
     * @return
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Login&a=do_password")
    Observable<MainBean<ForgetPassWordBean>> postForgetPWData(@Field("mobile") String mobile, @Field("roles") int roles, @Field("pass") String pass,
                                                              @Field("repass") String repass, @Field("type") String type,
                                                              @Field("mobile_code") String mobile_code);

    /**
     * 商家完善资料
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Shop&a=shopadd")
    Observable<MainBean<ImproveDocumentationBean>> getImproveDocumentationData(@Field("token") String token);

    /**
     * 省市区选择
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Shop&a=ajaxcheckp")
    Observable<MainBean<ImproveCityBean>> getImproveCityData(@Field("token") String token, @Field("pid") int pid);

    /**
     * 提交商家资料
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Shop&a=doshop")
    Observable<MainBean> postImproveCommit(@Field("token") String token, @Field("id") int id, @Field("license") File license,
                                           @Field("photo") File photo, @Field("shop_name") String shop_name, @Field("company_name") String company_name,
                                           @Field("shop_tel") String shop_tel, @Field("province") int province, @Field("city") int city,
                                           @Field("district") int district, @Field("address") String address, @Field("cat_id") int cat_id,
                                           @Field("category") String category, @Field("start") String start, @Field("end") String end,
                                           @Field("starttime") String starttime, @Field("endtime") String endtime, @Field("add_time") String add_time,
                                           @Field("name") String name, @Field("mobile") String mobile, @Field("business_id") int business_id);


    /**
     * 提交验证老会员信息
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=User&a=do_check_old_member")
    Observable<MainBean<OldMemberBean>> postOldMemberData(@Field("token") String token, @Field("member_number") String member_number, @Field("member_type") String member_type);

    /**
     * 我是老会员
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=User&a=check_old_member")
    Observable<MainBean<ValidateOldMemberBean>> getOldMemberData(@Field("token") String token);

    /**
     * 获取推荐人信息
     *
     * @param a
     * @return
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Login&a=ajaxuser")
    Observable<MainBean<RegisterCheckIdBean>> getIdData(@Field("uid") int a);


    /**
     * 个人中心
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=User&a=role")
    Observable<MainBean<PersonalSettingBean>> getPersonalData(@Field("token") String token);

    /**
     * 我的金豆
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=UserBonus&a=gold")
    Observable<MainBean<VenturegoldBean>> getVentureGoldData(@Field("token") String token, @Field("p") int p, @Field("model") String model, @Field("gold_type") String gold_type, @Field("type") String type);

    /**
     * 推荐记录
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=User&a=recommend_list")
    Observable<MainBean<List<RecommendedRecordsBean>>> getRecommendRecordData(@Field("token") String token, @Field("p") int p, @Field("search_name") String search_name, @Field("tab_name") String tab_name);

    /**
     * 注册
     *
     * @param mobile
     * @param id
     * @param nickname
     * @param password
     * @param repassword
     * @param role
     * @param post_code
     * @return
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Login&a=do_register")
    Observable<MainBean<RegisterBean>> postRgisterData(@Field("mobile") String mobile, @Field("id") int id, @Field("nickname") String nickname,
                                                       @Field("password") String password, @Field("repassword") String repassword,
                                                       @Field("role") int role, @Field("post_code") String post_code);

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Login&a=do_login")
    Observable<MainBean<LoginBean>> postLogin(@Field("username") String username, @Field("password") String password);

    /**
     * 创业天使创业排名榜
     *
     * @return
     */
    @Multipart
    @POST("index.php?m=Appapi&c=Index&a=ranking_list3")
//头去掉 因为写过了，在那些了
    Observable<MainBean<AngelRankingBean>> getAngelRankingData(@Part("time_slot") String a);

    @POST("index.php?m=Appapi&c=Index&a=good_product")
/**括号里面是路径*/
    Observable<MainBean<GoodProductBean>> getGoodproductdata();


    /**
     * 如果 头部不是实用 就是说有一些是特殊的 不一样的 哦哦 如果不是http://qiansheng.com开头的我就全部写 不对  要改成这样
     * 还有
     */
    //Observable<MainBean<GoodProductBean>> getGoodproductdata(@Url String url);//传进来全部的  哦哦
    @POST("index.php?m=Appapi&c=Index&a=good_product")
/**括号里面是路径*/
    Observable<MainBean<GoodProductBean>> getCity();


    /**
     * 省市区代排行榜
     *
     * @param role
     * @param a
     * @return
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=Index&a=rank_top")
    Observable<MainBean<PopRankingBean>> getPopRankingData(@Field("role") String role, @Field("time_slot") String a);

    /**
     * 个人中心资料
     *
     * @param token
     * @param user_id
     * @return
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=User&a=userinfo")
    Observable<MainBean<SetModifyBean>> getSetModifyData(@Field("token") String token, @Field("user_id") int user_id);

    /**
     * 个人资料头像修改
     *
     * @param token
     * @param user_id
     * @param images
     * @return
     * @Part("token") String token, @Part("user_id") int user_id,@Part("images") File images
     */
    // @Multipart
    @POST("index.php?m=Appapi&c=user&a=updload_head")
    Observable<MainBean> getUserAvaterData(@Body RequestBody requestBody);

    /**
     * 个人资料昵称修改
     *
     * @param token
     * @param user_id
     * @param nickname
     * @return
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=User&a=editname")
    Observable<MainBean> getUserNameData(@Field("token") String token, @Field("user_id") int user_id, @Field("nickname") String nickname);

    /**
     * 修改密码和修改二级密码
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=user&a=setup")
    Observable<MainBean> getPasswordData(@Field("token") String token, @Field("user_id") int user_id, @Field("pass") String pass,
                                         @Field("password") String password, @Field("repassword") String repassword, @Field("type") int type);

    /**
     * 找回二级密码
     *
     * @param token
     * @param user_id
     * @return
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=user&a=findpwd")
    Observable<MainBean> getRetrievePassData(@Field("token") String token, @Field("user_id") int user_id,
                                             @Field("mobile") String mobile, @Field("mobile_code") String mobile_code, @Field("roles") int roles,
                                             @Field("pass") String pass, @Field("repass") String repass);

    /**
     * 设置消息列表
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=User&a=minemsg")
    Observable<MainBean<SettingNewsBean>> getSettingNewData(@Field("token") String token, @Field("user_id") int user_id);

    /**
     * 设置消息列表
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=User&a=mymech")
    Observable<MainBean<MyOrganizationBean>> getMyOrganizationData(@Field("token") String token, @Field("user_id") int user_id);

    /**
     * 收货地址
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=User&a=cyzx_address")
    Observable<MainBean<ReceivingAddressBean>> getReceivingAddressData(@Field("token") String token, @Field("cyzx_id") int cyzx_id);


    /**
     * 我的奖金
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=User&a=gold_bonus")
    Observable<MainBean<MyBonusBean>> getMyBonusData(@Field("token") String token, @Field("user_id") int user_id,@Field("bonus_type") String bonus_type);

    /**
     * 伞下创业升级情况
     */
    @FormUrlEncoded
    @POST("index.php?m=Appapi&c=User")
    Observable<MainBean<MyRoleDatailBean>> getMyRoleDatailData(@Field("a") String a, @Field("token") String token);
}
