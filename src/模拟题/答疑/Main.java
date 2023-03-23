package 模拟题.答疑;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] nums = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                int num = scan.nextInt();
                nums[i][j] = num;
            }
        }
        // 排序
        Arrays.sort(nums, (a,b) -> (a[0]+a[1]+a[2]) - (b[0]+b[1]+b[2]));
        // 计算最小时间
        long ans = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                sum+= nums[i][j];
                if (j == 1) ans+=sum;
            }
        }
        System.out.println(ans);
        scan.close();
    }
}