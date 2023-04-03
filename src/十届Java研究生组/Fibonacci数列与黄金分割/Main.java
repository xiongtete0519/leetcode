package 十届Java研究生组.Fibonacci数列与黄金分割;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        if (n>20) { //n超过20之后的值都是一样的：61803399
            n=20;
        }
        BigDecimal fn = BigDecimal.valueOf(fibonacci(n));
        BigDecimal fn1 = BigDecimal.valueOf(fibonacci(n + 1));
        System.out.println(fn.divide(fn1,8,BigDecimal.ROUND_HALF_UP));
    }
    public static long fibonacci(long n){
        if(n==1||n==2){
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
}
