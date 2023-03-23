package 蓝桥杯.货物摆放;

import java.util.HashSet;

public class Main {

    //直接三重循环时间复杂度非常大，另辟蹊径
    public static void main(String[] args) {

        long num = 2021041820210418L;
        //用HashSet存放num因子,自动解决因子重复问题
        HashSet<Long> common = new HashSet<>();
        //遍历到num的平方根技术，不需要都遍历一遍
        for (long i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                common.add(i);//可以整除就加入集合

                //i可以被整除，求出num的另外一个除数
                long n = num / i;
                if (n != i) {   //不加判断也行，因为我们用的hashset，但是系统判定超时
                    common.add(n);
                }
            }
        }
        System.out.println("common.size():" + common.size());
        System.out.println(common);
        long count = 0;
        //这里不需要三重循环，前两个数确定后，第三个数也就确定了
        for (Long i : common) {
            for (Long j : common) {
                long k = num / (i * j);
                if (i * j * k == num) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

}
