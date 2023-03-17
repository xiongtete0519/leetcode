package LanQiaoBei.最大和;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n + 1];//各个方格的分值
        int[] dp = new int[n + 1];//走到各个方格的最大值
        for (int i = 1; i <=n ; i++) {
            a[i]=scan.nextInt();
        }
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[1]=a[1];  //默认站在第1个方格
        //遍历所有到n的路径
        for (int i = 1; i <=n ; i++) {
            int next=findMinNumber(n-i);
            //遍历当前方格可以走的路径
            for (int j = i+1; j <=i+next ; j++) {
                //存下最大值
                dp[j]=Math.max(dp[j],dp[i]+a[j]);
            }
        }
        System.out.println(dp[n]);
        Arrays.stream(dp).skip(1).forEach(x->{
            System.out.print(x+" ");
        });

        }
        //找出x的最小质因数
        public static int findMinNumber(int x){
            for (int i = 2; i <=Math.sqrt(x); i++) {
            if(x%i==0){
                return i;
            }
        }
        return x;
    }
}
