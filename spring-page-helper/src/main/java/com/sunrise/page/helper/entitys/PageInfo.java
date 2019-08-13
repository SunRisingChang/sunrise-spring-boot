package com.sunrise.page.helper.entitys;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据分页信息
 * 
 * @author Sun Rising
 * @date 2019.05.01 09:30:18
 *
 */
public class PageInfo {

	// 当前页
	private int currentPageNum = 0;

	// 每页的记录数
	private int pageSize = 10;

	// 记录总数
	private int totalRecords;

	// 总页数
	@SuppressWarnings("unused")
	private int totalPageNum;

	// 排序字段
	private String sortField;

	// 排序方向
	private String SortDirection = "ASC";

	// 记录存储体
	private List<?> dataBody = new ArrayList<>();

	public int getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getTotalPageNum() {
		return (totalRecords % pageSize == 0) ? (totalRecords / pageSize) : (totalRecords / pageSize + 1);
	}

	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getSortDirection() {
		return SortDirection;
	}

	public void setSortDirection(String sortDirection) {
		SortDirection = "DESC".equals(sortDirection) ? "DESC" : "ASC";
	}

	public List<?> getDataBody() {
		return dataBody;
	}

	public void setDataBody(List<?> dataBody) {
		this.dataBody = dataBody;
	}
}
