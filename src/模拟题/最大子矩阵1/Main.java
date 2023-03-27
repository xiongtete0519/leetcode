package 模拟题.最大子矩阵1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {

    public static int[][] arr;
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int m = nextInt();
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j]=nextInt();
            }
        }
        int limit = nextInt();
        long ans=0;
        //前两层循环确定第一个坐标(i,j)
        //后两层循环确定第二个坐标(k,l)
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <m ; j++) {
                for (int k = i; k <n ; k++) {
                    for (int l = j; l <m; l++) {
                        if(fun(i,j,k,l)<=limit){
                            ans=Math.max(ans,(k-i+1)*(l-j+1));
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
    //计算从(i,j)到(k,l)的矩阵稳定度
    public static int fun(int i,int j,int k,int l){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (int m = i; m <=k; m++) {
            for (int n = j; n<=l; n++) {
                max=Math.max(max,arr[m][n]);
                min=Math.min(min,arr[m][n]);
            }
        }
        //返回矩阵稳定度:max-min
        return max-min;
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
