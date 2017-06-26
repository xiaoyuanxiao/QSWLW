package com.qs.qswlw.activity.PersonalCenter;

import android.annotation.TargetApi;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.utils.FileUtil;
import com.qs.qswlw.utils.ImageTools;
import com.qs.qswlw.utils.ToastUtils;
import com.qs.qswlw.view.GenderPopupWindow;
import com.qs.qswlw.view.PickTimeView;

import java.io.File;

/**
 * Created by xiaoyu on 2017/3/31.
 */

public class ImproveDocumentationActivity extends BaseInfoActivity {

    private Spinner province_spinner;
    private Spinner city_spinner;
    private Spinner county_spinner;
    private Integer provinceId, cityId;
    private EditText display;
    private String strProvince, strCity, strCounty;

    private int[] city = {R.array.beijin_province_item, R.array.tianjin_province_item, R.array.heibei_province_item, R.array.shanxi1_province_item, R.array.neimenggu_province_item, R.array.liaoning_province_item, R.array.jilin_province_item, R.array.heilongjiang_province_item, R.array.shanghai_province_item, R.array.jiangsu_province_item, R.array.zhejiang_province_item, R.array.anhui_province_item, R.array.fujian_province_item, R.array.jiangxi_province_item, R.array.shandong_province_item, R.array.henan_province_item, R.array.hubei_province_item, R.array.hunan_province_item, R.array.guangdong_province_item,  R.array.guangxi_province_item, R.array.hainan_province_item, R.array.chongqing_province_item, R.array.sichuan_province_item, R.array.guizhou_province_item, R.array.yunnan_province_item, R.array.xizang_province_item, R.array.shanxi2_province_item, R.array.gansu_province_item, R.array.qinghai_province_item, R.array.linxia_province_item, R.array.xinjiang_province_item, R.array.hongkong_province_item, R.array.aomen_province_item, R.array.taiwan_province_item};
    private int[] countyOfBeiJing = {R.array.beijin_city_item};
    private int[] countyOfTianJing = {R.array.tianjin_city_item};
    private int[] countyOfHeBei = {R.array.shijiazhuang_city_item, R.array.tangshan_city_item, R.array.qinghuangdao_city_item, R.array.handan_city_item, R.array.xingtai_city_item, R.array.baoding_city_item, R.array.zhangjiakou_city_item, R.array.chengde_city_item, R.array.cangzhou_city_item, R.array.langfang_city_item, R.array.hengshui_city_item};
    private int[] countyOfShanXi1 = {R.array.taiyuan_city_item, R.array.datong_city_item, R.array.yangquan_city_item, R.array.changzhi_city_item, R.array.jincheng_city_item, R.array.shuozhou_city_item, R.array.jinzhong_city_item, R.array.yuncheng_city_item, R.array.xinzhou_city_item, R.array.linfen_city_item, R.array.lvliang_city_item};
    private int[] countyOfNeiMengGu = {R.array.huhehaote_city_item, R.array.baotou_city_item, R.array.wuhai_city_item, R.array.chifeng_city_item, R.array.tongliao_city_item, R.array.eerduosi_city_item, R.array.hulunbeier_city_item, R.array.bayannaoer_city_item, R.array.wulanchabu_city_item, R.array.xinganmeng_city_item, R.array.xilinguolemeng_city_item, R.array.alashanmeng_city_item};
    private int[] countyOfLiaoNing = {R.array.shenyang_city_item, R.array.dalian_city_item, R.array.anshan_city_item, R.array.wushun_city_item, R.array.benxi_city_item, R.array.dandong_city_item, R.array.liaoning_jinzhou_city_item, R.array.yingkou_city_item, R.array.fuxin_city_item, R.array.liaoyang_city_item, R.array.panjin_city_item, R.array.tieling_city_item, R.array.zhaoyang_city_item, R.array.huludao_city_item};
    private int[] countyOfJiLin = {R.array.changchun_city_item, R.array.jilin_city_item, R.array.siping_city_item, R.array.liaoyuan_city_item, R.array.tonghua_city_item, R.array.baishan_city_item, R.array.songyuan_city_item, R.array.baicheng_city_item, R.array.yanbian_city_item};
    private int[] countyOfHeiLongJiang = {R.array.haerbing_city_item, R.array.qiqihaer_city_item, R.array.jixi_city_item, R.array.hegang_city_item, R.array.shuangyashan_city_item, R.array.daqing_city_item, R.array.heilongjiang_yichun_city_item, R.array.jiamusi_city_item, R.array.qitaihe_city_item, R.array.mudanjiang_city_item, R.array.heihe_city_item, R.array.suihua_city_item, R.array.daxinganling_city_item};
    private int[] countyOfShangHai = {R.array.shanghai_city_item};

