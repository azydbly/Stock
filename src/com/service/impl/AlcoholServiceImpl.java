package com.service.impl;

import com.entity.Alcohol;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.AlcoholMapper;
import com.service.AlcoholService;
import com.system.util.DataTables;
import com.system.util.RequestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @类描述： 酒的实现层
 * @Author: xiaoshitou
 * @时间： 2018/6/21 10:31
 */

@Service
public class AlcoholServiceImpl implements AlcoholService{

    @Autowired
    HttpServletRequest request;

    @Autowired
    private AlcoholMapper alcoholMapper;

    @Override
    public DataTables showPageAlcohol(DataTables dataTables) {
        PageHelper.startPage(dataTables.getPageNum(), dataTables.getLength()); // 核心分页代码
        PageHelper.orderBy("convert(a.name using gbk) asc");

        if (!StringUtils.isEmpty(dataTables.getColumn())) {
            PageHelper.orderBy(dataTables.getColumn() + " " + dataTables.getOrder());
        }

        PageInfo<Alcohol> pageInfo = new PageInfo<Alcohol>(alcoholMapper.showPageAlcohol(dataTables.getSearch(), dataTables.getSubSQL()));
        dataTables.setRecordsTotal(pageInfo.getTotal());
        dataTables.setRecordsFiltered(pageInfo.getTotal());
        dataTables.setData(pageInfo.getList() != null ? pageInfo.getList() : new ArrayList<Object>());
        return dataTables;
    }

    @Override
    public Map<String, Object> insertAlcohol(Alcohol alcohol) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (alcoholMapper.insertAlcohol(alcohol) > 0) {
            map.put("status", RequestStatus.SUCCESS);
        }else{
            map.put("status", RequestStatus.FAIL);
        }
        return map;
    }
}
