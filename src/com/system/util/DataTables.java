package com.system.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

/**
 * 传递参数
 * @author yanp
 */

@SuppressWarnings("all")
public class DataTables implements java.io.Serializable { 
	
	private Integer pageNum;// 起始行数
	private Integer length;// 页面大小
	private Integer start; //limit offset
	private String search;// 搜索的字符串
	private String order;// 排序方式desc or asc
	private String column;// 需要排序的列
	private long recordsTotal;// 数据库中的结果总行数
	private long recordsFiltered;// 搜索过滤后的行数
	private Integer draw; // datatables建议将此参数传回
	private List<?> data;// 结果集
	private String subSQL;// 手动拼装的额外参数

	public DataTables() {
	};

	@SuppressWarnings("deprecation")
	public DataTables(HttpServletRequest request, String... args) {
		this.length = StringUtils.isEmpty(request.getParameter("length")) ? 10 : Integer.parseInt(request.getParameter("length"));
		this.start = StringUtils.isEmpty(request.getParameter("start")) ? 0 : Integer.parseInt(request.getParameter("start"));
		this.pageNum = this.start / this.length + 1;
		this.draw = StringUtils.isEmpty(request.getParameter("draw")) ? 0 : Integer.parseInt(request.getParameter("draw"));
		this.search = StringUtils.isEmpty(request.getParameter("search")) ? null : request.getParameter("search");
		this.order = request.getParameter("order[0][dir]");
		this.column = request.getParameter("columns[" + request.getParameter("order[0][column]") + "][data]");
		String subSQL = "";
		
		//通过时间配置
		/*if (!StringUtils.isEmpty(request.getParameter("timeMax"))) {
			subSQL += "create_time > '" + request.getParameter("timeMin") + "' and create_time < '" + request.getParameter("timeMax") + "'";
		}*/
		if (args.length > 0) {
			for (String sql : args) {
				subSQL += StringUtils.isEmpty(sql) ? "" : (StringUtils.isEmpty(subSQL) ? "" : " and ") + sql;
			}
		}

		this.subSQL = subSQL;
	}

	public static DataTables getInstance(HttpServletRequest request, String... args) {
		return new DataTables(request, args);
	};

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getSubSQL() {
		return subSQL;
	}

	public void setSubSQL(String subSQL) {
		this.subSQL = subSQL;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}
}
