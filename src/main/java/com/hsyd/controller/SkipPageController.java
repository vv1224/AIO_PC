package com.hsyd.controller;

import org.apache.xpath.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by vie1224 on 2017/7/12.
 */
@Controller
public class SkipPageController {

    /**
     * 点击办卡跳页
     * @param modelAndView
     * @return
     */
    @RequestMapping("/toopencard")
    public Object toOpenCard(ModelAndView modelAndView){
        modelAndView.setViewName("patientInformation");
        return modelAndView;
    }

    @RequestMapping("toinputphone")
    public Object toInputPhone(ModelAndView modelAndView){
        modelAndView.setViewName("confirmInformation");
        return modelAndView;
    }

}
