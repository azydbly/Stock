package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.entity.Varieties;
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

@Controller
public class VarietiesController {
	
	@Autowired
	HttpServletRequest request;// 请求
	
	@Autowired
	private VarirtiesService varirtiesService;


    public static final String LIST = "Warehouse/varieties/list";
    public static final String ADD = "Warehouse/varieties/add";
    public static final String EDIT = "Warehouse/varieties/edit";


	//进入显示种类页面
	@RequestMapping("/showVarieties.action")
	public String showVarieties(){
		return LIST;
	}

	//分页显示所有种类
	@ResponseBody
	@RequestMapping(value = "/showPageVarieties.action", produces = "application/json; charset=utf-8")
	public String showPageVarieties(@RequestParam(value="state",required=false)String state){
		state = StringUtils.isEmpty(state) ? "" : ("state=" + state);
		return JSON.toJSONString(varirtiesService.getPageVarietiesList(DataTables.getInstance(request,state)));
	}

    //进入添加种类页面
    @RequestMapping("/addVarieties.action")
    public String addVarieties(){
        return ADD;
    }


    @ResponseBody
    @RequestMapping(value = "/insertVarieties.action", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String insertVarieties(Varieties varieties){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    varieties.setInsertdatetime(simpleDateFormat.format(date));
	    varieties.setUpdatedatetime(simpleDateFormat.format(date));
        return JSONObject.toJSONString(varirtiesService.insertVarieties(varieties));
    }

    //更新种类状态
    @ResponseBody
    @RequestMapping(value = "/updVarietiesState.action", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String updVarietiesState(int id,int flag){
        Varieties Varieties = new Varieties();
        Varieties.setState(flag);
        Varieties.setId(id);
        return JSONObject.toJSONString(varirtiesService.updateVarietiesState(Varieties));
    }

    //进入修改种类页面
    @RequestMapping("/selVarietiesById.action")
    public String selVarietiesById(int id){
        request.setAttribute("varietiesList", varirtiesService.selVarietiesById(id));
        return EDIT;
    }

	

}
