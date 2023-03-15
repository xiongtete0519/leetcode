package 模拟题.运动会;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); //n个运动员
        int m = scan.nextInt(); //m项运动
        int k = scan.nextInt();
        //存储每一项运动的成绩
        int[][] arr = new int[n][m];
        int[] res=new int[n];//记录运动员的总分数
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <m ; j++) {
                arr[i][j]=scan.nextInt();
            }
        }
        //根据每项运动依次求运动员分数
        for (int j = 0; j <m; j++) {
            Integer[] tmp = new Integer[n]; //索引数组
            for (int i = 0; i < n; i++) {//分别代表第i个运动员
                tmp[i]=i;
            }
            //根据第j项运动成绩对各运动员进行排名(从高到低)
            //最后结果会反映到tmp数组上
            int val=j;
            Arrays.sort(tmp,(x1,x2)->arr[x2][val]-arr[x1][val]);
            //准备计算第j项运动各个运动员的得分并累计
            int score=k;
            //前k个人得分分别从k到1，剩下都是0
            for (int i = 0; i < n&&score>0; i++,score--) {
                res[tmp[i]]+=score;
            }
        }
        Arrays.stream(res).forEach(x->{
            System.out.print(x+" ");
        });
        scan.close();
    }
}
//5 3 1 5 12
//2 4 2 34 1
//8 6 3 2 2

//4 4 7