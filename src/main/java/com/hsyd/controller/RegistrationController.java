package com.hsyd.controller;

import com.hsyd.Hospital.Hosipital;
import com.hsyd.utils.CatchInterfaceUtil;
import com.hsyd.utils.CommonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
     * @param response
     */
    @RequestMapping("/selectOffice")
    public void selectOffice(@RequestParam("cardNum")String cardNum, HttpServletRequest request,
                             HttpServletResponse response){

        String message = null;
        String type = "查询科室";
        String data = null;
        String hospitalName = (String) request.getSession().getAttribute("hospitalName");
        try {
           data = CatchInterfaceUtil.catchInterface("", Hosipital.getUrl(hospitalName,type));
        } catch (IOException e) {
            e.printStackTrace();
        }
        message = "success";
        CommonUtils.JsonUtil(response,message,data);
    }

    @RequestMapping("selectregistrationtype")
    public void selectRegistrationType(HttpServletResponse response,HttpServletRequest request){

    }

}
