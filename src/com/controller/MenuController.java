package com.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.entity.Employee;
import com.entity.Menu;
import com.service.MenuService;
import com.system.util.DataTables;

@Controller
public class MenuController {
	
	@Autowired
	HttpServletRequest request;// 请求
	
	@Autowired
	private MenuService menuService;
	

    public static final String LIST = "system/menu/list";
    public static final String ADD = "system/menu/add";
    public static final String EDIT = "system/menu/edit";


	//进入显示菜单页面
	@RequestMapping("/showMenu.action")
	public String selAllLikePage(){
		return LIST;
	}

	//分页显示所有菜单
	@ResponseBody
	@RequestMapping(value = "/showPageMenu.action", produces = "application/json; charset=utf-8")
	public String showPageMenu(@RequestParam(value="state",required=false)String state){
		state = StringUtils.isEmpty(state) ? "" : ("state=" + state);
		return JSON.toJSONString(menuService.getPageMenuList(DataTables.getInstance(request,state)));
	}
	
	
	//进入添加菜单页面  add.jsp
	//查询pid=0的顶级菜单，在添加时每一个顶级菜单都会从数据库中被查出来放到添加页面
	@RequestMapping("/selPid.action")
	public String selPid(HttpServletRequest request){
		List<Menu> menuList = menuService.selPid();
		request.setAttribute("menuList", menuList);
		return ADD;

	}

    //添加菜单
    @ResponseBody
    @RequestMapping(value = "/insertMenu.action", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String insertMenu(Menu menu){
        return JSONObject.toJSONString(menuService.insertMenu(menu));
    }


	//进入修改菜单页面  edit.jsp
	@RequestMapping("/selMenuById.action")
	public String selMenuById(int id){
		//修改时用的menu,查询所有顶级菜单
		request.setAttribute("menuList", menuService.selPid());
		request.setAttribute("menu", menuService.selMenuById(id));
		return EDIT;
	}
	
	
	//修改菜单
	@ResponseBody
	@RequestMapping(value = "/updMenu.action", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String updMenu(Menu menu){
		return JSONObject.toJSONString(menuService.updateMenu(menu));
	}
	
	
	//更新菜单状态
	@ResponseBody
	@RequestMapping(value = "/updMenuState.action", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String updMenuState(int id,int flag){
		Menu m = new Menu();
		m.setState(flag);
		m.setId(id);
		return JSONObject.toJSONString(menuService.updateMenuState(m));
	}
	
	
	//menu名称重复验证
	@RequestMapping("/selMenu.action")
	public void selMenu(HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String menuname = request.getParameter("menuname");
		String id = request.getParameter("id");
		if(id == null){
			Menu menu = menuService.selMenuByAdd(menuname);
			if(menu == null){
				response.getWriter().print("true");
			}else{
				response.getWriter().print("false");
			}
		}else{
			Menu menu = menuService.selMenu(menuname,Integer.valueOf(id));
			if(menu == null){
				response.getWriter().print("true");
			}else{
				response.getWriter().print("false");
			}
		}
	}
	
	
	//url重复验证
	@RequestMapping("/selUrl.action")
	public void selUrl(HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String url = request.getParameter("url");
		String id = request.getParameter("id");
		if(id == null){
			Menu menu = menuService.selUrlByAdd(url);
			if(menu == null){
				response.getWriter().print("true");
			}else{
				response.getWriter().print("false");
			}
		}else{
			Menu menu = menuService.selUrl(url,Integer.valueOf(id));
			if(menu == null){
				response.getWriter().print("true");
			}else{
				response.getWriter().print("false");
			}
		}
	}

    //删除菜单（单条、多条）
    @ResponseBody
    @RequestMapping(value = "/delMenu.action", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String delMenu(@RequestParam("idlist[]") List<Integer> idlist){
        return JSONObject.toJSONString(menuService.delMenu(idlist));
    }
	
	//登录时查询所有菜单用于left页面的菜单分类   selectSubMenus
	@RequestMapping("/index.action")
	public String selectSubMenus(HttpSession session,HttpServletRequest request){
		request.setAttribute("subMenuList", menuService.selectLoginMenus());
		Date date = new Date();
		session.setAttribute("date",date);
		return "index";
	}
}
