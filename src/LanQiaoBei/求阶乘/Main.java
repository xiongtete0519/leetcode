package LanQiaoBei.求阶乘;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long k = scan.nextLong();

        for (long i = 0; i<Long.MAX_VALUE; i++) {
            //计算阶乘
            long num = factorial(i);
            //判断末尾是否恰好有K个0
            String s = String.valueOf(num);
            if(s.length()<k){
                continue;
            }
            //截取末尾k个字符
            String sub = s.substring((int) (s.length() - k), s.length());
            //判断sub是否是全0字符串
            long intNumber = Long.parseLong(sub);
            if(intNumber==0){
                System.out.println(i);
                break;
            }
        }
        scan.close();

    }

    //递归求阶乘
    public static long factorial(long n){
        if(n==0||n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
}
