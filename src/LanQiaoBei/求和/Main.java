package LanQiaoBei.求和;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //暴力解法，这种会超时。
    public static void sum1(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int sum=0;
        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            arr[i]=temp;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j =i+1; j <arr.length ; j++) {
                sum+=arr[i]*arr[j];
            }
        }
        System.out.println(sum);
        scanner.close();
    }

    /**
     *    不难发现如果输入1 3 6 9
     *    第一次两两相乘为1*3+1*6+1*9=1*(3+6+9)
     *    第二次两两相乘为3*6+3*9=3*(+6+9)
     *    第三次两两相乘为6*9=6*(9)
     *    最后相加，即每一次该数乘以sum内不包含本身的值
     */
    public static void sum2(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int sum=0;
        int result=0;
        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            arr[i]=temp;
            sum+=temp;  //直接刚开始就对数组求和
        }
        for (int i = 0; i < arr.length; i++) {
            result+=arr[i]*(sum-arr[i]);
            sum-=arr[i];
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
//        sum1();
        sum2();
    }
}
