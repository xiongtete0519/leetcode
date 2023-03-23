package 蓝桥杯.推到部分和;

import java.util.Scanner;

//带权并查集解决部分和

/**
 * 求解任意范围的部分和时，只要左端点l和右端点r的根节点root相同，则利用[l到root的权值]
 * 减去[r到root的权值]可以得出[l到r的权值]。
 * 由于有本题中包括端点的值，因此节点序号从0开始
 * 比如：求[1,5]区间的数字之和，1到5之间只有四条边，只能求出四个位置上数的和，
 * 因此将[1,5]区间的数字之和改为求(0,5]区间的数字和即可解决。
 */
public class PartialSum {
    //每个节点的父节点
    public static int[] father;
    //value[i]表示i到其根节点的路径长度
    public static long[] value;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int Q = scan.nextInt();
        father = new int[N + 1];  //每个节点的父节点
        for (int i = 0; i <=N ; i++) {
            father[i]=i;    //初始化时父节点都指向自己
        }
        //value[i]表示i到其根节点的路径长度
        value = new long[N + 1];

        //M次操作
        for (int i = 0; i <M ; i++) {
            int l=scan.nextInt();
            int r = scan.nextInt();
            long s = scan.nextLong();
            l--;
            //找根节点，并压缩路径
            int l_Father = findFather(l);
            int r_Father = findFather(r);
            if(l_Father!=r_Father){
                //合并l和r的集合，并更新权值
                //合并规则，将小根节点集合指向大根节点集合
                int small= Math.min(l_Father, r_Father);
                int big=Math.max(l_Father,r_Father);
                father[small]=big;
                value[small]=Math.abs(-value[l]+value[r]+s);
            }
        }
        //Q次询问
        for (int i = 0; i <Q ; i++) {
            int l=scan.nextInt();
            int r = scan.nextInt();
            l--;
            int l_Father = findFather(l);
            int r_Father = findFather(r);
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
    public static int findFather(int x){
        if(father[x]!=x){
            int temp = father[x];
            father[x]=findFather(father[x]);//找根节点
            value[x]+=value[temp];  //压缩路径
        }
        return father[x];
    }
}
