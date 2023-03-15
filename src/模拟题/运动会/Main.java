package 模拟题.运动会;

import java.util.Arrays;
import java.util.Scanner;

//运动会
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int k = scan.nextInt();
        //记录参赛成绩
        int[][] arr = new int[n][m];
        //记录每个运动员最终分数之和
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <m ; j++) {
                arr[i][j]=scan.nextInt();
            }
        }

        for (int j = 0; j <m ; j++) {
            Integer[] tmp = new Integer[n];
            for (int i = 0; i <n ; i++) {   //刚开始0-n-1，这个主要是当作索引
                tmp[i]=i;
            }
            int val=j;
            //根据第j项运动成绩，对tmp排序
            Arrays.sort(tmp,(o1,o2)->arr[o2][val]-arr[o1][val]);
            int score=k;
            //计算每个运动员第j项运动的分数(前k个分数从k降到1)
            for (int i = 0; i <n&&score>0; i++,score--) {
                ans[tmp[i]]+=score;
            }
        }
        Arrays.stream(ans).forEach(x->{
            System.out.print(x+" ");
        });
        scan.close();
    }
}
