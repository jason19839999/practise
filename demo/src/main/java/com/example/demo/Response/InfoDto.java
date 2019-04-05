package com.example.demo.Response;

import com.example.demo.entity.StudentEntity;

import java.util.List;

/**
 * @描述
 * @创建人 shicong.zhang
 * @创建时间 $date$
 * @修改人和其它信息
 */
public class InfoDto {
    long total;
    List<StudentEntity> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<StudentEntity> getRows() {
        return rows;
    }

    public void setRows(List<StudentEntity> rows) {
        this.rows = rows;
    }
}
