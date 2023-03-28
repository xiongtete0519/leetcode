package 模拟题.质因数分解;

import java.util.Scanner;
//质因数分解，求出较大的质数因子
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(zhiyin(n));
        scan.close();
    }
    public static int zhiyin(int n){
        int max=Integer.MIN_VALUE;
        for (int i = 2; i <=Math.sqrt(n); i++) {
            if(zhishu(i)&&n%i==0){
                max=Math.max(max,i);
                int j = n / i;
                if(zhishu(j)){
                    max=Math.max(max,j);
                }
            }
        }
        return max;
    }
    //判断一个数是不是质数
    public static boolean zhishu(int n){
        for (int i = 2; i <=Math.sqrt(n) ; i++) {
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
