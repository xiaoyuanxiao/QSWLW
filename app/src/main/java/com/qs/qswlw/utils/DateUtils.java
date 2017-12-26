package com.qs.qswlw.utils;

import android.util.Log;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by dashen10 on 2015/8/10.
 */
public class DateUtils {
    public static final String ENG_DATE_FROMAT = "EEE, d MMM yyyy HH:mm:ss z";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY = "yyyy";
    public static final String MM = "MM";
    public static final String DD = "dd";
    public static final String HHMM = "HH:MM";

    /**
     * @return
     * @创建日期 2012-7-13
     * @创建时间 下午12:22:40
     * @描述 —— 转为时间
     */
    public static String date2date(long str) {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
        Date date = new Date(str);
        return sdf.format(date);
    }

    public static String long2date(long str) {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        Date date = new Date(str);
        return sdf.format(date);
    }
    public static String long2datetime(long str) {
        SimpleDateFormat sdf = new SimpleDateFormat(HHMM);
        Date date = new Date(str);
        return sdf.format(date);
    }
    /**
     * @param date
     * @return
     * @创建日期 2012-7-13
     * @创建时间 下午12:24:19
     * @描述 —— 时间对象转换成字符串
     */
    public static String date2string(Date date, String formatStr) {
        String strDate = "";
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        strDate = sdf.format(date);
        return strDate;
    }

    /**
     * @param timestamp
     * @return
     * @创建日期 2012-7-13
     * @创建时间 下午12:24:19
     * @描述 —— sql时间对象转换成字符串
     */
    public static String timestamp2string(Timestamp timestamp, String formatStr) {
        String strDate = "";
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        strDate = sdf.format(timestamp);
        return strDate;
    }

    /**
     * @param dateString
     * @param formatStr
     * @return
     * @创建日期 2012-7-13
     * @创建时间 下午1:09:24
     * @描述 —— 字符串转换成时间对象
     */
    public static Date string2date(String dateString, String formatStr) {
        Date formateDate = null;
        DateFormat format = new SimpleDateFormat(formatStr);
        try {
            formateDate = format.parse(dateString);
        } catch (ParseException e) {
            return null;
        }
        return formateDate;
    }

    /**
     * @param date
     * @return
     * @创建日期 2012-10-10
     * @创建时间 上午09:18:36
     * @描述 —— Date类型转换为Timestamp类型
     */
    public static Timestamp date2timestamp(Date date) {
        if (date == null)
            return null;
        return new Timestamp(date.getTime());
    }

    public static long date2times(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
        long millionSeconds = 0;//毫秒
        try {
            millionSeconds = sdf.parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return millionSeconds;
    }

    /**
     * @return
     * @创建日期 2012-9-13
     * @创建时间 下午05:02:57
     * @描述 —— 获得当前年份
     */
    public static String getNowYear() {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY);
        return sdf.format(new Date());
    }

    /**
     * @return
     * @作者 王建明
     * @创建日期 2012-9-13
     * @创建时间 下午05:03:15
     * @描述 —— 获得当前月份
     */
    public static String getNowMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat(MM);
        return sdf.format(new Date());
    }

    /**
     * @return
     * @创建日期 2013-01-24
     * @创建时间 08:41:47
     * @描述 —— 获得当前日期中的日
     */
    public static String getNowDay() {
        SimpleDateFormat sdf = new SimpleDateFormat(DD);
        return sdf.format(new Date());
    }

    /**
     * @param time
     * @return
     * @作者 王建明
     * @创建日期 2012-6-17
     * @创建时间 上午10:19:31
     * @描述 —— 指定时间距离当前时间的中文信息
     */
    public static String getLnow(long time) {
        Calendar cal = Calendar.getInstance();
        long timel = cal.getTimeInMillis() - time;
        if (timel / 1000 < 60) {
            return "1分钟以内";
        } else if (timel / 1000 / 60 < 60) {
            return timel / 1000 / 60 + "分钟前";
        } else if (timel / 1000 / 60 / 60 < 24) {
            return timel / 1000 / 60 / 60 + "小时前";
        } else {
            return timel / 1000 / 60 / 60 / 24 + "天前";
        }
    }

    /**
     * String 转 Date
     * 2015年3月25日上午11:27:14
     * auther:shijing
     *
     * @param str    日期字符串
     * @param format 转换格式
     * @return Date
     */
    public static Date stringToDate(String str, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = dateFormat.parse(str);
        } catch (ParseException e) {
            Log.e("String类型 转 Date类型出错：", e + "");
        }
        return date;
    }

    /**
     * Date 转 String
     * auther: shijing
     * 2015年3月25日上午11:28:14
     *
     * @param date   日期
     * @param format 转换格式
     * @return
     */
    public static String dateToString(Date date, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        String strDate = null;
        try {
            if (date != null) {
                strDate = dateFormat.format(date);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            Log.e("Date类型 转 String类型出错：", e + "");
        }
        return strDate;
    }


    /*
     * 将时间转换为时间戳 为什么你要系额两个逸雅阁的
     * 我说了格式不同啊 SimpleDateFormat("yyyy-MM-dd") 这里面的
     */
    public static String dateToStamp2(long s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(s);
        return simpleDateFormat.format(date);
    }

    /*
    * 将时间戳转换为时间
    */
    public static String stampToDate(long s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(s);
        return simpleDateFormat.format(date);
    }

    /*
  * 将时间戳转换为时间
  */
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }


    /*
   * 将时间转换为时间戳
   */
    public static String dateToStamp(String s) throws ParseException{
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }
}
