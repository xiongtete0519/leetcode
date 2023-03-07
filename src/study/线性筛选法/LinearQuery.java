package study.线性筛选法;

import java.util.ArrayList;
import java.util.List;
//线性筛选法
public class LinearQuery {
    public static void main(String[] args) {
        List<Integer> list = linearSieve(5);
        System.out.println(list);
    }

    public static List<Integer> linearSieve(int n) {
        //记录每个数是否为素数，下标0-n分别对应着数0-n,初始都为false
        boolean[] isPrime = new boolean[n + 1];
        //记录已经找到的素数
        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (isPrime[i] == false) {
                primes.add(i);   //加入素数列表
            }
            //遍历素数列表，将当前素数和i的乘机及其倍数标记为非素数
            for (int j = 0; j < primes.size() && primes.get(j) * i <= n; j++) {
                isPrime[primes.get(j) * i] = true;
                //如果当前素数能够整除i,则说明i已经被之前的素数筛选过了，因此可以直接退出当前循环
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes;
    }

}
