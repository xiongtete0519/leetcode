package LanQiaoBei.推到部分和;

import java.util.Scanner;

//带权并查集解决部分和
public class PartialSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int Q = scan.nextInt();
        int[] father = new int[N + 1];  //每个节点的父节点
        for (int i = 0; i <=N ; i++) {
            father[i]=i;    //初始化时父节点都指向自己
        }
        //value[i]表示i到其根节点的路径长度
        long[] value = new long[N + 1];

        //M次操作
        for (int i = 0; i <M ; i++) {
            int l=scan.nextInt();
            int r = scan.nextInt();
            long s = scan.nextLong();
            l--;
            //找根节点，并压缩路径
            int l_Father = findFather(l, father, value);
            int r_Father = findFather(r, father, value);
            if(l_Father!=r_Father){
                //合并l和r的集合，并更新权值
                //合并规则，将小根节点集合指向大根节点集合
                int small=l_Father>r_Father?r_Father:l_Father;
                int big=small==r_Father?l_Father:r_Father;
                father[small]=big;
                value[small]=Math.abs(-value[l]+value[r]+s);
            }
        }
        //Q次询问
        for (int i = 0; i <Q ; i++) {
            int l=scan.nextInt();
            int r = scan.nextInt();
            l--;
            int l_Father = findFather(l, father, value);
            int r_Father = findFather(r, father, value);
            //同一集合，就能计算出结果
            if(l_Father==r_Father){
                System.out.println(value[l]-value[r]);
            }else{
                System.out.println("UNKNOWN");
            }
        }
        scan.close();
    }
    //查找(路径压缩)
    public static int findFather(int x,int[] father,long[] value){
        if(x!=father[x]){
            int temp = father[x];
            father[x]=findFather(father[x],father,value);//找根节点
            value[x]+=value[temp];  //压缩路径
        }
        return father[x];
    }
}
