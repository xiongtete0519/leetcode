package LanQiaoBei.选数异或;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int x = scan.nextInt(); //异或结果
        Integer[] A = new Integer[n+1];   //数列
        Integer[][] arr = new Integer[m][2];    //存储查询的区间
        for (int i = 1; i <= n; i++) {
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
    }
    //遍历[l,r]区间中是否存在两个异或结果为x的数字
    public static boolean query(Integer[] arr,int l,int r,int x){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j <arr.length ; j++) {
                if((arr[i]^arr[j])==x){
                    return true;
                }
            }
        }
        return false;
    }
    public static void query1(Integer[] arr, int l, int r, int x){
        for (int i = l; i <=r; i++) {
            for (int j = l+1; j <=r; j++) {
                if((arr[i]^arr[j])==x){
                    System.out.println("yes");
                    return;
                }
            }
        }
        System.out.println("no");
    }
}
