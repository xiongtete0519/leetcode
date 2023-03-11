package 模板题.小明的彩灯;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int Q = scan.nextInt();
        int[] nums = new int[N + 1];    //原数组
        int[] arr = new int[N + 2];     //差分数组，这里不写N+2,下面的arr[right+1]就越界了
        int[] result = new int[N + 1];  //对差分数组求前缀和后的结果
        for (int i = 1; i <=N ; i++) {
            nums[i]=scan.nextInt();
        }
        //初始化差分数组
        for (int i = 1; i <=N ; i++) {
            arr[i]=nums[i]-nums[i-1];
        }
        //开始操作
        for (int i = 0; i <Q; i++) {
            int left=scan.nextInt();
            int right = scan.nextInt();
            int x = scan.nextInt();
            arr[left]+=x;
            arr[right+1]-=x;
        }
        //计算前缀和：我们给差分数组求前缀和即可得到原数组
        for (int i = 1; i <=N ; i++) {
            result[i]=result[i-1]+arr[i];
        }
        //这里要注意下，题中要求小于0的数字直接输出0，这里跳过数组第一个元素
        Arrays.stream(result).skip(1).map(x-> x<0?0:x).forEach(x->{
            System.out.print(x+" ");
        });

    }

}
