package 模拟题.数值判断;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String s = String.valueOf(n);
        for (int i = 0; i <s.length()-1 ; i++) {
            if(s.charAt(i)>=s.charAt(i+1)){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
        scan.close();
    }
}
