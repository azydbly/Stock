package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.Menu;

/**
 * @author yanp
 * 2017-8-18
 * 类描述： 菜单的增删查改
 * 分页显示
 */
public interface MenuMapper {
	
	//登陆时查询分配 pid=> 0的子级菜单
	List<Menu> selectLoginMenus();
	
	//菜单分页显示
	List<Menu> getPageMenuList(@Param("search") String search, @Param("subSQL") String subSQL);
	
	//查询所有顶级菜单
	List<Menu> selPid();
	
	//插入菜单
	int insertMenu(Menu menu);

	//添加菜单时，名称验证
	Menu selMenuByAdd(String menuname);
	
	//添加菜单时，验证url
	Menu selUrlByAdd(String url);

	//查询单个菜单， 用途：修改菜单时进行回显显示
	Menu selMenuById(int id);
	
	//修改菜单
	int updateMenu(Menu menu);
	
	//查询单个菜单（根据菜单名称查询） 用途：更新菜单时验证是否重名（不查询自己的名称）
	Menu selMenu(String menuname, int id);

	//根据url查询菜单（用于验证URL是否重复）
	Menu selUrl(String url, int id);
	
	//修改菜单状态
	int updateMenuState(Menu menu);
	
	//删除菜单（单条、多条）
	int delMenu(@Param("idlist")List<Integer> idlist);
	
	//查询删除菜单下面是否包含子菜单
	int selectCountMenu(@Param("idlist")List<Integer> idlist);

}
