package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @类描述：酒的控制层
 * @Author: xiaoshitou
 * @时间： 2018/6/20 17:12
 */

@Controller
public class AlcoholController {

    @Autowired
    HttpServletRequest request;// 请求

    public static final String LIST = "Warehouse/alcohol/list";
    public static final String ADD = "Warehouse/alcohol/add";
    public static final String EDIT = "Warehouse/alcohol/edit";


    //进入酒列表页面
    @RequestMapping("/showAlcohol.action")
    public String showAlcohol(){
        return LIST;
    }
}
