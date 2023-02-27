package com.example.bufferchannel;

import com.example.domain.DemoData;
import jdk.nashorn.internal.objects.NativeString;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * channel:本身不存储数据，负责缓冲区中数据的运输
 *
 * 实现类：java.nio.channels
 *      -fileChannel：本地
 *      -socketChannel:网络io
 *      -serverSocketChannel：网络
 *      -DatagramChannel：udp
 *
 * 获取通道：
 * 1.getChannel()
 *      本地io:
 *          fileInputStream
 *          RandomAccessFile
 *       网络：
 *       SOcket
 *       serverSocket
 *       DatagramSocket
 *  2.jdk1.7中对通道提供static open
 *  3.jdk1.7中对Files的工具类中提供的newByteChannel
 *
 *
 */
public class testChannel {

    //获取通道
    public void test1() throws IOException {
        FileInputStream fis = new FileInputStream("1.jpg");
        FileOutputStream fos = new FileOutputStream("2.jpg");

        //获取通道
        FileChannel fisChannel = fis.getChannel();
        FileChannel fosChannel = fos.getChannel();

        //分配缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //将通道中的数据存入缓冲区
        while (fisChannel.read(buffer) !=-1){
            //切换成读取数据模式
            buffer.flip();
            //将缓冲区的数据写入通道中
            fosChannel.write(buffer);
            buffer.clear();

        }

        //将缓冲区的数据写入通道


    }
    public void test2() throws IOException {
        FileChannel in = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);

        FileChannel out = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE);

        MappedByteBuffer inMap = in.map(FileChannel.MapMode.READ_ONLY, 0, in.size());
        MappedByteBuffer outMap = out.map(FileChannel.MapMode.READ_WRITE, 0, out.size());

        //直接对缓冲区的数据进行读写





    }

//    public static void main(String[] args) {
//        String connectorIp = "http://10.122.36.9:8086/connectors";
//        String url = connectorIp.substring(0, connectorIp.indexOf("/connectors"));
//        System.out.println(url);
//        System.out.println(connectorIp.indexOf("/connectors"));
//
//    }


    public static void main(String[] args) {
        Class test = testChannel.class;
        Class[] para = new Class[]{testChannel.class, DemoData.class};
        System.out.println(para.length);
    }








}
