package 国赛打游击.二进制问题;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

//数位dp
public class Main1 {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static long n;
    static long k;
    static long[][] dp=new long[66][66];
    static int[] num=new int[66];   //存储二进制
    public static void main(String[] args) throws IOException {
        n=nextLong();
        k=nextLong();
        System.out.println(solve(n));
    }
    public static long solve(long n){
        //初始化dp数组为-1
        for (long[] longs : dp) {
            Arrays.fill(longs,-1);
        }
        int len=0;
//        System.out.println("二进制字符串测试:"+Long.toBinaryString(n));
        while(n!=0){    //将n的二进制表示存储到num里面
            //nu下标从1开始
            num[++len]=(int)(n&1);
            n>>=1;
        }
        //从最高位向最低为枚举
        return dfs(len,0,true);
    }

    /**
     *
     * @param len 当前是第几位
     * @param sum   当前1的数量
     * @param limit 是否达到上限
     * @return
     */
    public static long dfs(int len, int sum, boolean limit) {
        if(len==0){ //到最低位终止
            return sum==k?1:0;//是否满足恰好k个1
        }
        //记忆化搜索 limit=false&&dp[len][sum]!=-1    -1取反就是0
        if(dp[len][sum]!=-1&&!limit){
            return dp[len][sum];
        }
        //计算当前的上限：如果之前达到上限，那就是num的值，如果没有达到上限，二进制的上限为1
        int up=limit?num[len]:1;//num[len]表示数字n转换成二进制的第len位
        long res=0; //记录答案
        for (long i = 0; i <=up; i++) {//枚举第len位等于i
            //最高位向最低位dfs
            res+=dfs(len-1,sum+(i==1?1:0),limit&&i==up);
        }
        return dp[len][sum]=res;
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
