package LanQiaoBei.质因数个数;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n=scan.nextLong();
        List<Long> factor = factor(n);
        long count=0L;
        for (Long f : factor) {
            if (judge(f)) {
                count++;
            }
        }
        System.out.println(count);
        scan.close();
    }
    //返回因子list
    public static List<Long> factor(long n){
        ArrayList<Long> arr = new ArrayList<>();
        for (long i = 1L; i <=Math.sqrt(n) ; i++) {
            if(n%i==0){
                arr.add(i);
                if(i!=n/i){
                    arr.add(n/i);
                }
            }
        }
        return arr;
    }
    //判断因子是否是质数
    public static boolean judge(long n){
        if(n==0||n==1){
            return false;
        }
        for (long i = 2L; i <=Math.sqrt(n); i++) {
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
