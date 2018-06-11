package com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.entity.Employee;
import com.google.gson.Gson;
import com.service.EmployeeService;
import com.service.MenuService;
import com.system.util.DataTables;
import com.system.util.MD5Util;
@Controller
public class EmployeeController {
	
	@Autowired
	HttpServletRequest request;// 请求

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private MenuService menuService;

	public static final String LIST = "system/user/list";
	public static final String ADD = "system/user/add";
	public static final String EDIT = "system/user/edit";
	public static final String VIEW = "system/user/view";
	public static final String RESET = "system/user/reset";


	/**
	 * 修订
	 *
	 * @return
	 */
	//进入用户列表页面
	@RequestMapping("/showEmp.action")
	public String selAllEmployee(){
		return LIST;
	}

	//分页显示所有用户
	@ResponseBody
	@RequestMapping(value = "/showPageEmployee.action", produces = "application/json; charset=utf-8")
	public String showPageMenu(){
		return JSON.toJSONString(employeeService.getPageEmployeeList(DataTables.getInstance(request)));
	}
	
	
	//进入添加用户页面
	@RequestMapping("/toIns.action")
	public String toInsertPage(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		request.setAttribute("createDate", sdf.format(date));
		return ADD;
	}
	
	//新增用户
	@ResponseBody
	@RequestMapping(value = "/insEmp.action", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String insEmp(Employee employee){
		employee.setLoginPassword(MD5Util.string2MD5(employee.getLoginPassword()));
		return JSON.toJSONString(employeeService.insEmployee(employee));
	}	
	
	
	//页面修改用户页面
	@RequestMapping("/toUpdEmpPage.action")
	public String toUpdPage(int id){
		request.setAttribute("user", employeeService.selById(id));
		return EDIT;
	}
	
	//修改用户
	@ResponseBody
	@RequestMapping(value = "/updateEmployee.action",method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String updEmp(Employee employee){
		return JSON.toJSONString(employeeService.updEmployee(employee));
	}
	
	//删除用户（单条、多条）
	@ResponseBody
	@RequestMapping(value = "/delEmps.action", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String delEmps(@RequestParam("idlist[]") List<Integer> idlist){
		return JSON.toJSONString(employeeService.delEmployees(idlist));
	}
	
			
	//跳转到单个用户查看页面
	@RequestMapping("viewEmployee.action")
	public String toViewPage(int id){
		Employee user = employeeService.selById(id);
		request.setAttribute("user", user);
		return VIEW;
	}
	
	//查询出除去当前用户的用户名之外的用户名，更改用户信息时使用，如果更改的当前用户名没有更改则显示成功
	@RequestMapping("/showLoginName.action")
	public void selectloginName(HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		if(request.getParameter("id") == null){
			Employee employee = employeeService.selectAllName(request.getParameter("loginName"));
			if(employee == null){
				response.getWriter().print("true");
			}else{
				response.getWriter().print("false");
			}
		}else{
			Employee employee = employeeService.selectAllNameUpdate(request.getParameter("loginName"),Integer.valueOf(request.getParameter("employeeNum")));
			if(employee == null){
				response.getWriter().print("true");
			}else{
				response.getWriter().print("false");
			}
		}
	}
	
	
	//邮箱找回密码时验证用户名是否存在
	@RequestMapping("/showForgotName.action")
	public void showForgotName(HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Employee employee = employeeService.selectAllName(request.getParameter("loginName"));
		if(employee == null){
			response.getWriter().print("false");
		}else{
			response.getWriter().print("true");
		}
	}
	
	//邮箱找回密码时根据用户名检查邮箱是否正确
	@RequestMapping("/showForgotEmail.action")
	public void showForgotEmail(HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		if(request.getParameter("loginName") != null && request.getParameter("loginName") != ""){
			Employee employee = employeeService.selectAllName(request.getParameter("loginName"));
			if(request.getParameter("email").equals(employee.getEmail())){
				response.getWriter().print("true");
			}else{
				response.getWriter().print("false");
			}
		}
	}
	
	
	//更改员工状态
	@ResponseBody
	@RequestMapping(value = "/updateEmployeeState.action", method=RequestMethod.POST, produces="appliction/json; charset=utf-8")
	public String updateEmployeeState(int flag,int id){
		return JSON.toJSONString(employeeService.updateEmployeeState(flag, id));
	}
	

	
	// 根据员工编码查询身证号
	@ResponseBody
	@RequestMapping("/selectEmployeeByRname.action")
	public Employee selectEmployeeByRname(String employeeNum) {
		Employee e = employeeService.selById(Integer.valueOf(employeeNum));
		return e;
	}
	
	//重置管理员密码
	@RequestMapping("/resetPassword.action")
	public String resetPassword(int id){
		request.setAttribute("resetPwd",employeeService.selById(id));
		return RESET;
	}

    //更改密码
    @ResponseBody
    @RequestMapping(value = "/updEmployeeByReset.action", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String updatePasswordByReset(){
        return JSON.toJSONString(employeeService.updatePasswordById(MD5Util.string2MD5(request.getParameter("againPassword")), Integer.valueOf(request.getParameter("id"))));
    }
	
}
