package sample.desensitize.common.result.util;

import java.util.List;

/**
 * 分页结果
 *
 * @author zhengyuelaii
 * @version 1.0.0
 * @since 2026-01-27
 */
public class Page<T> {

    private Integer pageNum;

    private Integer pageSize;

    private Integer total;

    private List<T> records;

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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", records=" + records +
                '}';
    }
}
