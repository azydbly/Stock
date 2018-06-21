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
import java.util.List;
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

	@Override
	public Varieties selVarietiesById(int id) {
		return varietiesMapper.selVarietiesById(id);
	}

	@Override
	public Map<String, Object> updateVarieties(Varieties varieties) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (varietiesMapper.updateVarieties(varieties) > 0) {
			map.put("status", RequestStatus.SUCCESS);
		}else{
			map.put("status", RequestStatus.FAIL);
		}
		return map;
	}

	@Override
	public Map<String, Object> delVarieties(List<Integer> idlist) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (varietiesMapper.delVarieties(idlist) > 0) {
			map.put("status", RequestStatus.SUCCESS);
		}else{
			map.put("status", RequestStatus.FAIL);
		}
		return map;
	}

	@Override
	public Varieties selVarietiesForAdd(String name) {
		return varietiesMapper.selVarietiesForAdd(name);
	}

	@Override
	public Varieties selVarietiesByIdForEdit(String name, int id) {
		return varietiesMapper.selVarietiesByIdForEdit(name,id);
	}

	@Override
	public List<Varieties> selAllVarieties() {
		return varietiesMapper.selAllVarieties();
	}

}
