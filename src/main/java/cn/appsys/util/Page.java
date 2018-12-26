package cn.appsys.util;

import java.util.List;

public class Page<T> {
	private Integer pageCount;
	private Integer pageSize;
	private Integer pageCurr;
	private Integer count;
	private List<T> pageList;
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageCurr() {
		return pageCurr;
	}
	public void setPageCurr(Integer pageCurr) {
		this.pageCurr = pageCurr;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
		this.pageCount=this.count%this.pageSize==0?this.count/this.pageSize:this.count/this.pageSize+1;
		}
	public List<T> getPageList() {
		return pageList;
	}
	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}

}
