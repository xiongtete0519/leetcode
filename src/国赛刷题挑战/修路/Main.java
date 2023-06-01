package 国赛刷题挑战.修路;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * f[i][j][k]表示道路A走过前i个点，道路B走过前j个点，k为0时表示最终停在道路A，k为1时表示最终停在道路B的最短距离
 */
public class Main {
    public static int N = 2010;
    public static int n,m;
    public static int d;
    public static int[] A=new int[N];
    public static int[] B=new int[N];
    public static double[][][] f=new double[N][N][2];
    public static int inf=Integer.MAX_VALUE;
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        n=nextInt();
        m=nextInt();
        d=nextInt();
        for (int i = 1; i <=n ; i++) {
            A[i]=nextInt();
        }
        for (int i = 1; i <=m ; i++) {
            B[i]=nextInt();
        }
        Arrays.sort(A,1,n+1);
        Arrays.sort(B,1,m+1);
        double sb=dis(B[1],0,d);
        for (int i = 1; i <=n ; i++) {
            f[i][0][0]=A[i];
            f[i][0][1]=inf;
        }
        //遍历下面
        for (int i = 1; i <=m ; i++) {
            f[0][i][1]=sb+B[i]-B[1];
            f[0][i][0]=inf;
        }
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=m ; j++) {
                f[i][j][0]=Math.min(f[i-1][j][0]+A[i]-A[i-1],f[i-1][j][1]+dis(A[i],B[j],d));
                f[i][j][1]=Math.min(f[i][j-1][1]+B[j]-B[j-1],f[i][j-1][0]+dis(A[i],B[j],d));
            }
        }
        double ans=Math.min(f[n][m][0],f[n][m][1]);
        System.out.printf("%.2f",ans);

    }
    public static double dis(long x,long y,double w){       //勾股定理
        return Math.sqrt((x-y)*(x-y)+w*w);
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
    public static long nextLong() throws IOException{
        st.nextToken();
        return (long)st.nval;
    }
}
