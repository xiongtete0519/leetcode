package LanQiaoBei.最大子矩阵;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            arr[i][0]=scan.nextInt();
            arr[i][1]=scan.nextInt();
            arr[i][2]=scan.nextInt();
            arr[i][3]=scan.nextInt();
        }
        int limit = scan.nextInt();
        int maxArea=0;//记录最大面积
        //统计符合条件的子矩阵，面积越大越好
        //第一重循环确定第一个坐标
        //第二重循环确定第二个坐标
        for (int i = 0; i <N; i++) {
            for (int j = 0; j <M ; j++) {
                for (int k = i; k < N; k++) {
                    for (int l = j; l <M ; l++) {
                        if(FM(arr,i,j,k,l)<=limit){//判断稳定度
                            maxArea=Math.max(maxArea,area(i,j,k,l));
                        }
                    }
                }
            }
        }
        System.out.println(maxArea);
        scan.close();
    }
    //通过矩阵两个坐标点计算矩阵稳定度
    public static Integer FM(int[][] arr,int i,int j,int k,int l){
        int max=arr[0][0];
        int min=arr[0][0];
        for (int m = i; m <= k; m++) {
            for (int n = j; n <= l; n++) {
                if(arr[m][n]>max){
                    max=arr[m][n];
                }
                if(arr[m][n]<min){
                    min=arr[m][n];
                }
            }
        }
        //f(m)=f(max)-f(min)
        return max-min;
    }
    //计算矩阵面积(本题为元素个数)
    public static Integer area(int i,int j,int k,int l){
        return ((k-i)+1)*((l-j)+1);
    }
}
