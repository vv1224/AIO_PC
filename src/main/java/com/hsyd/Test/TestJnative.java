package com.hsyd.Test;

import org.junit.Test;
import org.xvolks.jnative.JNative;
import org.xvolks.jnative.Type;
import org.xvolks.jnative.exceptions.NativeException;

/**
 * 身份证驱动调用
 * Created by kongy on 2017/8/17.
 */
public class TestJnative {

    @Test
    public void testDll() throws NativeException {

        JNative.setLoggingEnabled(true);
        /**
         * 打开成功
         */
        /*try {
            JNative getUrl = new JNative("sdtapi.dll", "SDT_OpenPort"); //创建 getl 方法的<span style="font-family: Arial, Helvetica, sans-serif;">JNative对象</span>
            getUrl.setRetVal(Type.INT); //设置返回值类型为：String
            getUrl.setParameter(0, 1001); //按顺序设置方法需要的参数值
            getUrl.invoke(); //调用方法
            System.out.println(getUrl.getRetVal()); //输出返回值
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }*/

        /**
         * 找卡成功
         */
        try {
            JNative getUrl = new JNative("sdtapi.dll", "SDT_StartFindIDCard"); //创建 getl 方法的<span style="font-family: Arial, Helvetica, sans-serif;">JNative对象</span>
            getUrl.setRetVal(Type.INT); //设置返回值类型为：String
            getUrl.setParameter(0, 1001); //按顺序设置方法需要的参数值
            getUrl.setParameter(1,"4");
            getUrl.setParameter(2,1);
            getUrl.invoke(); //调用方法
            System.out.println(getUrl.getRetVal()); //输出返回值
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        /**
         * 选取身份证成功
         */
        try {
            JNative getUrl = new JNative("sdtapi.dll", "SDT_SelectIDCard"); //创建 getl 方法的<span style="font-family: Arial, Helvetica, sans-serif;">JNative对象</span>
            getUrl.setRetVal(Type.INT); //设置返回值类型为：String
            getUrl.setParameter(0, 1001); //按顺序设置方法需要的参数值
            getUrl.setParameter(1,"4");
            getUrl.setParameter(2,1);
            getUrl.invoke(); //调用方法
            System.out.println(getUrl.getRetVal()); //输出返回值
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

       /* try {
            JNative getUrl = new JNative("sdtapi.dll", "SDT_ReadBaseMsg"); //创建 getl 方法的<span style="font-family: Arial, Helvetica, sans-serif;">JNative对象</span>
            getUrl.setRetVal(Type.INT); //设置返回值类型为：String
            getUrl.setParameter(0, 1001); //按顺序设置方法需要的参数值
            getUrl.setParameter(1,"1024");
            getUrl.setParameter(2,64);
            getUrl.setParameter(3,"2048");
            getUrl.setParameter(4,256);
            getUrl.setParameter(5,1);
            getUrl.invoke(); //调用方法
            System.out.println(getUrl.getRetVal()); //输出返回值
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }*/

        try {
            JNative getUrl = new JNative("sdtapi.dll", "SDT_ReadBaseMsgToFile"); //创建 getl 方法的<span style="font-family: Arial, Helvetica, sans-serif;">JNative对象</span>
            getUrl.setRetVal(Type.INT); //设置返回值类型为：String
            getUrl.setParameter(0, 1001); //按顺序设置方法需要的参数值
            getUrl.setParameter(1,"D:\\aa\\a.txt");
            getUrl.setParameter(2,64);
            getUrl.setParameter(3,"D:\\aa\\b");
            getUrl.setParameter(4,2048);
            getUrl.setParameter(5,1);
            getUrl.invoke(); //调用方法
            System.out.println(getUrl.getRetVal()); //输出返回值
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

}
