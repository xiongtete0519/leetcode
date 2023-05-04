package 十一届蓝桥杯国赛.循环小数;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int p = scan.nextInt();
        int q = scan.nextInt();
        long decimal = scan.nextLong();

        if(p==1){   //纯循环小数
            //分子
            long x=decimal;
            //分母
            long y=(long)Math.pow(10,q)-1;
//            System.out.println("x="+x);
//            System.out.println("y="+y);
            System.out.println(x/gcd(x,y)+" "+y/gcd(x,y));
        }else{  //混合循环小数
            //取出decimal的前(p-1)位
            String s = String.valueOf(decimal);
            String sub = s.substring(0, p-1);
            long tmp = Long.parseLong(sub);
            //分子
            long x=decimal-tmp;
            //分母
            long y=(long)Math.pow(10,q)-(long)Math.pow(10,p-1);
//            System.out.println("x="+x);
//            System.out.println("y="+y);
            System.out.println(x/gcd(x,y)+" "+y/gcd(x,y));
        }


        scan.close();
    }
    public static long gcd(long a,long b){
        if(b==0){
            return a;
        }
        long max=Math.max(a,b);
        long min=Math.min(a,b);
        return gcd(min,max%min);
    }
}
