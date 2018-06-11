package com.service;

import java.util.List;
import java.util.Map;

import com.entity.Menu;
import com.system.util.DataTables;

public interface MenuService {
	
	List<Menu> selectLoginMenus();
	
	//菜单分页显示
	DataTables getPageMenuList(DataTables dataTables);
	
	//查询所有顶级菜单
	List<Menu> selPid();
		
	//添加菜单时，名称验证
	Menu selMenuByAdd(String menuname);

	//新增菜单
	Map<String, Object> insertMenu(Menu menu);
	
	//添加菜单时，验证url
	Menu selUrlByAdd(String url);

	//查询单个菜单， 用途：修改菜单时进行回显显示
	Menu selMenuById(int id);
	
	//更新菜单
	Map<String, Object> updateMenu(Menu menu);
	
	//查询单个菜单（根据菜单名称查询） 用途：更新菜单时验证是否重名（不查询自己的名称）
	Menu selMenu(String menuname, int id);

	//根据url查询菜单（用于验证URL是否重复）
	Menu selUrl(String url, int id);
	
	//更新菜单状态
	Map<String, Object> updateMenuState(Menu menu);
	
	//查询删除菜单下面是否包含子菜单
	int selectCountMenu(List<Integer> idlist);

    //删除菜单（单条、多条）
    Map<String, Object> delMenu(List<Integer> idlist);

}
