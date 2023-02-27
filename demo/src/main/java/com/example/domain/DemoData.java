package com.example.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class DemoData {
    @ExcelProperty(value = "姓名",index = 1)
    private String string;
    @ExcelProperty(value = "创建时间",index = 2)
    private Date date;
    @ExcelProperty(value = "数字",index = 3)
    private Double doubleData;
}