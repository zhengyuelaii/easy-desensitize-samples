package sample.desensitize.basic.util;

import java.util.List;

public class Page<T> {

	private Integer pageNum;

	private Integer pageSize;

	private List<T> data;

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Page [pageNum=" + pageNum + ", pageSize=" + pageSize + ", data=" + data + "]";
	}

}
