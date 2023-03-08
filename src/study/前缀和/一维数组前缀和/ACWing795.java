package study.前缀和.一维数组前缀和;

import java.util.ArrayList;
import java.util.Scanner;
//一维数组的前缀和
public class ACWing795 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m=scan.nextInt();
        int[] arr = new int[n+1];
        int[] s = new int[n + 1];
        for (int i = 1; i <=n ; i++) {
            arr[i]=scan.nextInt();
        }
        //计算前缀和
        for (int i = 1; i <=n ; i++) {
            s[i]=s[i-1]+arr[i];
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <m ; i++) {
            int left = scan.nextInt();
            int right = scan.nextInt();
            int sum = s[right] - s[left - 1];
            list.add(sum);
        }
        list.forEach(System.out::println);

    }
}
