package 国赛复习.部分省赛复习.统计子矩阵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static long[][] a;
    public static long[][] s;    //二维前缀和数组
    public static long ans;
    public static long k;
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int n=nextInt();
        int m=nextInt();
        k=nextLong();
        a=new long[n+1][m+1];
        s=new long[n+1][m+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m; j++) {
                a[i][j]=nextLong();
                s[i][j]=s[i][j-1]+s[i-1][j]-s[i-1][j-1]+a[i][j];    //计算前缀和
            }
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                for (int l = i; l <=n ; l++) {
                    for (int o = j; o <=m ; o++) {
                        if(check(i,j,l,o)){
                            ans++;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
    //子矩阵的和是否小于等于k
    public static boolean check(int x1,int y1,int x2,int y2){
        long sum=0;
        for (int i = x1; i <=x2 ; i++) {
            for (int j = y1; j <=y2 ; j++) {
                sum+=a[i][j];
            }
        }
        return sum<=k;
    }
    public static int nextInt() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }
    public static long nextLong() throws IOException{
        st.nextToken();
        return (long)st.nval;
    }
}
