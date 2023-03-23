package 蓝桥杯.选数异或;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int x = scan.nextInt(); //异或结果
        Integer[] A = new Integer[n];   //数列
        Integer[][] arr = new Integer[m][2];    //存储查询的区间
        for (int i = 0; i < n; i++) {
            A[i]=scan.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j]=scan.nextInt();
            }
        }
        for (int i = 0; i <m; i++) {
            query1(A,arr[i][0],arr[i][1],x);
        }
        scan.close();
    }

    public static void query1(Integer[] arr, int l, int r, int x){
        for (int i = 0; i <arr.length ; i++) {
            for (int j = i+1; j <arr.length ; j++) {
                if((arr[i]^arr[j])==x&&arr[i]>=l&&arr[j]<=r){
                    System.out.println("yes");
                    return;
                }
            }
        }
        System.out.println("no");
    }
}
