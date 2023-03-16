package 模拟题.第P页;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int a = scan.nextInt();
        int p = scan.nextInt();
        int min = (a * (p - 1)) + 1;
        int max = (a * (p - 1)) + a;
        if(max>t){
            max=t;
        }
        if(min>t){
            min=t;
        }
        System.out.println(min+" "+max);
        scan.close();
    }
}
