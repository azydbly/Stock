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

	//根据id查询种类
	Varieties selVarietiesById(int id);

	//根据id修改种类信息
	int updateVarieties(Varieties varieties);

    //删除种类（单条、多条）
    int delVarieties(@Param("idlist")List<Integer> idlist);

    //添加种类时验证重复
    Varieties selVarietiesForAdd(String name);

    //修改种类时验证重复
    Varieties selVarietiesByIdForEdit(String name,int id);

    //查询所有分类
    List<Varieties> selAllVarieties();
}
