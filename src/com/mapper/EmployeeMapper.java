package com.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.entity.Employee;

public interface EmployeeMapper {
	
	//登录系统
	Employee login(String loginName, String loginPassword);

	//员工分页显示
	List<Employee> getPageEmployeeList(@Param("search") String search, @Param("subSQL") String subSQL);
	
	// 根据id查询用户
	Employee selById(int id);

	// 增加用户
	int insEmployee(Employee employee);

	// 删除用户（单条、多条）
	int delEmployees(@Param("idlist")List<Integer> idlist);

	// 修改用户
	int updEmployee(Employee employee);
	
	//更改自己的密码
	int updatePasswordById(String newPassword, int id);
	
	//修改用户信息添加头像
	int updEmployeeById(Employee employee);

	// 添加用户名时异步验证
	Employee selectAllName(String username);
	
	//更新时用户名异步验证
	Employee selectAllNameUpdate(String username,int employeeNum);

	//更新个人资料不重新上传头像
	int updEmployeeByIdNoFile(Employee employee);

	//更新员工状态
	int updateEmployeeState(int flag,int employeeNum);
	
}