    private int[] countyOfJiangSu = {R.array.nanjing_city_item, R.array.wuxi_city_item, R.array.xuzhou_city_item, R.array.changzhou_city_item, R.array.nanjing_suzhou_city_item, R.array.nantong_city_item, R.array.lianyungang_city_item, R.array.huaian_city_item, R.array.yancheng_city_item, R.array.yangzhou_city_item, R.array.zhenjiang_city_item, R.array.jiangsu_taizhou_city_item, R.array.suqian_city_item};
    private int[] countyOfZheJiang = {R.array.hangzhou_city_item, R.array.ningbo_city_item, R.array.wenzhou_city_item, R.array.jiaxing_city_item, R.array.huzhou_city_item, R.array.shaoxing_city_item, R.array.jinhua_city_item, R.array.quzhou_city_item, R.array.zhoushan_city_item, R.array.zejiang_huzhou_city_item, R.array.lishui_city_item};
    private int[] countyOfAnHui = {R.array.hefei_city_item, R.array.wuhu_city_item, R.array.bengbu_city_item, R.array.huainan_city_item, R.array.maanshan_city_item, R.array.huaibei_city_item, R.array.tongling_city_item, R.array.anqing_city_item, R.array.huangshan_city_item, R.array.chuzhou_city_item, R.array.fuyang_city_item, R.array.anhui_suzhou_city_item, R.array.chaohu_city_item, R.array.luan_city_item, R.array.haozhou_city_item, R.array.chizhou_city_item, R.array.xuancheng_city_item};
    private int[] countyOfFuJian = {R.array.huzhou_city_item, R.array.xiamen_city_item, R.array.putian_city_item, R.array.sanming_city_item, R.array.quanzhou_city_item, R.array.zhangzhou_city_item, R.array.nanp_city_item, R.array.longyan_city_item, R.array.ningde_city_item};
    private int[] countyOfJiangXi = {R.array.nanchang_city_item, R.array.jingdezhen_city_item, R.array.pingxiang_city_item, R.array.jiujiang_city_item, R.array.xinyu_city_item, R.array.yingtan_city_item, R.array.ganzhou_city_item, R.array.jian_city_item, R.array.jiangxi_yichun_city_item, R.array.jiangxi_wuzhou_city_item, R.array.shangrao_city_item};
    private int[] countyOfShanDong = {R.array.jinan_city_item, R.array.qingdao_city_item, R.array.zaobo_city_item, R.array.zaozhuang_city_item, R.array.dongying_city_item, R.array.yantai_city_item, R.array.weifang_city_item, R.array.jining_city_item, R.array.taian_city_item, R.array.weihai_city_item, R.array.rizhao_city_item, R.array.laiwu_city_item, R.array.linxi_city_item, R.array.dezhou_city_item, R.array.liaocheng_city_item, R.array.shandong_bingzhou_city_item, R.array.heze_city_item};
    private int[] countyOfHeNan = {R.array.zhenshou_city_item, R.array.kaifang_city_item, R.array.luoyang_city_item, R.array.kaipingshan_city_item, R.array.anyang_city_item, R.array.hebi_city_item, R.array.xinxiang_city_item, R.array.jiaozuo_city_item, R.array.buyang_city_item, R.array.xuchang_city_item, R.array.leihe_city_item, R.array.sanmenxia_city_item, R.array.nanyang_city_item, R.array.shangqiu_city_item, R.array.xinyang_city_item, R.array.zhoukou_city_item, R.array.zhumadian_city_item};
    private int[] countyOfHuBei = {R.array.wuhan_city_item, R.array.huangshi_city_item, R.array.shiyan_city_item, R.array.yichang_city_item, R.array.xiangpan_city_item, R.array.erzhou_city_item, R.array.jinmen_city_item, R.array.xiaogan_city_item, R.array.hubei_jinzhou_city_item, R.array.huanggang_city_item, R.array.xianning_city_item, R.array.suizhou_city_item, R.array.enshi_city_item, R.array.shenglongjia_city_item};

