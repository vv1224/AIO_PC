package com.hsyd.utils;

import net.sf.json.JSONObject;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Title : 常用工具类封装
 * Created by vie1224 on 2017/7/4.
 */
public class CommonUtils {

    /**
     * json封装类
     * @param response
     * @param message
     * @param list
     * @param obj
     */
    public static void JsonUtil(HttpServletResponse response, String message, List<?> list, Object obj){

        PrintWriter out;
        response.setContentType("text/html; charset=UTF-8");

        try {
            out = response.getWriter();
            JSONObject resultJSON = new JSONObject();
            if(list != null){
                resultJSON.put("" + list, list);
            }
            if(obj != null){
                resultJSON.put("" + obj, obj);
            }
            resultJSON.put("message", message);
            out.println(resultJSON.toString());
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Json重载方法
     * @param response
     * @param message
     * @param str
     */
    public static void JsonUtil(HttpServletResponse response, String message, String str){

        PrintWriter out;
        response.setContentType("text/html; charset=UTF-8");

        try {
            out = response.getWriter();
            JSONObject resultJSON = new JSONObject();
            resultJSON.put("message", message);
            resultJSON.put("" + str,str);
            out.println(resultJSON.toString());
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取精确到秒的时间戳
    public static String getTimeStamps(){

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        String a = simpleDateFormat.format(date);
        String newb = "";
        String [] b = a.split("-");

        for (int i = 0; i < b.length; i++){
            newb += b[i];
        }
        String[] c = newb.split(":");
        String newc = "";
        for(int i = 0; i < c.length; i++){
            newc += c[i];
        }
        return newc.trim();
    }

    //获得精确到天的起始时间戳
    public static String getTimeStampsDay(){

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String a = simpleDateFormat.format(date);
        return a;
    }

    //获得精确到天的结束时间戳（20天）
    public static String getEndTimeStampsDay(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String firstWeekEnd = simpleDateFormat.format(new Date(date.getTime() + (long)14 * 24 * 60 * 60 * 1000));
        return firstWeekEnd;
    }

    /**
     * 获取uuid
     * @return
     */
    public static UUID getUUID(){
            UUID uuid = UUID.randomUUID();
            return uuid;
    }

    /**
     * 获取年龄
     * @param birthday  字符标准：XXXX-XX-XX
     * @return
     */
    public static String getAge(String birthday){
        String age = String.valueOf((Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(birthday.substring(0,4))));
        return age;
    }

}
