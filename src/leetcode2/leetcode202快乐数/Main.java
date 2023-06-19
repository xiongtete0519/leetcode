package leetcode2.leetcode202快乐数;

import java.util.HashSet;

public class Main {
    public static boolean flag=false;
    public static HashSet<Long> set = new HashSet<>();
    public static boolean isHappy(int n) {
        long sum=0;
        long ans=(long)n;
        while(ans>0){
            String s = String.valueOf(ans);
            char[] chars = s.toCharArray();
            for (int i = 0; i <chars.length; i++) {
                long tmp = Long.parseLong(String.valueOf(chars[i]));
                sum+=tmp*tmp;
            }
            if(sum==1){
                flag=true;
                break;
            }
            if(!set.contains(sum)){
                set.add(sum);
            }else{
                flag=false;
                break;
            }
            ans=sum;    //后续对ans计算各个数位的平方
            sum=0;
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(13));
    }
}
