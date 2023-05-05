package 第十三届蓝桥杯国赛.最少的1;

import java.util.Scanner;
//50%  时间主要浪费在搜索i这里
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        long start = System.currentTimeMillis();
        int res=0;
        String s = Long.toBinaryString(n);
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i)=='1'){
                res++;  //统计二进制字符串中1的个数
            }
        }
        //时间浪费在这里了
        for (int i = 1; i <=1000000; i++) {
            String str = Long.toBinaryString(n * i);
//            System.out.println(str);
            if(str.contains("1")){
                int len=str.length()-str.replaceAll("1","").length();
                res=Math.min(res,len);
//                if(len<res){
//                    res=len;
//                    System.out.println(str);
//                }
            }
        }
        System.out.println(res);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        scan.close();

    }
}
