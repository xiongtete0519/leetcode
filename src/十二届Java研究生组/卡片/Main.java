package 十二届Java研究生组.卡片;

import java.util.Arrays;

public class Main {
    public static int[] cards=new int[10];  //代表0-9的卡片
    public static void main(String[] args) {
        Arrays.fill(cards, 2021);   //代表0-9的卡片各2021张
        for (long i = 1; i <=Long.MAX_VALUE ; i++) {
            if(!check(i)){
                System.out.println(i);
                break;
            }
        }
    }
    public static boolean check(long num){
        char[] chars = String.valueOf(num).toCharArray();
        for (char c : chars) {
            int temp = c - '0';
            cards[temp]--;
            if(cards[temp]<0){
                return false;
            }
        }
        return true;
    }
}
