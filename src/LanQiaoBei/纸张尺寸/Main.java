package LanQiaoBei.纸张尺寸;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int n = Integer.parseInt(String.valueOf(s.charAt(1)));
        int a = 1189;
        int b = 841;
        if (n == 0) {
            System.out.println(a);
            System.out.println(b);
        } else {
            int longSide = Math.max(a, b); //长边
            int shortSide = Math.min(a, b);//短边
            for (int i = 0; i < n; i++) {
                if (longSide < shortSide) {
                    int temp = longSide;
                    longSide = shortSide;
                    shortSide = temp;
                }
                longSide /= 2;
            }
            System.out.println(Math.max(longSide, shortSide));
            System.out.println(Math.min(longSide, shortSide));
        }
        scan.close();

    }
}
