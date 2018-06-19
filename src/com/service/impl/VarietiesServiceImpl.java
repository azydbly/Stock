package com.service.impl;

import com.entity.Varieties;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.VarietiesMapper;
import com.service.VarirtiesService;
import com.system.util.DataTables;
import com.system.util.RequestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@Service
public class VarietiesServiceImpl implements VarirtiesService {
	
	@Autowired
	private VarietiesMapper varietiesMapper;
	
	@Override
	public DataTables getPageVarietiesList(DataTables dataTables) {
		PageHelper.startPage(dataTables.getPageNum(), dataTables.getLength()); // 核心分页代码 
		PageHelper.orderBy("convert(name using gbk) asc");
		
		if(!StringUtils.isEmpty(dataTables.getColumn())){
			PageHelper.orderBy(dataTables.getColumn() + " " + dataTables.getOrder());
		}
		
		PageInfo<Varieties> pageInfo = new PageInfo<Varieties>(varietiesMapper.getPageVarietiesList(dataTables.getSearch(), dataTables.getSubSQL()));
		dataTables.setRecordsTotal(pageInfo.getTotal());
		dataTables.setRecordsFiltered(pageInfo.getTotal());
		dataTables.setData(pageInfo.getList() != null ? pageInfo.getList() : new ArrayList<Object>());
		return dataTables;
	}

    @Override
    public Map<String, Object> insertVarieties(Varieties varieties) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(varietiesMapper.insertVarieties(varieties) > 0){
            map.put("status", RequestStatus.SUCCESS);
        }else{
            map.put("status", RequestStatus.FAIL);
        }
        return map;
    }

	@Override
	public Map<String, Object> updateVarietiesState(Varieties varieties) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (varietiesMapper.updateVarietiesState(varieties) > 0) {
			map.put("status", RequestStatus.SUCCESS);
		}else{
			map.put("status", RequestStatus.FAIL);
		}
		return map;
	}

}
