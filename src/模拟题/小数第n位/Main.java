package 模拟题.小数第n位;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long a = sc.nextLong();
    long b = sc.nextLong();
    int n = sc.nextInt();
    while (n - 10 > 0) { //快速减小n,逼近第n位
      a *= 1e10; //不能*的太大，否则会溢出
      a %= b;
      n -= 10;
    }
    for (int i = 1; i < n + 3; i++) {
      a *= 10;//因为之前是对b取余得到的，所以此时的a一定小于b，对a*10，再对b取余可获得一位小数
      if (i >= n) { //开始输出三个位
        System.out.print(a / b);
      }
      a %= b;//所说的取余
    }
    System.out.println();
  }
}