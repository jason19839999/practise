package com.example.demo.Response;

/**
 * @描述
 * @创建人 shicong.zhang
 * @创建时间 $date$
 * @修改人和其它信息
 */

import java.util.List;

/**
 * 响应返回表格结果封装
 */
public class TableResultResponse<T> extends BaseResponse {

    TableData<T> data;

    public TableResultResponse(long total, List<T> rows) {
        this.data = new TableData<T>(total, rows);
    }

    public TableResultResponse() {
        this.data = new TableData<T>();
    }

    TableResultResponse<T> total(int total) {
        this.data.setTotal(total);
        return this;
    }

    TableResultResponse<T> total(List<T> rows) {
        this.data.setRows(rows);
        return this;
    }

    public TableData<T> getData() {
        return data;
    }

    public void setData(TableData<T> data) {
        this.data = data;
    }
}

class TableData<T> {
    long total;
    List<T> rows;

    public TableData(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public TableData() {
    }

    public long getTotal() {
        return total;
    }
}