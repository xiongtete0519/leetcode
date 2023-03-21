package LanQiaoBei.蜂巢;

import java.util.Scanner;

public class Main {
    //方向增量
    public static int[][] dir ={
            {-1,0},     //0方向
            {-1,1},     //1方向
            {0,1},      //2方向
            {1,0},      //3方向
            {1,-1},     //4方向
            {0,-1}      //5方向
    };
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int d1 = scan.nextInt();
        int p1 = scan.nextInt();
        int q1 = scan.nextInt();
        int d2 = scan.nextInt();
        int p2 = scan.nextInt();
        int q2 = scan.nextInt();
        //转化坐标
        Node A = change(d1, p1, q1);
        Node B = change(d2, p2, q2);
        //计算差值向量
        int first = A.x - B.x;
        int second = A.y - B.y;
        int ans=0;
        //分类讨论
        if(first==0||second==0){    //差值向量在坐标轴上，其实可以直接取最大的绝对值
            ans= Math.abs(first)+Math.abs(second);
        }else if(first>0&&second>0||first<0&&second<0){ //差值向量再一、三象限
            ans=Math.abs(first)+Math.abs(second);
        }else{  //差值向量在二、四象限
            ans=Math.max(Math.abs(first),Math.abs(second));
        }
        System.out.println(ans);
    }
    //将 <d,p,q>转换成新坐标系下的<x,y>
    //以3方向(正东)位x轴正方向，以2方向(东偏北60度)为y轴正方向建立坐标系
    public static Node change(int d,int p,int q){
        //先向d方向走p步，再向(d+2)mod6方向走q步
        int x=0;
        int y=0;
        x+=dir[d][0]*p;
        y+=dir[d][1]*p;
        d=(d+2)%6;
        x+=dir[d][0]*q;
        y+=dir[d][1]*q;
        return new Node(x,y);
    }
}
class Node{
    public int x;
    public int y;

    public Node() {
        this.x=this.y=0;
    }

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
//0 5 3 2 3 2
