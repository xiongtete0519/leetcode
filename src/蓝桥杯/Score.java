package 蓝桥杯;

import java.util.Scanner;

//成绩统计:计算及格率和通过率
public class Score {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] scores=new int[n];
        double good=0;
        double pass=0;
        for (int i = 0; i < n; i++) {
            scores[i] = scan.nextInt();
            if(scores[i]>=85)
                good++;
            if(scores[i]>=60)
                pass++;
        }
        System.out.println(Math.round(pass*100/n)+"%");
        System.out.println(Math.round(good*100/n)+"%");
        scan.close();
    }
}
