package 模拟题.数值判断;


import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String s = String.valueOf(n);
        int pre = s.charAt(0) - '0';
        for (int i = 1; i <s.length() ; i++) {
            char c = s.charAt(i);
            int intValue = c - '0';
            if(intValue<=pre){
                System.out.println("NO");
                return;
            }
            pre=intValue;
        }
        System.out.println("YES");
        scan.close();
    }
}
