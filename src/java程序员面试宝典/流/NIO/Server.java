package java程序员面试宝典.流.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server {
    public static void main(String[] args) {
        Selector selector=null;
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress("127.0.0.1",8800));
            //设置为非阻塞模型
            ssc.configureBlocking(false);

            selector=Selector.open();
            //注册channel,同时指定感兴趣的事件是Accept
            ssc.register(selector, SelectionKey.OP_ACCEPT);

            ByteBuffer readBuff = ByteBuffer.allocate(1024);//读buffer
            ByteBuffer writeBuff = ByteBuffer.allocate(1024);//写buffer
            writeBuff.put("Hello Client".getBytes());
            writeBuff.flip();

            while(true){
                int readyNum = selector.select();//阻塞等待
                if(readyNum==0){
                    continue;
                }
                Set<SelectionKey> keys = selector.selectedKeys();//获取就绪的keys
                Iterator<SelectionKey> it = keys.iterator();
                //遍历就绪的通道
                while(it.hasNext()){
                    SelectionKey key = it.next();
                    if(key.isAcceptable()){
                        //创建新的连接，并且把新的连接注册到selector上，且只对读操作感兴趣
                        SocketChannel socketChannel = ssc.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector,SelectionKey.OP_READ);
                    }else if(key.isReadable()){
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        readBuff.clear();
                        socketChannel.read(readBuff);

                        readBuff.flip();
                        System.out.println("Server receive: "+new String(readBuff.array()));
                        //一旦读完数据后，只对写感兴趣，因为要给client发送数据
                        key.interestOps(SelectionKey.OP_WRITE);
                    }else if(key.isWritable()){
                        writeBuff.rewind();
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        socketChannel.write(writeBuff);
                        //发送完以后只对读事件感兴趣
                        key.interestOps(SelectionKey.OP_READ);
                    }
                    //处理完事件后需要从就绪的keys中删除
                    it.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(selector!=null){
                try{
                    selector.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
