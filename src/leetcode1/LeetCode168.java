package leetcode1;

import java.util.Arrays;
import java.util.List;

/**
 * Excel表列名称
 * 方法：进制转换，但是本题没有0，需要在转换操作前对columnNumber进行减一操作
 */
public class LeetCode168 {
    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber>0){
            columnNumber--;
            sb.append((char)(columnNumber%26+'A'));
            columnNumber/=26;
        }
        sb.reverse();
        return sb.toString();
    }
    public static String convertToTitle1(int columnNumber){
        String[] a = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        List<String> list = Arrays.asList(a);
        StringBuilder sb = new StringBuilder();
        int index=0;
        while (columnNumber>26){
            index=columnNumber%26;
            if(index==0){
                index=26;
            }
            columnNumber-=index;
            columnNumber/=26;
            sb.append(list.get(index-1));
        }
        sb.append(list.get(columnNumber-1));
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(28));
//        System.out.println(convertToTitle1(28));
        System.out.println(convertToTitle1(701));
    }
}
