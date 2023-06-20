package java程序员面试宝典.流.NIO;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    public static void main(String[] args) {
        SocketChannel channel=null;
        try{
            channel=SocketChannel.open();
            channel.connect(new InetSocketAddress("127.0.0.1",8800));

            ByteBuffer writeBuf = ByteBuffer.allocate(1024);
            ByteBuffer readBuf = ByteBuffer.allocate(1024);

            writeBuf.put("Hello server".getBytes());
            writeBuf.flip();

            while(true){
                writeBuf.rewind();
                channel.write(writeBuf);
                readBuf.clear();
                channel.read(readBuf);
                System.out.println("Client Service:"+new String(readBuf.array()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(channel!=null){
                try{
                    channel.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
