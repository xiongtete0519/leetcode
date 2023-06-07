package 第十二届蓝桥杯国赛.异或变换;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n=Integer.parseInt(tmp[0]);
        long t=Long.parseLong(tmp[1]);
        long[] s=new long[n];
        long count=0;//统计多少次异或操作可以复原
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            s[i]=Long.parseLong(String.valueOf(str.charAt(i)));
        }
        long[] original = Arrays.copyOf(s, s.length);    //保留初始值
        boolean flag=false; //没执行完就复原的标记
        for (int i = 0; i <t ; i++) {
            fun(s);
            count++;
            //比较异或结果是否和初始值相等
            if(Arrays.equals(s,original)){
                flag=true;
                break;
            }
        }
        if(flag){   //没执行完就复原，直接取模再算会非常快
            long x=t%count;
            for (int i = 0; i < x; i++) {
                fun(s);
            }
        }
        Arrays.stream(s).forEach(System.out::print);
    }

    public static void fun(long[] s) {
        long[] tmp = Arrays.copyOf(s, s.length);
        for (int i = 1; i <s.length; i++) {
            s[i]=tmp[i]^tmp[i-1];
        }
    }
}
