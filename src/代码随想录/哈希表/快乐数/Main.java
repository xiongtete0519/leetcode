package 代码随想录.哈希表.快乐数;

import java.util.HashSet;

public class Main {
    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n!=1&&!set.contains(n)){
            set.add(n);
            n=nextNumber(n);
        }
        return n==1;
    }
    //计算数位平方和
    public static int nextNumber(int n){
        int sum=0;
        while(n>0){
            int x=n%10;
            sum+=x*x;
            n=n/10;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
