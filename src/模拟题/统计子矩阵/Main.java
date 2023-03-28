package 模拟题.统计子矩阵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
    public static int[][] a;
    public static int[][] s;
    public static long ans;
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException{
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();
        a = new int[n+1][m+1];
        s = new int[n+1][m+1];  //二维数组前缀和
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j]=nextInt();
                s[i][j]=s[i][j-1]+s[i-1][j]-s[i-1][j-1]+a[i][j];    //计算前缀和
            }
        }
//        Arrays.stream(a).forEach(x->{
//            System.out.println(Arrays.toString(x));
//        });
//        System.out.println("----");
//        Arrays.stream(s).forEach(x->{
//            System.out.println(Arrays.toString(x));
//        });
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=m ; j++) {
                for (int l = i; l <=n; l++) {
                    for (int o = j; o <=m ; o++) {
                        if(matrixSum(i,j,l,o)<=k){
                            ans++;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
    //求子矩阵的和
    public static long matrixSum(int x1,int y1,int x2,int y2){
        return s[x2][y2]-s[x2][y1-1]-s[x1-1][y2]+s[x1-1][y1-1];
    }

}
