package com.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Employee;
import com.service.EmployeeService;
import com.system.util.MD5Util;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

@Controller
public class LoginController {
	
	@Autowired
	HttpServletRequest request;// 请求

	@Autowired
	private EmployeeService employeeService;


	//登录系统
	@RequestMapping("/login.action")
	public String login(HttpSession session,String loginName, String loginPassword) throws Exception{
		String password = MD5Util.string2MD5(loginPassword);
		Employee employee = employeeService.login(loginName, password);
		if (employee == null) {
			request.setAttribute("messagePassword", "账号或密码错误");
			request.setAttribute("loginName", loginName);
			return "forward:/login.jsp";
		} else {
			session.setAttribute("employee", employee);
			return "redirect:/index.action";
		}
	}

	
	// 通过id查询密码
	@RequestMapping("/selPasswordById.action")
	public void selPasswordById(HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String oldpassword = request.getParameter("oldpassword");
		String id = request.getParameter("id");
		String Password = employeeService.selById(Integer.valueOf(id)).getLoginPassword();
		if (Password.equals(MD5Util.string2MD5(oldpassword))) {
			response.getWriter().print("true");
		}else{
			response.getWriter().print("false");
		}
	}
	
	//更该个人信息（资料，密码，头像）
	@RequestMapping("/updEmployeeById.action")
	public void updatePasswordById(Employee employee, int id, String newPassword, MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String prefix = "/WEB-INF/site/";
		
		Employee e = (Employee)request.getSession().getAttribute("employee");
		
		//更改密码
		if(!"".equals(newPassword) && "".equals(request.getParameter("uploadfile")) && e.getLoginName().equals(employee.getLoginName()) && e.getTelphone().equals(employee.getTelphone()) && e.getEmail().equals(employee.getEmail())){
			employeeService.updatePasswordByPersonal(MD5Util.string2MD5(newPassword), id);
			// 销毁session
			request.getSession().invalidate();
			response.getWriter().print("passwordtrue");
		//更改个人信息
		}else if("".equals(request.getParameter("uploadfile")) && "".equals(newPassword) && (!e.getLoginName().equals(employee.getLoginName()) || !e.getTelphone().equals(employee.getTelphone()) || !e.getEmail().equals(employee.getEmail()) || !employee.getRemark().equals(e.getRemark()))){
		    int a = employeeService.updEmployeeByIdNoFile(employee);
			Employee employee1 = employeeService.selById(Integer.valueOf(employee.getId()));
			request.getSession().setAttribute("employee", employee1);
			response.getWriter().print("true");
		//更改头像
		}else if(!"".equals(request.getParameter("uploadfile")) && "".equals(newPassword) && e.getLoginName().equals(employee.getLoginName()) && e.getTelphone().equals(employee.getTelphone()) && e.getEmail().equals(employee.getEmail()) && e.getRemark().equals(employee.getRemark())){
			//旧的头像名称
			String url = employeeService.selById(Integer.valueOf(((Employee) request.getSession().getAttribute("employee")).getId())).getUrl();
			if(!"".equals(url) || url != null){
				String oldPathName = request.getSession().getServletContext().getRealPath(prefix + "upload/picture");
				if("" != url && url != null){
					File oldf = new File(oldPathName,url);//删除旧的头像
					oldf.delete();
				}
			}
			//判断上传的头像是否为空
			if (!"".equals(request.getParameter("uploadfile"))) {
				//上传路径
				String pathName = request.getSession().getServletContext().getRealPath(prefix + "upload/picture");
				File path = new File(pathName);
				// 如果目录不存在，则创建该目录!
				if (!path.exists()) {
					path.mkdirs();
				}
				String fileName = UUID.randomUUID().toString() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
				// 创建新文件的对象
				File newFile = new File(path, fileName);
				file.transferTo(newFile);
				
				employee.setUrl(fileName);
			}
			employeeService.updEmployeeById(employee);
			Employee employee1 = employeeService.selById(Integer.valueOf(employee.getId()));
			String photo = prefix + "upload/picture/" +  employee1.getUrl();
			request.getSession().setAttribute("employee", employee1);
			request.getSession().setAttribute("photo", photo);
			
			response.getWriter().print("true");
		}else if("".equals(request.getParameter("uploadfile")) && "".equals(newPassword) && e.getLoginName().equals(employee.getLoginName()) && e.getTelphone().equals(employee.getTelphone()) && e.getEmail().equals(employee.getEmail()) && e.getRemark().equals(employee.getRemark())){
			response.getWriter().print("no");
		}else{
			response.getWriter().print("false");
		}
	}

	// 退出系统
	@RequestMapping("/quit.action")
	public void quit(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 销毁session
		request.getSession().invalidate();
		response.getWriter().print("true");
	}


	//显示主页
	@RequestMapping("/welcome.action")
	public String welcome(){
		return "welcome";
	}

	//个人信息
	@RequestMapping("/personal.action")
	public String personal(){
		return "personalInformation";
	}

	//显示头像
	@RequestMapping("/showFaces.action")
	protected void service(HttpServletRequest request,HttpSession session, HttpServletResponse response) throws ServletException, IOException {
		OutputStream os = response.getOutputStream();
		ServletContext sc = request.getSession().getServletContext();
		//显示服务器上的图片需要获取在磁盘上的绝对路径
		File file = new File(sc.getRealPath("/") + "WEB-INF/site/upload/picture/" + ((Employee) session.getAttribute("employee")).getUrl());
		FileInputStream fips = new FileInputStream(file);
		byte[] btImg = readStream(fips);
		os.write(btImg);
		os.flush();
	}

	/**
	 * 读取管道中的流数据
	 */
	public byte[] readStream(InputStream inStream) {
		ByteArrayOutputStream bops = new ByteArrayOutputStream();
		int data = -1;
		try {
			while((data = inStream.read()) != -1){
				bops.write(data);
			}
			return bops.toByteArray();
		}catch(Exception e){
			return null;
		}
	}
}
