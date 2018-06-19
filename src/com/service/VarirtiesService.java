package com.service;

import com.entity.Varieties;
import com.system.util.DataTables;

import java.util.Map;


public interface VarirtiesService {
	

	//种类分页显示
	DataTables getPageVarietiesList(DataTables dataTables);

    //新增种类
    Map<String, Object> insertVarieties(Varieties  varieties);

    //更新种类状态
    Map<String, Object> updateVarietiesState(Varieties varieties);

    //
    //查询单个种类
    Varieties selVarietiesById(int id);

}
