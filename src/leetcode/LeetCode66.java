package leetcode;

import java.util.Arrays;

public class LeetCode66 {
    public static int[] plusOne(int[] digits){
        for(int i = digits.length-1; i >=0 ; i--) {
            if(digits[i]==9){
                digits[i]=0;
            }else{
                digits[i]+=1;
                return digits;
            }
        }
        //如果所有位都是进位，则长度+1
        digits=new int[digits.length+1];
        digits[0]=1;
        return digits;
    }

    public static void main(String[] args) {
//        System.out.println(plusOne(new int[]{1, 2, 3}));
//        int[] one = plusOne(new int[]{9});
        int[] one = plusOne(new int[]{9,8,7,6,5,4,3,2,1,0});
        Arrays.stream(one).forEach(System.out::println);
    }
}
