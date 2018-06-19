package com.mapper;

import com.entity.Varieties;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanp
 * 2017-8-18
 * 类描述： 种类的增删查改
 * 分页显示
 */
public interface VarietiesMapper {

	//种类分页显示
	List<Varieties> getPageVarietiesList(@Param("search") String search, @Param("subSQL") String subSQL);

	//插入种类
	int insertVarieties(Varieties varieties);

	//更新种类状态
	int updateVarietiesState(Varieties varieties);

}
