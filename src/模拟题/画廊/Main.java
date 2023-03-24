package 模拟题.画廊;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
//dp[i][j][k]表示左边处理到第i个，右边处理到第j个，当前位置在k的情况，
// k只有两个值，0表示在左边，1表示在右边
public class Main {
    public static final int INF=Integer.MAX_VALUE;
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int L = nextInt();//左边作品数量
        int R = nextInt();//右边作品数量
        int d = nextInt();//画廊长度
        int w = nextInt();//画廊宽度
        int[] left = new int[L + 1];
        int[] right = new int[R + 1];
        for (int i = 1; i <=L ; i++) {
            left[i]=nextInt();
        }
        for (int i = 1; i <=R ; i++) {
            right[i]=nextInt();
        }
        //左边 右边 位置  对于左边已处理第i个，右边已处理第j个，当前位置在k(1,2)时的状态
        double[][][] dp = new double[L + 1][R + 1][2];
        double wr = (double) w / 2;
        double a = Math.sqrt(wr * wr + left[1] * left[1]);  //第一步往左边走的距离
        double b = Math.sqrt(wr * wr + right[1] * right[1]);//第一步往右边走的距离
        //初始化，即单走左边或者单走右边的情况
        for (int i = 1; i <=L; i++) {
            dp[i][0][0]=a+left[i]-left[1];
            dp[i][0][1]=INF;//因为是单边走，所以另一边的位置的值是无效的
        }
        for (int i = 1; i <=R; i++) {
            dp[0][i][1]=b+right[i]-right[1];
            dp[0][i][0]=INF;//因为是单边走，所以另一边的位置的值是无效的
        }

        /**
         * 状态转移:对于dp[i][j][0],即处理左第i个右第j个当前位置为左时，此时要么是由左边上一格，要么从右边横过来
         * 对于dp[i][j][0]代表的含义是：1、在左边 2、要处理的是左边的i  3、右边的j个已经处理完了。
         * 但注意，不可能由右下过来，从dp的定义来看，是[已处理]，如果是从右下过来，那么就不能说是[已处理到第j个在左边的情况]
         * 即i只能从i-1的情况转移过来，j也只能从j-1的情况转移过来
         * 状态转移:dp[i][j][0]=min(dp[i-1][j][0]+left[i]-left[i-1],dp[i-1][j][1]+dis(left[i],right[j]))
         */
        for (int i = 1; i <=L ; i++) {
            for (int j = 1; j <=R; j++) {
                //因为在左边，所以肯定要从i-1,j到达，不能从i,j-1到达，因为那样代表左边已经处理完了
                //从左边到和从右边到的距离取最小值
                dp[i][j][0]=Math.min(dp[i-1][j][0]+left[i]-left[i-1],
                        dp[i-1][j][1]+dis(left[i],right[j],w));
                //从j-1到达
                dp[i][j][1]=Math.min(dp[i][j-1][0]+dis(left[i],right[j],w),
                        dp[i][j-1][1]+right[j]-right[j-1]);
            }
        }
        double res = Math.min(dp[L][R][0] + dis(d, left[L], (double) w / 2), dp[L][R][1] + dis(d, right[R], (double) w / 2));
        System.out.printf("%.2f",res);
    }
    //勾股定理计算第三条边
    public static double dis(double a,double b,double w){
        double cur = Math.abs(a - b) * Math.abs(a - b);
        return Math.sqrt(cur+w*w);
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
