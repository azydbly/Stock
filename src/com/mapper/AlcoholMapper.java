package com.mapper;

import com.entity.Alcohol;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @类描述： 酒的mapper
 * @Author: xiaoshitou
 * @时间： 2018/6/21 10:34
 */
public interface AlcoholMapper {

    //分页显示所有酒
    List<Alcohol> showPageAlcohol(@Param("search") String search, @Param("subSQL") String subSQL);
}
