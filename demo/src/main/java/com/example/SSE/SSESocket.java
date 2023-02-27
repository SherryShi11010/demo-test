package com.example.SSE;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.example.domain.DemoData;
import com.example.listener.DemoDataListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/test")
public class SSESocket {

    @GetMapping("/push")
    public  String push(){
        Random r = new Random();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:Testing 1,2,3" + r.nextInt() +"\n\n";
    }

    @GetMapping("/pushLong")
    public void push(HttpServletResponse response) {
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("utf-8");
        while (true) {
            Random r = new Random();
            try {
                Thread.sleep(1000);
                PrintWriter pw = response.getWriter();
                pw.write("data:Testing 1,2,3" + r.nextInt() + "\n\n");
                pw.flush();
                System.out.println("data:Testing 1,2,3" + r.nextInt() + "\n\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @GetMapping("/exportExcel")
    public void exportExcel (HttpServletResponse response) throws IOException {

        response.setHeader("Content-Disposition", "attachment; filename=sherry.xlsx");
        // 响应类型,编码
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
//        String bigTitle = "资金流入预算表";
//        EasyExcel.write(response.getOutputStream()).registerWriteHandler(new Custemhandler()).sheet("资金流入预算导出模板").doWrite(data());
        EasyExcel.write(response.getOutputStream(), DemoData.class).sheet("abc").doWrite(data());


    }

    public void testRead() {
        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 写法3：
        String fileName = "E:\\180\\day04-crm实战-表设计&功能开发\\resource\\明日资料\\resource\\excel读取测试.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet(0).doRead();
    }


    private List<DemoData> data() {
        List<DemoData> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

    public void testWrite() {
        // 写法2
        String fileName = "d:/1.xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, DemoData.class).sheet("abc").doWrite(data());
    }





}
