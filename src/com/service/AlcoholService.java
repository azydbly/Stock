package com.service;

import com.entity.Alcohol;
import com.system.util.DataTables;

import java.util.Map;

/**
 * @类描述： 酒的实现层
 * @Author: xiaoshitou
 * @时间： 2018/6/21 10:29
 */
public interface AlcoholService {

    //就分页显示
    DataTables showPageAlcohol(DataTables dataTables);

    //插入酒
    Map<String,Object> insertAlcohol(Alcohol alcohol);
}
