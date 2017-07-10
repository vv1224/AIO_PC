package com.hsyd.Hospital;

import com.hsyd.annotation.UrlType;
import com.hsyd.controller.SendPatientCardController;
import com.hsyd.utils.CommonUtils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vie1224 on 2017/7/7.
 */
public class Hosipital {

    //private static SendPatientCardController sendPatientCardController = new SendPatientCardController();
    /**
     * 获取医院的url
     * @param hospitalName
     * @return
     */
    public static String getUrl(String hospitalName,String type){
        /*List<Method> list = Arrays.asList(sendPatientCardController.getClass().getDeclaredMethods());
        for(int i=0;i<list.size();i++){
            Method field = list.get(i);
            if(field.isAnnotationPresent(UrlType.class)){//是否使用UrlType注解
                String a = field.getAnnotation(UrlType.class).name();
            }*/
        String url = null;
        if("华美医院".equals(hospitalName)){
            if("分配就诊卡".equals(type)) {
                url = "http://124.42.117.50:12002/httphub?PRODUCER_SYSCODE=HS1000003&SERVICE_CODE=HS_S_A04&CONSUMER_SYSCODE=HS0001&MESSAGE_ID=" + CommonUtils.getUUID() + "&DTSEND=" + CommonUtils.getTimeStamps() + "&VERSION=1";
            }else if("查询科室".equals(type)){
                url = "http://124.42.117.50:12002/httphub?PRODUCER_SYSCODE=HS0000002&SERVICE_CODE=HS_S_B01&CONSUMER_SYSCODE=HS0001&MESSAGE_ID=" + CommonUtils.getUUID() + "&DTSEND=" + CommonUtils.getTimeStamps() + "&VERSION=1";
            }
        }
        return url;
    }
}
