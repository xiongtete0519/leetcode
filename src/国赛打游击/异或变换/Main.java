package 国赛打游击.异或变换;

import java.util.Arrays;
import java.util.Scanner;
//Main2:找到哪一步异或重复了，然后直接取模会节省大量时间
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long count=0;   //统计异或操作需要多少步才能复原
        int n = scan.nextInt();
        long t = scan.nextLong();
        long[] s = new long[n];
        String str = scan.next();
        for (int i = 0; i <str.length() ; i++) {
            s[i]=Long.parseLong(String.valueOf((str.charAt(i))));
        }
        long[] tmp = Arrays.copyOf(s, s.length);//保留初始值
        boolean flag=false;
        for (int i = 0; i <t; i++) {
            fun(s);
            count++;
           if(Arrays.equals(s,tmp)){    //异或结果是否和初始值相等
               flag=true;
               break;
           }
        }
        if(flag){   //如果没执行完就复原了，那直接取模计算会非常快
            long x=t%count;
            for (long i = 0; i < x; i++) {
                fun(s);
            }
        }//else 没复原之前就结束了，那直接输出即可
        for (long l : s) {
            System.out.print(l);
        }
    }
    public static void fun(long[] s){
        //copyof方法拷贝一维数组和二维数组的区别？
        long[] tmp = Arrays.copyOf(s, s.length);
        for (int i = 1; i <tmp.length; i++) {
            s[i]=tmp[i]^tmp[i-1];
        }
    }

}
