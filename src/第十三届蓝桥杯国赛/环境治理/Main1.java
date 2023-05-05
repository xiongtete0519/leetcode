package 第十三届蓝桥杯国赛.环境治理;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * 二分法优化枚举天数
 * 若第x天改善道路可以满足要求，则第x+1天同样能够满足要求，但是第x-1天不一定满足要求。
 * 故枚举天数满足单调性，可以使用二分枚举。
 */
public class Main1 {
    public static long[][] g;   //初始道路的灰尘度
    public static long[][] m;   //每条道路的最低灰尘度
    public static long[][] f;   //改善x天后的每条道路的环境
    public static int n;    //n个城市
    public static long q;   //期望达到的P指标
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        n=nextInt();
        q=nextLong();
        g=new long[n+1][n+1];
        m=new long[n+1][n+1];
        f=new long[n+1][n+1];

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {
                g[i][j]=nextLong();
            }
        }

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <= n; j++) {
                m[i][j]=nextLong();
                f[i][j]=m[i][j];
            }
        }
        //在每条道路都是最低复杂度的情况下，是否满足条件，不满足说明无解，直接返回-1
        if(floyd()>q){
            System.out.println(-1);
            return;
        }
        //二分法求需要改善的天数
        long left=0;
        long right=1000000000;
        while(left<right){
            long mid=(left+right)>>1;
            if(check(mid)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        System.out.println(right);
    }

    //改善x天
    public static boolean check(long x){
        for (int i = 1; i <=n; i++) {
            f[i]=Arrays.copyOf(g[i],g[i].length);
        }
        long h=x/n; //h轮
        long s=x%n;//新的一轮会改善到第几个点
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {
                if(i==j){
                    continue;
                }
                if(i<=s){
                    f[i][j]=Math.max(m[i][j],f[i][j]-h-1);
                }else{
                    f[i][j]=Math.max(m[i][j],f[i][j]-h);
                }
                f[j][i]=f[i][j];    //双向图
            }
        }
        //灰尘度是否满足条件
        return floyd()<=q;
    }
    public static long floyd(){
        long a=0;
        for (int k=1;k<=n;k++) {
            for (int i = 1; i <=n; i++) {
                for (int j = 1; j <=n; j++) {
                    f[i][j]=Math.min(f[i][j],f[i][k]+f[k][j]);
                }
            }
        }
        //计算p值
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {
                a+=f[i][j];
            }
        }
        return a;
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
