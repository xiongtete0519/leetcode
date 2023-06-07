package 第十二届蓝桥杯国赛.异或变换;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n=Integer.parseInt(tmp[0]);
        long t=Long.parseLong(tmp[1]);
        long[] s=new long[n];
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            s[i]=Long.parseLong(String.valueOf(str.charAt(i)));
        }
        for (int i = 0; i <t; i++) {
            fun(s);
            Arrays.stream(s).forEach(System.out::print);
            System.out.println();
        }
//        Arrays.stream(s).forEach(System.out::print);
    }

    public static void fun(long[] s) {
        long[] tmp = Arrays.copyOf(s, s.length);
        for (int i = 1; i <s.length; i++) {
            s[i]=tmp[i]^tmp[i-1];
        }
    }
}
