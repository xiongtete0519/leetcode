package LanQiaoBei.统计子矩阵;

import java.util.Scanner;

public class Test {
    private static int n =3;
    private static int m=4;
    private static int K=10;
    private static int count=0;
    private static Integer[][] arr;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        K = scan.nextInt();
        arr = new Integer[n][m];
        int sumTemp=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scan.nextInt();
            }
        }

        /**
         * 第一二层循环确定矩阵的第一个坐标
         * 第三四层循环确定矩阵的第二个坐标
         * 第五六层循环把两个坐标点确定的矩阵元素求和(其实就是遍历)
         */
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <m; j++) {
                for (int k = i; k <n ; k++) {
                    for (int l = j; l <m ; l++) {
//                        System.out.println(i+" "+j+" "+k+" "+l);
                        //两个坐标点(i,j)  (k,l)
                        sumTemp=sum(i,j,k,l);
                        if(sumTemp<=K){
                            count++;
                        }else{
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(count);


    }
    //计算(i,j)到(k,l)两个坐标点确定的矩阵元素的和 和遍历一样
    public static int sum(int i,int j,int k,int l){
        int sum=0;
        for (int m = i; m <=k ; m++) {
            for (int n = j; n <=l; n++) {
                sum+=arr[m][n];
            }
        }
        return sum;
    }
}
