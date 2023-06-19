package leetcode2.leetcode202快乐数;

import java.util.HashSet;

public class Main1 {
    public static int getNext(int n){
        int sum=0;
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int d = Integer.parseInt(String.valueOf(chars[i]));
            sum+=d*d;
        }
        return sum;
    }
    public static boolean isHappy(int n){
        HashSet<Integer> set = new HashSet<>();
        while(n!=1&&!set.contains(n)){
            set.add(n);
            n=getNext(n);
        }
        return n==1;
    }
    public static void main(String[] args) {
        System.out.println(isHappy(13));
    }
}
