package 蓝桥杯.统计子矩阵;

import java.util.Scanner;

public class Main {
    private static int N =3;
    private static int M=4;
    private static int K=10;
    private static int count=0;
    private static Integer[][] arr;
//    private static Integer[][] arr={
//            {1,2,3,4},
//            {5,6,7,8},
//            {9,10,11,12}
//    };

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        K = scan.nextInt();
        arr = new Integer[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = scan.nextInt();
            }
        }

        int i, j;
        for (int n = 1; n <= N; n++) {
            for (int m = 1; m <= M; m++) {
                for (i = 0, j = 0; i < N && j < M; i = i + n, j = j + m) {
                    find(i, j, n, m);
                }
            }
        }
        System.out.println(count);
    }

    private static void find(int px, int py, int n, int m) {
        //横向滑动窗口
        for (int i = px,j=py; j<M ; j++) {
            int t=sumAll(i,j,n,m);
            if(t!=-1&&t<=K)
                count++;
        }
        //纵向滑动窗口
        for (int i = px+n,j=py;i<N; i++) {
            int t=sumAll(i,j,n,m);
            if(t!=-1&&t<=K)
                count++;
        }
    }

    private static int sumAll(int px, int py, int n, int m) {
        int sum=0;
        if(px+n>N||py+m>M)
            return -1;
        for (int i = px; i <n+px ; i++) {
            for (int j = py; j <m+py ; j++) {
                sum+=arr[i][j];
            }
        }
        return sum;
    }

}
