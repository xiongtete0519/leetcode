package 模板题.绝世武功;

import java.util.Scanner;

//差分
public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] a = new int[n + 1];
        for (int i = 0; i <m; i++) {
            int l = scan.nextInt();
            int r = scan.nextInt();
            int s = scan.nextInt();
            int e = scan.nextInt();
            int d=(e-s)/(r-l);  //计算公差
            int sm=s;
            a[l]+=s;
            for (int j = l+1; j <=r; j++) {
                sm+=d;
                a[j]+=d;
            }
            a[r+1]-=sm;
        }
        long res=0;
        for (int i = 1; i <=n ; i++) {
            a[i]+=a[i-1];   //求前缀和还原出原数组
            res+=a[i];      //对原数组求和
        }
        System.out.println(res);
    }
}
//6 2
//1 5 2 10
//2 4 1 1
