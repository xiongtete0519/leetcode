package 蓝桥杯.回文日期;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String date = scan.next();
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate localDate = LocalDate.parse(date, sdf);
//        System.out.println(localDate);
        String next = "";
        String ababbaba="";
        boolean flag=false;//标记是否找到第一个回文日期
        while(true){
            localDate= localDate.plusDays(1);
            if(huiwen(localDate)){  //先判断是否是回文
                if(!flag){
                    flag=true;  //标记已经找到第一个回文日期
                    next=sdf.format(localDate);
                }
                if(IsAB(localDate)){    //再校验是否是ABABBABA型日期
                    ababbaba=sdf.format(localDate);
                    break;
                }
            }
        }
        System.out.println(next);
        System.out.println(ababbaba);
    }
    //判断是否是回文日期：双指针法
    public static boolean huiwen(LocalDate localDate){
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyyMMdd");
        String s = sdf.format(localDate);
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
    //判断是否是ABABBABA型日期
    public static boolean IsAB(LocalDate localDate){
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyyMMdd");
        String s = sdf.format(localDate);
        char[] chars = s.toCharArray();
        if(chars[0]==chars[2]&&chars[2]==chars[5]&&chars[5]==chars[7]
        &&chars[1]==chars[3]&&chars[3]==chars[4]&&chars[4]==chars[6]){
            return true;
        }else{
            return false;
        }
    }
}
//20200202