    private int[] countyOfHuNan = {R.array.changsha_city_item, R.array.zhuzhou_city_item, R.array.xiangtan_city_item, R.array.hengyang_city_item, R.array.shaoyang_city_item, R.array.yueyang_city_item, R.array.changde_city_item, R.array.zhangjiajie_city_item, R.array.yiyang_city_item, R.array.hunan_bingzhou_city_item, R.array.yongzhou_city_item, R.array.huaihua_city_item, R.array.loudi_city_item, R.array.xiangxi_city_item};
    private int[] countyOfGuangDong = {R.array.guangzhou_city_item, R.array.shaoguan_city_item, R.array.shenzhen_city_item, R.array.zhuhai_city_item, R.array.shantou_city_item, R.array.foshan_city_item, R.array.jiangmen_city_item, R.array.zhangjiang_city_item, R.array.maoming_city_item, R.array.zhaoqing_city_item, R.array.huizhou_city_item, R.array.meizhou_city_item, R.array.shanwei_city_item, R.array.heyuan_city_item, R.array.yangjiang_city_item, R.array.qingyuan_city_item, R.array.dongguan_city_item, R.array.zhongshan_city_item, R.array.chaozhou_city_item, R.array.jiyang_city_item, R.array.yunfu_city_item};
    private int[] countyOfGuangXi = {R.array.nanning_city_item, R.array.liuzhou_city_item, R.array.guilin_city_item, R.array.guangxi_wuzhou_city_item, R.array.beihai_city_item, R.array.fangchenggang_city_item, R.array.qinzhou_city_item, R.array.guigang_city_item, R.array.yuelin_city_item, R.array.baise_city_item, R.array.hezhou_city_item, R.array.hechi_city_item, R.array.laibing_city_item, R.array.chuangzuo_city_item};
    private int[] countyOfHaiNan = {R.array.haikou_city_item, R.array.sanya_city_item};
    private int[] countyOfChongQing = {R.array.chongqing_city_item};
    private int[] countyOfSiChuan = {R.array.chengdu_city_item, R.array.zigong_city_item, R.array.panzhihua_city_item, R.array.luzhou_city_item, R.array.deyang_city_item, R.array.mianyang_city_item, R.array.guangyuan_city_item, R.array.suining_city_item, R.array.neijiang_city_item, R.array.leshan_city_item, R.array.nanchong_city_item, R.array.meishan_city_item, R.array.yibing_city_item, R.array.guangan_city_item, R.array.dazhou_city_item, R.array.yaan_city_item, R.array.bazhong_city_item, R.array.ziyang_city_item, R.array.abei_city_item, R.array.ganmu_city_item, R.array.liangshan_city_item};
    private int[] countyOfGuiZhou = {R.array.guiyang_city_item, R.array.lupanshui_city_item, R.array.zhunyi_city_item, R.array.anshun_city_item, R.array.tongren_city_item, R.array.qingxinan_city_item, R.array.biji_city_item, R.array.qingdongnan_city_item, R.array.qingnan_city_item};
    private int[] countyOfYunNan = {R.array.kunming_city_item, R.array.qujing_city_item, R.array.yuexi_city_item, R.array.baoshan_city_item, R.array.zhaotong_city_item, R.array.lijiang_city_item, R.array.simao_city_item, R.array.lingcang_city_item, R.array.chuxiong_city_item, R.array.honghe_city_item, R.array.wenshan_city_item, R.array.xishuangbanna_city_item, R.array.dali_city_item, R.array.dehuang_city_item, R.array.nujiang_city_item, R.array.diqing_city_item};
    private int[] countyOfXiZang = {R.array.lasa_city_item, R.array.changdu_city_item, R.array.shannan_city_item, R.array.rgeze_city_item, R.array.naqu_city_item, R.array.ali_city_item, R.array.linzhi_city_item};

