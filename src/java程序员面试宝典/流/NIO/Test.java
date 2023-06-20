package java程序员面试宝典.流.NIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test {
    public static void writeFile(){
        RandomAccessFile raf=null;
        FileChannel inChannel=null;
        try {
            raf=new RandomAccessFile("input.txt","rw");
            //获取FileChannel
            inChannel=raf.getChannel();
            //创建一个写数据的Buffer
            ByteBuffer writeBuf=ByteBuffer.allocate(24);
            //写入数据
            writeBuf.put("filechannel test".getBytes());
            //把Buffer变为只读模式
            writeBuf.flip();
            //从buffer中读数据并写到channel中
            inChannel.write(writeBuf);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inChannel!=null){
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(raf!=null){
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void readFile(){
        RandomAccessFile raf=null;
        FileChannel inChannel=null;
        try {
            raf=new RandomAccessFile("input.txt","rw");
            //获取FileChannel
            inChannel=raf.getChannel();
            //创建用来读数据的Buffer
            ByteBuffer readBuf = ByteBuffer.allocate(24);
            //从Channel中把数据读取到Buffer中
            int bytesRead = inChannel.read(readBuf);
            while(bytesRead!=-1){
                System.out.println("Read "+bytesRead);
                //把Buffer调整为读模式
                readBuf.flip();
                //如果还有未读内容
                while(readBuf.hasRemaining()){
                    System.out.print((char)readBuf.get());
                }
                //清空缓存区
                readBuf.clear();
                bytesRead=inChannel.read(readBuf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inChannel!=null){
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(raf!=null){
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        writeFile();
        readFile();
    }
}
