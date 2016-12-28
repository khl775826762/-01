package com.atguigu.jf.console.common.bean.bo;

import java.util.List;

public class PageModel<T> {

	private int pageSize;
	private int pageNum;
	private int total;
	private List<T> rows;

	public PageModel(int pageSize, int pageNo, int total, List<T> rows) {
		super();
		this.pageSize = pageSize;
		this.pageNum = pageNo;
		this.total = total;
		this.rows = rows;
	}

	public PageModel() {
		super();
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}
