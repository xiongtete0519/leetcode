package 模板题.小明的彩灯;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); //彩灯数量
        int Q = scan.nextInt(); //操作次数
        long[] arr = new long[N + 1];
        //初始化彩灯的初始亮度
        for (int i = 1; i <= N; i++) {
            arr[i]=scan.nextInt();
        }
        //对彩灯的操作
        for (int i = 0; i <Q; i++) {
            int left = scan.nextInt();
            int right = scan.nextInt();
            int x = scan.nextInt();
            for (int j = left; j <=right ; j++) {
                arr[j]+=x;
                if(arr[j]<=0){
                    arr[j]=0;
                }
            }
        }
        //跳过第一个元素
        Arrays.stream(arr).skip(1).forEach(x->{
            System.out.print(x+" ");
        });
    }

}
