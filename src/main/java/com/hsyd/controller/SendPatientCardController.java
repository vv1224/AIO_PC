package com.hsyd.controller;

import com.hsyd.Hospital.Hosipital;
import com.hsyd.annotation.UrlType;
import com.hsyd.model.Patient;
import com.hsyd.utils.CatchInterfaceUtil;
import com.hsyd.utils.CommonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Title : 发卡
 * Created by vie1224 on 2017/7/4.
 */
@Controller
public class SendPatientCardController {


    /**
     * 确认身份证信息
     * @param response
     */
    @RequestMapping("/returnidinformation")
    public void returnIdInformation(HttpServletResponse response){

        List<Patient> patientList = new ArrayList<Patient>();

        String message = null;

        Patient patient = new Patient();
        patient.setAddress("");
        patient.setBirthday("");
        patient.setIdCard(0);
        patient.setPatientName("");
        patient.setProvince("");
        patient.setSex(0);

        patientList.add(patient);

        message = "success";
        CommonUtils.JsonUtil(response,message,patientList,null);
    }

    /**
     * 分配就诊卡号
     * @param response
     * @param request
     * @param address
     * @param birthday
     * @param idCard
     * @param patientName
     * @param province
     * @param sex
     * @param phone
     */
    @RequestMapping("/inputphone")
    @UrlType(name="分配就诊卡")
    public Object inputPhone(HttpServletResponse response, HttpServletRequest request, @RequestParam("address")String address, @RequestParam("birthday")String birthday,
                           @RequestParam("idCard")String idCard, @RequestParam("patientName")String patientName,ModelAndView modelAndView,
                           @RequestParam("province")String province, @RequestParam("sex")String sex, @RequestParam("phone") String phone){

        String message = null;
        String type = "分配就诊卡";
        //通过session获取医院名称
        String hospitalName = (String) request.getSession().getAttribute("hospitalName");
        //请求体
        String postBody = "{ \"root\": {\n" +
                "\"PATIENT_NAME\":" + patientName + ",\n" +
                "\"SEX\":" + sex + ",\n" +
                "\"DATE_OF_BIRTH\":" + birthday + ",\n" +
                "\"AGE\":" + CommonUtils.getAge(birthday) + ",\n" +
                "\"ID_NO\":" + idCard + ",\n" +
                "\"ADDRESS\":" + address + ",\n" +
                "\"PHONE\":" + phone  +
                "} }";
        String cardNum = null;
        message = "success";
        try {
            cardNum = CatchInterfaceUtil.catchInterface(postBody, Hosipital.getUrl(hospitalName,type));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //CommonUtils.JsonUtil(response,message,cardNum);
        modelAndView.addObject("data",cardNum);
        modelAndView.setViewName("");
        return modelAndView;
    }

}
