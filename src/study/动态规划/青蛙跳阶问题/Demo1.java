package study.动态规划.青蛙跳阶问题;


import java.util.HashMap;

/**
 * 一只青蛙，可以一次跳上1级台阶，也可以一次跳上2级台阶。求这只青蛙跳10级台阶有多少种跳法？
 *
 * 分析：
 *
 * - 要跳到第10级台阶，要么从第8级台阶，跳2级到第10级。要么从第9级跳1步到第十级。
 * - 要跳到第9级：可以从第8级跳1步到达，也可以从第7级跳两步到达。
 * - 要跳到第8级：可以从第7级跳1步到达，也可以从第6级跳两步到达。
 * - ............
 * 假设跳到第n 级台阶的跳法是 f(n)，那么：
 *
 * > f(10) = f(9) + f(8)
 * >
 * > f(9) = f(8) + f(7)
 * >
 * > f(8) = f(7) + f(6)
 * >
 * > ......
 * >
 * > f(2) = 2:第2级可以一次跳1步，跳两次，也可以一次跳2步
 * >
 * > f(1) = 1：只能一次跳1步
 */
//第一种：自顶向下求解
public class Demo1 {
    public static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println(way(40));
        long l1 = System.currentTimeMillis();
        System.out.println(way1(40));
        long l2 = System.currentTimeMillis();
        System.out.println("第一种方法耗时:"+(l1-l));
        System.out.println("第二种方法耗时:"+(l2-l1));

    }
    //暴力递归：时间复杂度=解决子问题的事件*子问题的个数(存在大量重复运算)
    public static int way(int n){//n是总共有多少个台阶
        if(n==1){   //跳1步到第1级台阶
            return 1;
        }
        if(n==2){//跳2个1，或者跳1个2到第二级台阶
            return 2;
        }
        //从n-1级跳1步，从n-2级跳2步
        return way(n-1)+way(n-2);
    }
    //改进：通过字典存储子问题的解：数组或者map
    public static int way1(int n){//n是总共有多少个台阶
        if(n==1){   //跳1步到第1级台阶
            return 1;
        }
        if(n==2){//跳2个1，或者跳1个2到第二级台阶
            return 2;
        }
        if (!map.containsKey(n)) {
            map.put(n, way1(n - 1) + way1(n - 2));
        }
        return map.get(n);
    }
}
