package 模板题.回文判定;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        System.out.println(backStringJudge(s));

    }
    //双指针判断回文串
    public static boolean backStringJudge(String s){
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}
