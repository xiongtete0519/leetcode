package AcWing.截断数组;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n + 1];
        int[] s = new int[n + 1];
        long result=0;
        int count=0;
        for (int i = 1; i <=n; i++) {
            a[i]=scan.nextInt();
            //计算前缀和
            s[i]=s[i-1]+a[i];
        }
        //总和必须是3的倍数，且n>3
        if(s[n]%3!=0||n<3){
            System.out.println(0);
            return;
        }
        int dex=s[n]/3;
        for (int i = 1; i <n ; i++) {
            //当前数的前缀和等于总和的1/3，说明可以分割
            if(s[i]==dex){
                count++;
            }
            if(s[i]==dex*2){
                result+=count;
            }
        }
        System.out.println(result);
    }
}
