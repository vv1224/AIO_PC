package com.hsyd.Test;

import com.hsyd.annotation.UrlType;
import com.hsyd.controller.SendPatientCardController;
import org.junit.Test;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by vie1224 on 2017/7/4.
 */
public class TestClass{

    SendPatientCardController sendPatientCardController = new SendPatientCardController();

    @Test
    public void testAnnotation(Object obj){
        List<Method> list = Arrays.asList(sendPatientCardController.getClass().getDeclaredMethods());
        for(int i=0;i<list.size();i++){
            Method field = list.get(i);
            if(field.isAnnotationPresent(UrlType.class)){//是否使用UrlType注解
                System.out.print(field.getAnnotation(UrlType.class).name());
            }
        }
    }

    @Test
    public void testReflect(){
        Class clazz = null;
        try {
            clazz = Class.forName("com.hsyd.Hospital.HuaMei");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String[] methodNames = null;
        Method[] methods = clazz.getDeclaredMethods();
        for (int i = 0; i<methods.length; i++){
            methodNames = methods[i].toString().split("\\.");
            String getMethodName = methodNames[methodNames.length-1];
            String finallyName = getMethodName.substring(0, getMethodName.length() - 2);
            System.out.print(finallyName);
        }
    }

    @Test
    public void testUUID(){
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
    }

    @Test
    public void testMillion() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        String a = simpleDateFormat.format(date);
        System.out.println(a);
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
        System.out.print(newc.trim());
    }
}
