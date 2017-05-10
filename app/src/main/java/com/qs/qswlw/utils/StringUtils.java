package com.qs.qswlw.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dashen10 on 2015/6/24.
 */
public class StringUtils {
    private static PackageInfo sPackageInfo;
    public static Random random = new Random(100);

    /**
     *  最新号段手机号正则判断
     * @param mobiles
     * @return
     */
    public static final boolean isPhoneNum(String mobiles){
        Pattern p= Pattern.compile("^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8]))//d{8}$");
        Matcher m=p.matcher(mobiles);
        return m.matches();
    }

    /**
     * 字符串长度大于int a时保留前a个+...
     * @param string
     * @return
     */
    public static String cutString(String string, int limitNum){
        if (string.length()>limitNum){
            string=string.substring(0,limitNum)+"...";
        }
        return string;
    }
    /**
     * 车牌号格式：汉字 + A-Z + 5位A-Z或0-9（只包括了普通车牌号，教练车和部分部队车等车牌号不包括在内）正则表达式有局限性，比如第一位只限定是汉字，
     * 没限定只有34个省汉字缩写；车牌号不存在字母I和O，防止和1、0混淆；部分车牌无法分辨等等
     * @param carnumber
     * @return
     */
    public static boolean isCarnumberNO(String carnumber) {
        return !TextUtils.isEmpty(carnumber) && carnumber.matches("[\u4e00-\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}");
    }

    /**
     * 身份证号正则判断
     *
     * @param idNum
     * @return
     */
    public static boolean isIdNum(String idNum) {
        return !TextUtils.isEmpty(idNum) && idNum.matches("(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])");
    }

    /**
     * 判断是否为+86手机号码
     *
     * @param number
     * @return
     */
    public static boolean is86Num(String number) {
//        return !TextUtils.isEmpty(number) && number.matches("^((\\+{0,1}86){0,1})1[0-9]{10}");
        return !TextUtils.isEmpty(number) && number.matches("^[+][8][6][1][3-8]\\d{9}$");
    }
    /**
     * 判断是否为手机号码
     *
     * @param number
     * @return
     */
    public static boolean isMobilePhoneNumber(String number) {
        return !TextUtils.isEmpty(number) && number.matches("^[1][3-8]\\d{9}$");
    }

    public static String getRandom() {
        return random.nextInt() + "";
    }

    public static String getApkVersionName(Context context) {
        return getPackageInfo(context).versionName;
    }

    public synchronized static PackageInfo getPackageInfo(Context context) {
        if (sPackageInfo == null) {
            try {
                sPackageInfo = context.getPackageManager().getPackageInfo(
                        context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                assert false;
                return null;
            }
        }
        return sPackageInfo;
    }

    public static String encodeJson(JSONObject json) {
        return encodeJson(json, "utf-8");
    }

    public static String encodeJson(JSONObject json, String paramsEncoding) {
        try {
            StringBuilder encodedParams = new StringBuilder();
            Iterator<String> itr = json.keys();
            while (itr.hasNext()) {
                String key = itr.next();
                encodedParams.append(URLEncoder.encode(key, paramsEncoding));
                encodedParams.append('=');
                encodedParams.append(URLEncoder.encode(json.opt(key).toString(), paramsEncoding));
                encodedParams.append('&');
            }
            return encodedParams.toString();
        } catch (UnsupportedEncodingException uee) {
            throw new RuntimeException("Encoding not supported: " + paramsEncoding, uee);
        }
    }

    /**
     * 得到设备屏幕的宽度
     */
    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 得到设备屏幕的高度
     */
    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    /**
     * 得到设备的密度
     */
    public static float getScreenDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    /**
     * 把密度转换为像素
     */
    public static int dip2px(Context context, float px) {
        final float scale = getScreenDensity(context);
        return (int) (px * scale + 0.5);
    }

    /**
     * 网络是否可用
     *
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager mgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] info = mgr.getAllNetworkInfo();
        if (info != null) {
            for (int i = 0; i < info.length; i++) {
                if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Map<String, Object> PO2Map(Object o) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] fields = null;
        String clzName = o.getClass().getSimpleName();
        fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String proName = field.getName();
            Object proValue = field.get(o);
            map.put(proName, proValue);
        }
        return map;
    }
    /**
     * 判断某个服务是否正在运行的方法
     *
     * @param mContext
     * @param serviceName
     *            是包名+服务的类名（例如：net.loonggg.testbackstage.TestService）
     * @return true代表正在运行，false代表服务没有正在运行
     */
    public static boolean isServiceWork(Context mContext, String serviceName) {
        boolean isRunning = false;
        ActivityManager activityManager = (ActivityManager)
                mContext.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> serviceList
                = activityManager.getRunningServices(Integer.MAX_VALUE);
        if (!(serviceList.size()>0)) {
            return false;
        }
        for (int i=0; i<serviceList.size(); i++) {
            if (serviceList.get(i).service.getClassName().equals(serviceName)) {
                isRunning = true;
                break;
            }
        }
        return isRunning;
    }


    /**
     * 检测是否有emoji表情
     *
     * @param source
     * @return
     */
    public static String containsEmoji(String source) {
        int len = source.length();
        String save = "";
        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);
            if (!isEmojiCharacter(codePoint)) { // 如果不能匹配,则该字符是Emoji表情
                save+="";
            }else {
                save+=source.charAt(i);
            }
        }
        String s=save;
        return save;
    }

    /**
     * 判断是否是Emoji
     *
     * @param codePoint
     *            比较的单个字符
     * @return
     */
    public static boolean isEmojiCharacter(char codePoint) {
        return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA) || (codePoint == 0xD)
                || ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
                || ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
    }
}
