package com.entity;

/**
 * @author yanp 类描述： 菜单表 2017-4-21 上午9:40:48
 */
public class Menu {

	// 序号
	private int id;
	
	// 菜单名称
	private String menuname;
	
	// 父类id
	private int pid;
	
	// 菜单自主查看地址
	private String url;
	
	// 启用状态
	private int state;
	
	// 备注
	private String remark;
	
	// 图标
	private String iconfont;
	
	//连接新窗口标识
	private int target;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIconfont() {
		return iconfont;
	}

	public void setIconfont(String iconfont) {
		this.iconfont = iconfont;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	
}
