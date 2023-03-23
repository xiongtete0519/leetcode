package 蓝桥杯.补齐回文串;

import java.util.Scanner;

/**
 * 本题只需要在右边补齐即可，所以我们只需要将左边的字母一个个补齐到右边，每补一次
 * 都需要判断下当前字符串是否是回文串
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        StringBuilder str= new StringBuilder();
        if(backJudge(s)){
            System.out.println(s);
        }else{
            for (int i = 0; i <s.length(); i++) {
                //将左边的字母拼接到右边(注意是在旧str的前边拼接)
                // str = s.charAt(i) + str
                str.insert(0, s.charAt(i));
                if(backJudge(s+str)){
                    System.out.println(s+str);
                    return;
                }
            }
        }
        scan.close();
    }
    //判断回文串
    public static boolean backJudge(String s){
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
    //双指针判断回文串
    public static boolean backStr(String s){
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
