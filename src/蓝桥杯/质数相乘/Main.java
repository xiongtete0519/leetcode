package 蓝桥杯.质数相乘;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int start=2333333,end=23333333;
        //创建一个end+1的数组，存储每个数的质因子个数，初始值都为0
        int[] isPrime =new int[end+1];
        int cnt=0;  //计数恰好有12个质因子的数字数量
        //用于存储找到的质数
        List<Integer> list = new ArrayList<Integer>();
        for (int i =2; i <=end; i++) {
            if(isPrime[i]==0) { //i是一个质数。
                isPrime[i]=1;
                list.add(i);    //加入质数集合
            }
            if(i>=start&&isPrime[i]==12)
                cnt++;
            for (int x : list) {    //遍历质数集合
                if(i*x>end)
                    break;
                isPrime[i*x]=isPrime[i]+1;  //意味着i*x比数字i多一个质因子
                //如果当前素数能够整除i,则说明i已经被之前的素数筛选过了，因此可以直接退出当前循环
                if(i%x==0)
                    break;
            }
        }
        System.out.println(cnt);
    }
}
