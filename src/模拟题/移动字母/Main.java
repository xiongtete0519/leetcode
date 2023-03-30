package 模拟题.移动字母;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {
    //定义方向
    public static int[][] dirs={
            {0,1},  //右
            {1,0},  //下
            {0,-1}, //左
            {-1,0}  //上
    };
    public static String END="ABCDE*";
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i <n; i++) {
            String str = in.readLine();
            System.out.println(BFS(str));
        }
        in.close();
        out.flush();
        out.close();
    }
    //看最终状态能否到达ABCDE*
    public static int BFS(String str){
        LinkedList<Node> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        //初始数据准备
        int pos = str.indexOf('*'); //找到*号位置
        //pos/3为原先二维数组中的行坐标，pos%3时列坐标
        Node node = new Node(pos / 3, pos % 3, str);
        if(str.equals(END)){
            return 1;
        }
        queue.offer(node);//入队
        set.add(str);//将地图添加到set中
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            for (int[] dir : dirs) {//向四个方向扩展
                int x = curr.x + dir[0];
                int y = curr.y + dir[1];
                if(x<0||x>1||y<0||y>2){//判断是否越界
                    continue;
                }
                //将*位置和扩展位置交换
                String tempStr = curr.curStr;
                char[] tempChar = tempStr.toCharArray();
                tempChar[curr.x*3+curr.y]=tempStr.charAt(x*3+y);
                tempChar[x*3+y]=tempStr.charAt(curr.x*3+curr.y);
                String s = String.valueOf(tempChar);

                //当前最新的数据
                Node node1 = new Node(x, y, s);
                //判断是否到达end
                if(node1.curStr.equals(END)){
                    return 1;
                }
                //判断地图是否重复
                if(!set.contains(node1.curStr)){
                    set.add(node1.curStr);
                    queue.offer(node1);
                }
            }
        }
        return 0;   //走到这里说明不能到达END
    }
}
class Node{
    int x;  //当前*的位置
    int y;
    String curStr; //当前的地图串

    public Node(int x, int y, String curStr) {
        this.x = x;
        this.y = y;
        this.curStr = curStr;
    }
}
