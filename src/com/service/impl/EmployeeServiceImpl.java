package com.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.entity.Employee;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.EmployeeMapper;
import com.service.EmployeeService;
import com.system.util.DataTables;
import com.system.util.RequestStatus;


@Service
public class EmployeeServiceImpl implements EmployeeService{
  
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Autowired	
	HttpServletRequest request;
	
	@Override
	public Employee login(String loginName, String loginPassword) {
		return employeeMapper.login(loginName,loginPassword);
	}

	public EmployeeMapper getEmployeeMapper() {
		return employeeMapper;
	}

	public void setEmployeeMapper(EmployeeMapper employeeMapper) {
		this.employeeMapper = employeeMapper;
	}

	@Override
	public Employee selById(int id) {
		return employeeMapper.selById(id);
	}

	@Override
	public Map<String, Object> insEmployee(Employee employee) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (employeeMapper.insEmployee(employee) > 0) {
			map.put("status", RequestStatus.SUCCESS);
		}else{
			map.put("status", RequestStatus.FAIL);
		}
		return map;
	}

	@Override
	public Map<String, Object> delEmployees(List<Integer> idlist) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (employeeMapper.delEmployees(idlist) > 0) {
			map.put("status", RequestStatus.SUCCESS);
		}else{
			map.put("status", RequestStatus.FAIL);
		}
		return map;
	}

	@Override
	public Map<String, Object> updEmployee(Employee employee) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (employeeMapper.updEmployee(employee) > 0) {
			map.put("status", RequestStatus.SUCCESS);
		}else{
			map.put("status", RequestStatus.FAIL);
		}
		return map;
	}

	@Override
	public Map<String, Object> updatePasswordById(String newPassword,int id ) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (employeeMapper.updatePasswordById(newPassword,id) > 0) {
			map.put("status", RequestStatus.SUCCESS);
		}else{
			map.put("status", RequestStatus.FAIL);
		}
		return map;
	}

    @Override
    public int updatePasswordByPersonal(String newPassword, int id) {
        return employeeMapper.updatePasswordById(newPassword,id);
    }

    @Override
	public int updEmployeeById(Employee employee) {
		return employeeMapper.updEmployeeById(employee);
	}

	@Override
	public Employee selectAllName(String username) {
		return employeeMapper.selectAllName(username);
	}

	@Override
	public Employee selectAllNameUpdate(String username, int employeeNum) {
		return employeeMapper.selectAllNameUpdate(username, employeeNum);
	}

	@Override
	public int updEmployeeByIdNoFile(Employee employee) {
		return employeeMapper.updEmployeeByIdNoFile(employee);
	}

	@Override
	public Map<String, Object> updateEmployeeState(int flag, int employeeNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (employeeMapper.updateEmployeeState(flag, employeeNum) > 0) {
			map.put("status", RequestStatus.SUCCESS);
		}else{
			map.put("status", RequestStatus.FAIL);
		}
		return map;
	}

	@Override
	public DataTables getPageEmployeeList(DataTables dataTables) {
		PageHelper.startPage(dataTables.getPageNum(), dataTables.getLength()); // 核心分页代码 
		PageHelper.orderBy("convert(userName using gbk) asc");
		
		if(!StringUtils.isEmpty(dataTables.getColumn())){
			PageHelper.orderBy(dataTables.getColumn() + " " + dataTables.getOrder());
		}
		
		PageInfo<Employee> pageInfo = new PageInfo<Employee>(employeeMapper.getPageEmployeeList(dataTables.getSearch(), dataTables.getSubSQL()));
		dataTables.setRecordsTotal(pageInfo.getTotal());
		dataTables.setRecordsFiltered(pageInfo.getTotal());
		dataTables.setData(pageInfo.getList() != null ? pageInfo.getList() : new ArrayList<Object>());
		return dataTables;
	}

}
