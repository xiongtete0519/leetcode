package AcWing.截断数组;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] s = new int[n + 1];
        for (int i = 1; i <=n; i++) {
            s[i]=scan.nextInt();
            s[i]+=s[i-1];   //计算前缀和
        }
        if(s[n]%3!=0){  //总和必须是3的倍数
            System.out.println(0);
            return;
        }
        long res=0;
        for (int i = 3,count=0; i <=n ; i++) {
            if(s[i-2]==s[n]/3){
                count++;
            }
            if(s[n]-s[i-1]==s[n]/3){
                res+=count;
            }
        }
        System.out.println(res);
        scan.close();
    }
}
