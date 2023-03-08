package study.前缀和;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n+1];
        int[] s = new int[n + 1];
        for (int i = 1; i <=n; i++) {
            arr[i]=scan.nextInt();
        }
        //求段区间前缀和
        for (int i = 1; i <=n ; i++) {
            s[i]=s[i-1]+arr[i];
        }

        for (int i : s) {
            System.out.print(i+" ");
        }
    }
}
