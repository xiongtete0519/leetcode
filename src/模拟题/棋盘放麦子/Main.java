package 模拟题.棋盘放麦子;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        BigInteger num = new BigInteger("2");
        BigInteger sum = new BigInteger("0");

        for (int i = 1; i <=64 ; i++) {
            sum=sum.add(num.pow(i-1));
        }
        System.out.println(sum);
        long end = System.currentTimeMillis();
    }
}
