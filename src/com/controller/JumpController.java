package com.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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

@Controller
public class JumpController {
	
	@Autowired
	private EmployeeService employeeService;
	
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