    private int[] countyOfShanXi2 = {R.array.xian_city_item, R.array.tongchuan_city_item, R.array.baoji_city_item, R.array.xianyang_city_item, R.array.weinan_city_item, R.array.yanan_city_item, R.array.hanzhong_city_item, R.array.yulin_city_item, R.array.ankang_city_item, R.array.shangluo_city_item};
    private int[] countyOfGanSu = {R.array.lanzhou_city_item, R.array.jiayuguan_city_item, R.array.jinchang_city_item, R.array.baiyin_city_item, R.array.tianshui_city_item, R.array.wuwei_city_item, R.array.zhangyue_city_item, R.array.pingliang_city_item, R.array.jiuquan_city_item, R.array.qingyang_city_item, R.array.dingxi_city_item, R.array.longnan_city_item, R.array.linxia_city_item, R.array.gannan_city_item};
    private int[] countyOfQingHai = {R.array.xining_city_item, R.array.haidong_city_item, R.array.haibai_city_item, R.array.huangnan_city_item, R.array.hainan_city_item, R.array.guluo_city_item, R.array.yushu_city_item, R.array.haixi_city_item};
    private int[] countyOfNingXia = {R.array.yinchuan_city_item, R.array.shizuishan_city_item, R.array.wuzhong_city_item, R.array.guyuan_city_item, R.array.zhongwei_city_item};
    private int[] countyOfXinJiang = {R.array.wulumuqi_city_item, R.array.kelamayi_city_item, R.array.tulyfan_city_item, R.array.hami_city_item, R.array.changji_city_item, R.array.boertala_city_item, R.array.bayinguolen_city_item, R.array.akesu_city_item, R.array.kemuleisu_city_item, R.array.geshen_city_item, R.array.hetian_city_item, R.array.yili_city_item, R.array.tacheng_city_item, R.array.aleitai_city_item, R.array.shihezi_city_item, R.array.alaer_city_item, R.array.tumushihe_city_item, R.array.wujiaqu_city_item};
    private int[] countyOfHongKong = {};
    private int[] countyOfAoMen = {};
    private int[] countyOfTaiWan = {};

    private ArrayAdapter<CharSequence> province_adapter;
    private ArrayAdapter<CharSequence> city_adapter;
    private ArrayAdapter<CharSequence> county_adapter;

    private Spinner classification_spinner;
    private ArrayAdapter<CharSequence> classification_adapter;
    private Integer classificationId;
    private String strClassification;

