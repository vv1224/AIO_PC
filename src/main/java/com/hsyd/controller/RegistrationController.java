package com.hsyd.controller;

import com.hsyd.Hospital.Hosipital;
import com.hsyd.utils.CatchInterfaceUtil;
import com.hsyd.utils.CommonUtils;
import com.sun.deploy.net.HttpResponse;
import org.apache.xpath.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Title : 挂号
 * Created by vie1224 on 2017/7/6.
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    /**
     * 显示科室
     * @param cardNum
     * @param request
     */
    @RequestMapping("/selectOffice")
    public void selectOffice(@RequestParam("cardNum")String cardNum, HttpServletRequest request,ModelAndView modelAndView){

        String type = "查询科室";
        String data = null;
        String hospitalName = (String) request.getSession().getAttribute("hospitalName");
        try {
           data = CatchInterfaceUtil.catchInterface("", Hosipital.getUrl(hospitalName,type));
        } catch (IOException e) {
            e.printStackTrace();
        }
        modelAndView.addObject("data",data);
        modelAndView.setViewName("");
    }

    /*@RequestMapping("selectregistrationtype")
    public void selectRegistrationType(HttpServletResponse response,HttpServletRequest request){

    }*/

    /**
     * 选择医师列表
     * @param request
     * @param modelAndView
     */
    @RequestMapping("/checkdoctor")
    public void checkDoctor(HttpServletRequest request, ModelAndView modelAndView){

        String type = "选择医师";
        String data = null;
        String hospitalName = (String) request.getSession().getAttribute("hospitalName");
        try {
            data = CatchInterfaceUtil.catchInterface("", Hosipital.getUrl(hospitalName,type));
        } catch (IOException e) {
            e.printStackTrace();
        }
        modelAndView.addObject("data",data);
        modelAndView.setViewName("");
    }

    /**
     * 选择排班
     * @param request
     * @param modelAndView
     * @param DEPT_ID
     * @param DOCTOR_ID
     */
    @RequestMapping("/checkTime")
    public void checkTime(HttpServletRequest request, ModelAndView modelAndView,
                          @RequestParam("DEPT_ID") String DEPT_ID, @RequestParam("DOCTOR_ID") String DOCTOR_ID){

        String type = "选择排班";
        String data = null;
        String hospitalName = (String) request.getSession().getAttribute("hospitalName");
        String START_DATE = CommonUtils.getTimeStampsDay().replace("-","/");
        String END_DATE = CommonUtils.getEndTimeStampsDay().replace("-","/");
        String postBody = "{ \"root\": {\n" +
                "\"START_DATE\":" + START_DATE + ",\n" +
                "\"END_DATE\":" + END_DATE + ",\n" +
                "\"DEPT_ID\":" + DEPT_ID + ",\n" +
                "\"DOCTOR_ID\":" + DOCTOR_ID +
                "} }";
        try {
            data = CatchInterfaceUtil.catchInterface(postBody, Hosipital.getUrl(hospitalName,type));
        } catch (IOException e) {
            e.printStackTrace();
        }
        modelAndView.addObject("data",data);
        modelAndView.setViewName("");
    }

    /**
     * 确认挂号信息
     * @param request
     * @param PATIENT_NAME
     * @param modelAndView
     * @param ID_NO
     * @param registrationList
     */
    @RequestMapping("/confirmRegistrationinfo")
    public void confirmRegistrationInfo(HttpServletRequest request, @RequestParam("PATIENT_NAME") String PATIENT_NAME,ModelAndView modelAndView,
                                        @RequestParam("ID_NO") String ID_NO, @RequestParam("registrationList") String registrationList){

        String type = "查询就诊卡";
        String data = null;
        String hospitalName = (String) request.getSession().getAttribute("hospitalName");
        String postBody = "{ \"root\": {\n" +
                "\"PATIENT_NAME\":" + PATIENT_NAME + ",\n" +
                "\"ID_NO\":" + ID_NO +
                "} }";
        try {
            data = CatchInterfaceUtil.catchInterface(postBody, Hosipital.getUrl(hospitalName,type));
        } catch (IOException e) {
            e.printStackTrace();
        }

        modelAndView.addObject("data",data);
        modelAndView.addObject("registrationList",registrationList);
        modelAndView.setViewName("");

    }

}
