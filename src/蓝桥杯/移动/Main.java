package 蓝桥杯.移动;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x=0;
        int y=0;
        String s = scan.next();
        for (int i = 0; i < s.trim().length(); i++) {
            if(s.charAt(i)=='U'){
                x=x-1;
            }else if(s.charAt(i)=='D'){
                x=x+1;
            }else if(s.charAt(i)=='L'){
                y=y-1;
            }else if(s.charAt(i)=='R'){
                y=y+1;
            }
        }
        System.out.println(x+" "+y);
        scan.close();
    }
}
