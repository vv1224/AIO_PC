package com.hsyd.Test;

import org.junit.Test;
import org.xvolks.jnative.JNative;
import org.xvolks.jnative.exceptions.NativeException;

/**
 * Created by kongy on 2017/8/29.
 */
public class TestCard {

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

    }
}
