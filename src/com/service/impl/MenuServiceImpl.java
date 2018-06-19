package com.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.entity.Menu;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.MenuMapper;
import com.service.MenuService;
import com.system.util.DataTables;
import com.system.util.RequestStatus;


@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuMapper menuMapper;
	
	@Override
	public List<Menu> selectLoginMenus() {
		return menuMapper.selectLoginMenus();
	}
	
	@Override
	public DataTables getPageMenuList(DataTables dataTables) {
		PageHelper.startPage(dataTables.getPageNum(), dataTables.getLength()); // 核心分页代码 
		PageHelper.orderBy("convert(menuname using gbk) asc");
		
		if(!StringUtils.isEmpty(dataTables.getColumn())){
			PageHelper.orderBy(dataTables.getColumn() + " " + dataTables.getOrder());
		}
		
		PageInfo<Menu> pageInfo = new PageInfo<Menu>(menuMapper.getPageMenuList(dataTables.getSearch(), dataTables.getSubSQL()));
		dataTables.setRecordsTotal(pageInfo.getTotal());
		dataTables.setRecordsFiltered(pageInfo.getTotal());
		dataTables.setData(pageInfo.getList() != null ? pageInfo.getList() : new ArrayList<Object>());
		return dataTables;
	}
	
	@Override
	public List<Menu> selPid() {
		return menuMapper.selPid();
	}


	@Override
	public Menu selMenuByAdd(String menuname) {
		return menuMapper.selMenuByAdd(menuname);
	}

	@Override
	public Map<String, Object> insertMenu(Menu menu) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(menuMapper.insertMenu(menu) > 0){
			map.put("status", RequestStatus.SUCCESS);
		}else{
			map.put("status", RequestStatus.FAIL);
		}
		return map;

	}

	@Override
	public Menu selUrlByAdd(String url) {
		return menuMapper.selUrlByAdd(url);
	}
	
	@Override
	public Menu selMenuById(int id) {
		return menuMapper.selMenuById(id);
}
	
	@Override
	public Map<String, Object> updateMenu(Menu menu) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (menuMapper.updateMenu(menu) > 0) {
			map.put("status", RequestStatus.SUCCESS);
		}else{
			map.put("status", RequestStatus.FAIL);
		}
		return map;
	}
	
	@Override
	public Menu selMenu(String menuname,int id) {
		return menuMapper.selMenu(menuname,id);
	}
	
	@Override
	public Menu selUrl(String url,int id) {
		return menuMapper.selUrl(url,id);
	}
	
	@Override
	public Map<String,Object> updateMenuState(Menu menu) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (menuMapper.updateMenuState(menu) > 0) {
			map.put("status", RequestStatus.SUCCESS);
		}else{
			map.put("status", RequestStatus.FAIL);
		}
		return map;
	}
	
	@Override
	public int selectCountMenu(List<Integer> idlist) {
		return menuMapper.selectCountMenu(idlist);
	}

    @Override
    public Map<String, Object> delMenu(List<Integer> idlist) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(selectCountMenu(idlist) < 1){
            if (menuMapper.delMenu(idlist) > 0) {
                map.put("status", RequestStatus.SUCCESS);
            }else{
                map.put("status", RequestStatus.FAIL);
            }
        }else{
            map.put("status", RequestStatus.EXIS);
        }
        return map;
    }
	

	public MenuMapper getMenuMapper() {
		return menuMapper;
	}
	public void setMenuMapper(MenuMapper menuMapper) {
		this.menuMapper = menuMapper;
	}

}
