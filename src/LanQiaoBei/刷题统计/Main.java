package LanQiaoBei.刷题统计;

import java.util.Scanner;

public class Main {
    //只有60%的用例可以通过，剩下的超时了
    public static void count1() {
        Scanner scan = new Scanner(System.in);
        long a = scan.nextLong();   //周一至周五每天做a道题目
        long b = scan.nextLong();   //周六周日每天b道题目
        long n = scan.nextLong();
        int i = 1;
        int count = 0;
        while (count < n) {
            if (i % 7 >= 1 && i % 7 <= 5) {
                count += a;
            } else {
                count += b;
            }
            if (count >= n) {
                break;
            }
            i++;
        }
        System.out.println(i);
        scan.close();
    }
    //100%测试通过
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long a = scan.nextLong();   //周一至周五每天做a道题目
        long b = scan.nextLong();   //周六周日每天b道题目
        long n = scan.nextLong();
        //一周的刷题量
        long week = 5 * a + 2 * b;
        long temp = n / week;   //做了多少周
        long sub = n % week;//还剩下多少题没做
        if (sub == 0) { //可以被整除就直接输出
            System.out.println(temp * 7);
        } else {
            long count = 0;
            long i = 1;
            while (count < sub) {   //做完剩下的题需要几天
                if (i % 6 == 0) {   //此时最多6天，不用对7取模了
                    count += b;
                } else {
                    count += a;
                }
                if (count >= sub) {
                    break;
                }
                i++;
            }
            System.out.println(temp * 7 + i);
        }
        scan.close();
    }
}
