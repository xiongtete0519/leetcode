package 国赛刷题挑战.斐波那契与7;

import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        BigInteger[] arr = new BigInteger[100000];
//        Arrays.fill(arr,BigInteger.ZERO);
//        arr[1]=new BigInteger("1");
//        arr[2]=new BigInteger("1");
//        System.out.println(arr[1]);
//        System.out.println(arr[2]);
//        long ans=0;
//        for (int i = 3; i <=1000; i++) {
//            arr[i]=arr[i-1].add(arr[i-2]);
//            BigInteger tmp = arr[i].mod(new BigInteger("10"));
//            if(tmp.compareTo(new BigInteger("7"))==0){
//                ans++;
//            }
//            if(i%100==0){
//                System.out.println(ans);
//            }
//        }
        BigInteger f = new BigInteger("202202011200");
        System.out.println(f.divide(new BigInteger("300")).multiply(new BigInteger("40")));
    }
}
