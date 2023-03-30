package 模拟题.数数;

import java.util.*;
public class Main1{
    public static void main(String[] args) {
        int start=2333333,end=23333333;
        int[] isPrime =new int[end+1];
        int cnt=0;
        List<Integer> list = new ArrayList<>();
        for (int i =2; i <=end; i++) {
            if(isPrime[i]==0) {
                isPrime[i]=1;
                list.add(i);
            }
            if(i>=start&&isPrime[i]==12) cnt++;
            for (int j : list) {
                if(i*j>end) break;
                isPrime[i*j]=isPrime[i]+1;
                if(i%j==0) break;
            }
        }
        System.out.println(cnt);
    }

}
