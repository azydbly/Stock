package com.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author yanp 类描述：种类
 */
public class Varieties {

	//主键
	private int id;
	
	//名字
	private String name;
	
	//简介
	private String introduction;
	
	//级别
	private int level;
	
	//备注
	private String remarks;
	
	//创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private String insertdatetime;
	
	//修改时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String updatedatetime;
	
	//0停用 1启用
	private int state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getInsertdatetime() {
        return insertdatetime;
    }

    public void setInsertdatetime(String insertdatetime) {
        this.insertdatetime = insertdatetime;
    }

    public String getUpdatedatetime() {
        return updatedatetime;
    }

    public void setUpdatedatetime(String updatedatetime) {
        this.updatedatetime = updatedatetime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
