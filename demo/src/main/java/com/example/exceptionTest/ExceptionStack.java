package com.example.exceptionTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExceptionStack {

    private void fun1() throws IOException {
        throw new IOException("level 1 exception");
    }

    private void fun2() throws IOException{
        try {
            fun1();
        } catch (IOException e) {
            throw new RuntimeException("level 2 exception", e);
        }
    }

    public static void read(String filename) throws Exception
    {
        try
        {
            InputStream in = new FileInputStream(filename);  // 创建输入流
            int b;
            while((b=in.read()) != -1){
                System.out.println("1");

            }
        }
        catch(IOException exception)
        {
//            exception.printStackTrace(); // 打印栈轨迹；
            System.out.println("cuowu");
        }

    }

    public static void main(String[] args) {
//        try {
//            new ExceptionStack().fun2();
//        } catch ( IOException e ) {
//            e.printStackTrace();
//        }catch (RuntimeException e){
//            System.out.println("异常");
//        }



    }

}
