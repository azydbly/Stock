package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.entity.Alcohol;
import com.entity.Varieties;
import com.service.AlcoholService;
import com.service.VarirtiesService;
import com.system.util.DataTables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @类描述：酒的控制层
 * @Author: xiaoshitou
 * @时间： 2018/6/20 17:12
 */

@Controller
public class AlcoholController {

    @Autowired
    HttpServletRequest request;// 请求

    @Autowired
    private AlcoholService alcoholService;

    @Autowired
    private VarirtiesService varirtiesService;

    Date date = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static final String LIST = "Warehouse/alcohol/list";
    public static final String ADD = "Warehouse/alcohol/add";
    public static final String EDIT = "Warehouse/alcohol/edit";


    //进入酒列表页面
    @RequestMapping("/showAlcohol.action")
    public String showAlcohol(){
        return LIST;
    }

    //分页显示所有酒
    @ResponseBody
    @RequestMapping(value = "/showPageAlcohol.action", produces = "application/json; charset=utf-8")
    public String showPageAlcohol(@RequestParam(value="state",required=false)String state){
        state = StringUtils.isEmpty(state) ? "" : ("state=" + state);
        return JSON.toJSONString(alcoholService.showPageAlcohol(DataTables.getInstance(request,state)));
    }

    //进入酒添加页面
    @RequestMapping("/addAlcohol.action")
    public String addAlcohol(){
        request.setAttribute("varietiesList",varirtiesService.selAllVarieties());
        return ADD;
    }

    @ResponseBody
    @RequestMapping(value = "/insertAlcohol.action", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String insertAlcohol(Alcohol alcohol){
        System.out.println("111111111111111111111");
        alcohol.setInsertdatetime(simpleDateFormat.format(date));
        alcohol.setUpdatedatetime(simpleDateFormat.format(date));
        return JSONObject.toJSONString(alcoholService.insertAlcohol(alcohol));
    }

}
