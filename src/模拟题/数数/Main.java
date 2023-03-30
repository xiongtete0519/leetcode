package 模拟题.数数;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        fun(28);
//        System.out.println(zhishu(2));
        long sum=0;
        for (int i =2333333; i <= 23333333; i++) {
            if(fun(i)){
                sum++;
            }
        }
        System.out.println(sum);
    }
    //[2333333, 23333333]中可被拆分为12个质数相乘的
    //找到所有的质因子
    public static boolean fun(int num){
        int temp=num;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i <=Math.sqrt(num); i++) {
            if(num%i==0){
                if(isPrime(i)){
                    list.add(i);
                    temp/=i;
                }
                int j = num / i;
                if(isPrime(j)){
                    list.add(j);
                    temp/=j;
                }
            }
        }
        if(temp!=1&&isPrime(temp)){
            list.add(temp);
        }
//       list.forEach(x->{
//           System.out.print(x+" ");
//       });
        return list.size()==12;
    }
    //判断质数
    public static boolean isPrime(int num){
        for (int i = 2; i <=Math.sqrt(num); i++) {
            if(num%2==0){
                return false;
            }
        }
        return true;
    }
}
