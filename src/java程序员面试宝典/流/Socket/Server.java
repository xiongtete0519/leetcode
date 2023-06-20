package java程序员面试宝典.流.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        BufferedReader br=null;
        PrintWriter pw=null;
        try {
            ServerSocket serverSocket = new ServerSocket(2000);
            Socket socket = serverSocket.accept();
            //获取输入流
            br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //获取输出流
            pw=new PrintWriter(socket.getOutputStream(),true);
            //获取接收的数据
            String s=br.readLine();
            //发送相同的数据给客户端
            pw.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