    private int day;
    private int hour;
    private int minute;
    private TextView tv_startTime,tv_endTime;
    private LinearLayout pvLayout;
    private PickTimeView pickTime;
    private ImageView iv_UploadBusinessLicense,iv_Storefacade;
    private GenderPopupWindow menuWindow;
    private static final int CAMERA = 2003;
    private static final int CHOOSE_PICTURE = 2004;
    final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    private Bitmap bitmap;
    private Uri imageUri;
    private ImageView pic_uploadBusinessLicense,pic_Storefacade;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_improvedocumentation, null);
        tv_startTime = (TextView) inflate.findViewById(R.id.tv_startTime);
        tv_endTime = (TextView) inflate.findViewById(R.id.tv_endTime);
        pvLayout = (LinearLayout) inflate.findViewById(R.id.Main_pvLayout);
        pickTime = (PickTimeView) inflate.findViewById(R.id.pickTime);
        iv_UploadBusinessLicense = (ImageView) inflate.findViewById(R.id.iv_UploadBusinessLicense);
        iv_Storefacade = (ImageView) inflate.findViewById(R.id.iv_Storefacade);
        pic_uploadBusinessLicense = (ImageView) inflate.findViewById(R.id.pic_UploadBusinessLicense);
        pic_Storefacade = (ImageView) inflate.findViewById(R.id.pic_Storefacade);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("完善商家资料");
    }

    @Override
    public void initData() {
        super.initData();
        loadSpinner();
        loadManagementClassificationSpinner();
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        tv_startTime.setOnClickListener(this);
        tv_endTime.setOnClickListener(this);
        iv_UploadBusinessLicense.setOnClickListener(this);
        iv_Storefacade.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.tv_startTime:
                pickTime.setVisibility(View.VISIBLE);
                showView(pickTime);
                break;
            case R.id.tv_endTime:
                pickTime.setVisibility(View.VISIBLE);
                showView(pickTime);
                break;
            case R.id.iv_UploadBusinessLicense:
                selectPhoto();
                break;
            case R.id.iv_Storefacade:
                selectPhoto();
                break;
        }
    }

    /**
     * 选择拍照或相册
     */
    private void selectPhoto(){
        menuWindow = new GenderPopupWindow(this, new ImproveDocumentationActivity.MyOnClickListener());
        menuWindow.showAtLocation(this.findViewById(R.id.iv_UploadBusinessLicense), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        menuWindow.setTitleName("选择图片来源");
        menuWindow.setFemaleName("相册");
        menuWindow.setMaleName("拍照");
    }
    //上传图片
    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_female:
                    //选择图片
                    Intent picture = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(picture, CHOOSE_PICTURE);
                    break;
                case R.id.tv_male:
                    //选择拍照
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    Uri imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "userLogo.jpg"));
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    startActivityForResult(intent, CAMERA);
                    break;
            }
            menuWindow.dismiss();
        }
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            switch (requestCode) {
                //选择照片
                case CHOOSE_PICTURE:
                    String photo_path = null;
                    if (isKitKat && DocumentsContract.isDocumentUri(this, data.getData())) {
                        String wholeID = DocumentsContract.getDocumentId(data.getData());
                        String id = wholeID.split(":")[1];
                        String[] column = {MediaStore.Images.Media.DATA};
                        String sel = MediaStore.Images.Media._ID + "=?";
                        Cursor cursor = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, column,
                                sel, new String[]{id}, null);
                        int columnIndex = cursor.getColumnIndex(column[0]);
                        if (cursor.moveToFirst()) {
                            photo_path = cursor.getString(columnIndex);
                        }
                        cursor.close();
                    } else {
                        String[] projection = {MediaStore.Images.Media.DATA};
                        Cursor cursor = getContentResolver().query(data.getData(), projection, null, null, null);
                        try{
                            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                            cursor.moveToFirst();
                            photo_path = cursor.getString(column_index);
                        }catch (Exception e){
                            e.printStackTrace();
                            ToastUtils.showToast(this,"选取的图片异常！");
                        }
                    }
                    if (photo_path!=null){
                        //上传图片到服务器
                        new Thread(new ImproveDocumentationActivity.SaveThread(photo_path)).start();
                    }else {
                        ToastUtils.showToast(this,"请重新选取图片！");
                    }
                    break;
            }
        }
        switch (requestCode) {
            case CAMERA:
                File f = new File(Environment.getExternalStorageDirectory(), "userLogo.jpg");
                String path = f.getPath();
                new Thread(new ImproveDocumentationActivity.SaveThread(path)).start();
                break;

        }
    }

    //上传图片
    private class SaveThread implements Runnable {
        private String path;

        public SaveThread(String path) {
            this.path = path;
        }

        @Override
        public void run() {
            //获取选中图片的路径
            if (TextUtils.isEmpty(path)) {
                return;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true; // 先获取原大小
            Bitmap scanBitmap = BitmapFactory.decodeFile(path, options);
            options.inJustDecodeBounds = false; // 获取新的大小
            int sampleSize = (int) (options.outHeight / (float) 200);
            if (sampleSize <= 0)
                sampleSize = 1;
            options.inSampleSize = sampleSize;
            scanBitmap = BitmapFactory.decodeFile(path, options);
            try{
                scanBitmap.getByteCount();
            }catch (Exception e){
                e.printStackTrace();
                ToastUtils.showToast(ImproveDocumentationActivity.this,"图片处理异常！");
            }
            if (scanBitmap != null) {//如果图片存在的话
                try {
                    bitmap = scanBitmap;
                    imageUri = Uri.fromFile(FileUtil.saveBitmap(scanBitmap));
                    File file = new File(ImageTools.uri2File(imageUri,ImproveDocumentationActivity.this));
                    Message message = handler.obtainMessage();
                    message.what = 1;
                    handler.sendMessage(message);

//                    Map<String, Object> map = new HashMap<>();
//                    // map.put("userId", ServerApi.USER_ID);
//                    map.put("userId", ServerApi.USER_ID);
//                    String data = GsonUtils.toJson(map);
//                    String sign = dataDealWith(data);
//                    String fileName = "";
//                        fileName = "userAvatar";
//                    } else if (ServerApi.USER_TYPE.equals("1")) {
//                        fileName = "staffAvatar";
//                    }
//                    String url = "";
//                    if (ServerApi.USER_TYPE.equals("0")) {
//                        url = ServerApi.returnUrl(ServerApi.Api.CUSTOMER_USER_AVATER, new GETParams().put("data", data).put("partner", Constant.PARTNER).put("sign", sign));
//                    } else if (ServerApi.USER_TYPE.equals("1")) {
//                        url = ServerApi.returnUrl(ServerApi.Api.CUSTOMER_CUSTOMER_AVATER, new GETParams().put("data", data).put("partner", Constant.PARTNER).put("sign", sign));
//                    }
//                    BitmapFactory.Options opt = new BitmapFactory.Options();
//                    opt.inJustDecodeBounds = true;
//                    BitmapFactory.decodeFile(file.getAbsolutePath(), opt);
//                    mNetworkRequester.multipartRequest(new MultipartJsonRequest(url, fileName, file,
//                            new NetworkRequester.ResponseListener() {
//                                @Override
//                                public void onSuccessful(JSONObject json) {
//                                    user_picture_set.setImageBitmap(bitmap);//上传成功更改ImageV上的图片
//                                    ToastUtils.showToast(CustomerInformationActivity.this, json.optString("message"));
//                                }
//
//                                @Override
//                                public void onFailed(String msg) {
//                                    ToastUtils.showToast(CustomerInformationActivity.this, msg);
//                                }
//                            }));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case 1:
                    pic_uploadBusinessLicense.setImageBitmap(bitmap);
                    break;
            }
        }

    };
    private void showView(View view) {
        for (int i = 0; i < pvLayout.getChildCount(); i++) {

            pvLayout.getChildAt(i).setVisibility(View.GONE);
        }
        view.setVisibility(View.VISIBLE);
    }
    /**
     * 经营分类spinner
     */
    private void loadManagementClassificationSpinner() {
        classification_spinner = (Spinner) findViewById(R.id.classification_spinner);
        classification_adapter = ArrayAdapter.createFromResource(this, R.array.classification_item, android.R.layout.simple_spinner_item);
        classification_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classification_spinner.setAdapter(classification_adapter);
        classification_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                classification_spinner.getSelectedItemPosition();
                strClassification = classification_spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }



    private void loadSpinner()
    {
        province_spinner = (Spinner) findViewById(R.id.province_spinner);
        province_spinner.setPrompt("请选择省份");
        province_adapter = ArrayAdapter.createFromResource(this, R.array.province_item, android.R.layout.simple_spinner_item);
        province_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        province_spinner.setAdapter(province_adapter);
        //select(province_spinner, province_adapter, R.array.province_item);
        province_spinner.setOnItemSelectedListener(new OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3)
            {
                provinceId = province_spinner.getSelectedItemPosition();
                strProvince = province_spinner.getSelectedItem().toString();
                city_spinner = (Spinner) findViewById(R.id.city_spinner);
                if(true)
                {
                    Log.v("test", "province: "+province_spinner.getSelectedItem().toString()+provinceId.toString());
                    county_spinner = (Spinner) findViewById(R.id.county_spinner);
                    city_spinner = (Spinner) findViewById(R.id.city_spinner);
                    city_spinner.setPrompt("请选择城市");
                    select(city_spinner, city_adapter, city[provinceId]);
                    city_spinner.setOnItemSelectedListener(new OnItemSelectedListener()
                    {

                        @Override
                        public void onItemSelected(AdapterView<?> arg0,
                                                   View arg1, int arg2, long arg3) {
                            cityId = city_spinner.getSelectedItemPosition();
                            strCity = city_spinner.getSelectedItem().toString();
                            Log.v("test", "city: "+city_spinner.getSelectedItem().toString()+cityId.toString());
                            if(true)
                            {
                                county_spinner = (Spinner) findViewById(R.id.county_spinner);
                                county_spinner.setPrompt("请选择县区");
                                switch (provinceId) {
                                    case 0:
                                        select(county_spinner, county_adapter, countyOfBeiJing[cityId]);
                                        break;
                                    case 1:
                                        select(county_spinner, county_adapter, countyOfTianJing[cityId]);
                                        break;
                                    case 2:
                                        select(county_spinner, county_adapter, countyOfHeBei[cityId]);
                                        break;
                                    case 3:
                                        select(county_spinner, county_adapter, countyOfShanXi1[cityId]);
                                        break;
                                    case 4:
                                        select(county_spinner, county_adapter, countyOfNeiMengGu[cityId]);
                                        break;
                                    case 5:
                                        select(county_spinner, county_adapter, countyOfLiaoNing[cityId]);
                                        break;
                                    case 6:
                                        select(county_spinner, county_adapter, countyOfJiLin[cityId]);
                                        break;
                                    case 7:
                                        select(county_spinner, county_adapter, countyOfHeiLongJiang[cityId]);
                                        break;
                                    case 8:
                                        select(county_spinner, county_adapter, countyOfShangHai[cityId]);
                                        break;
                                    case 9:
                                        select(county_spinner, county_adapter, countyOfJiangSu[cityId]);
                                        break;
                                    case 10:
                                        select(county_spinner, county_adapter, countyOfZheJiang[cityId]);
                                        break;
                                    case 11:
                                        select(county_spinner, county_adapter, countyOfAnHui[cityId]);
                                        break;
                                    case 12:
                                        select(county_spinner, county_adapter, countyOfFuJian[cityId]);
                                        break;
                                    case 13:
                                        select(county_spinner, county_adapter, countyOfJiangXi[cityId]);
                                        break;
                                    case 14:
                                        select(county_spinner, county_adapter, countyOfShanDong[cityId]);
                                        break;
                                    case 15:
                                        select(county_spinner, county_adapter, countyOfHeNan[cityId]);
                                        break;
                                    case 16:
                                        select(county_spinner, county_adapter, countyOfHuBei[cityId]);
                                        break;
                                    case 17:
                                        select(county_spinner, county_adapter, countyOfHuNan[cityId]);
                                        break;
                                    case 18:
                                        select(county_spinner, county_adapter, countyOfGuangDong[cityId]);
                                        break;
                                    case 19:
                                        select(county_spinner, county_adapter, countyOfGuangXi[cityId]);
                                        break;
                                    case 20:
                                        select(county_spinner, county_adapter, countyOfHaiNan[cityId]);
                                        break;
                                    case 21:
                                        select(county_spinner, county_adapter, countyOfChongQing[cityId]);
                                        break;
                                    case 22:
                                        select(county_spinner, county_adapter, countyOfSiChuan[cityId]);
                                        break;
                                    case 23:
                                        select(county_spinner, county_adapter, countyOfGuiZhou[cityId]);
                                        break;
                                    case 24:
                                        select(county_spinner, county_adapter, countyOfYunNan[cityId]);
                                        break;
                                    case 25:
                                        select(county_spinner, county_adapter, countyOfXiZang[cityId]);
                                        break;
                                    case 26:
                                        select(county_spinner, county_adapter, countyOfShanXi2[cityId]);
                                        break;
                                    case 27:
                                        select(county_spinner, county_adapter, countyOfGanSu[cityId]);
                                        break;
                                    case 28:
                                        select(county_spinner, county_adapter, countyOfQingHai[cityId]);
                                        break;
                                    case 29:
                                        select(county_spinner, county_adapter, countyOfNingXia[cityId]);
                                        break;
                                    case 30:
                                        select(county_spinner, county_adapter, countyOfXinJiang[cityId]);
                                        break;
                                    case 31:
                                        select(county_spinner, county_adapter, countyOfHongKong[cityId]);
                                        break;
                                    case 32:
                                        select(county_spinner, county_adapter, countyOfAoMen[cityId]);
                                        break;
                                    case 33:
                                        select(county_spinner, county_adapter, countyOfTaiWan[cityId]);
                                        break;

                                    default:
                                        break;
                                }

                                county_spinner.setOnItemSelectedListener(new OnItemSelectedListener()
                                {

                                    @Override
                                    public void onItemSelected(
                                            AdapterView<?> arg0, View arg1,
                                            int arg2, long arg3) {
                                        strCounty = county_spinner.getSelectedItem().toString();
                                    }

                                    @Override
                                    public void onNothingSelected(
                                            AdapterView<?> arg0) {


                                    }

                                });
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> arg0) {
                            // TODO Auto-generated method stub

                        }

                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

    }

    private void select(Spinner spin, ArrayAdapter<CharSequence> adapter, int arry)
    {
        adapter = ArrayAdapter.createFromResource(this, arry, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        //spin.setSelection(0,true);
    }
}
