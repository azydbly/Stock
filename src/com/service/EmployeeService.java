package com.service;

import java.util.List;
import java.util.Map;

import com.entity.Employee;
import com.system.util.DataTables;

public interface EmployeeService {
	
	//登录系统
	Employee login(String loginName, String loginPassword);

	//员工分页显示
	DataTables getPageEmployeeList(DataTables dataTables);
	
	//更改用户的密码
    Map<String, Object> updatePasswordById(String newPassword, int id);

    //个人中心更改自己密码
    int updatePasswordByPersonal(String newPassword, int id);

    //修改用户信息添加头像
	int updEmployeeById(Employee employee);

	// 根据id查询用户
	Employee selById(int id);

	// 增加用户
	Map<String, Object> insEmployee(Employee employee);

	// 删除用户（多条）
	Map<String, Object> delEmployees(List<Integer> idlist);

	// 修改用户
	Map<String, Object> updEmployee(Employee employee);

	// 添加用户名时异步验证
	Employee selectAllName(String username);
	
	//更新时用户名异步验证
	Employee selectAllNameUpdate(String username,int employeeNum);

	//更新个人资料不重新上传头像
	int updEmployeeByIdNoFile(Employee employee);
	
	//更新员工状态
	Map<String, Object> updateEmployeeState(int flag,int employeeNum);

}
