package LanQiaoBei.最优清零方案;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();

        long[] arr = new long[n];
        for (int i = 0; i <arr.length; i++) {
            arr[i]=scan.nextLong();
        }
        System.out.println(process(arr, k));
    }

    /**
     * 计数器count=0
     * 其实主要是看最多能进行几次操作2，利用滑动窗口，每次找到k长度区间内的最小值min，
     * 如果该区间内的数字都是K个大于0的整数，那就让该区间的所有值都减去这个最小值min，计数改变count+min
     * 滑动窗口执行结束之后，此时已经没有连续k个大于0的整数区间了，接下来要对剩下的所有数组进行减1的操作，为了方便
     * 这里直接对数组中的所有元素求和即可，最后结果为count+sum(arr)
     */
    public static long process(long[] arr,int k){
        long count=0;
        int m=0;
        while (m<=arr.length-k) {
            long min=Integer.MAX_VALUE;
            int index=-1;   //记录k个值最小的索引
            for (int i = m; i <m+k ; i++) {
                //找到k个值最小的index
                if(arr[i]<=min){
                    min=arr[i];
                    index=i;
                }
            }
            //区间内所有的值减去min
            for (int i = m; i <m+k ; i++) {
                arr[i]-=min;
            }
            count+=min; //计数
            m=index+1;  //索引移动到先置0的数字的右边
        }
        //循环结束之后，已经没有连续k个不为零的区间了，直接将数组元素求和就是减1的次数
        long sum = Arrays.stream(arr).sum();
        count+=sum;
        return count;
    }

}
