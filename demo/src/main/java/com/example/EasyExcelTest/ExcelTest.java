package com.example.EasyExcelTest;

import com.alibaba.excel.util.FileUtils;

import java.io.File;
import java.net.URL;

public class ExcelTest {
    public static void main(String[] args) {
        String rootPath = getTemplatePath();
        System.out.println(rootPath);

    }

    public static String getTemplatePath(){
        URL classUrl = FileUtils.class.getClassLoader().getResource("/");
        if (classUrl == null) {
            classUrl = FileUtils.class.getClassLoader().getResource("");
        }
        String classPath = classUrl.getPath();

        if ("\\".equals(File.separator)) {

            classPath = classPath.replace("/", "\\");
        }

        //linux下
        if ("/".equals(File.separator)) {
            classPath = classPath.replace("\\", "/");
        }

        return classPath + "template" + File.separator + "process_props.xlsx";

    }
}
