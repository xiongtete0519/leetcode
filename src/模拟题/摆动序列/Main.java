package 模拟题.摆动序列;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
    public static int[][] arr;
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException{
        int m = nextInt();
        int n = nextInt();
        arr = new int[m + 1][n + 1];
        long res=0;
        //dp[i][j]:第i为放j值可以有几种放法
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <=dp[0].length-1; i++) {
            dp[1][i]=1;
        }
        arr[1][n]=n;
        //遍历
        for (int i = 2; i <=dp.length-1; i++) {
            for (int j = 1; j <=dp[i].length-1 ; j++) {
                if(i%2!=0){
                    dp[i][j]=arr[i-1][j-1]%10000;
                    //最后一个位置 不断累加用于下一行偶数的时候 dp[i][j]=dp[i][j+1]+...+dp[i][n]
                    arr[i][n]=arr[i][n]+dp[i][j];
                }else{
                    arr[i-1][n]=arr[i-1][n]-dp[i-1][j];
                    dp[i][j]=arr[i-1][n]%10000;
                    //用于累计元素的值，下一行奇数的时候：dp[i][j]=dp[i][1]+...+dp[i][j-1]
                    arr[i][j]=arr[i][j-1]+dp[i][j];
                }
            }
        }
        for (int j = 1; j <=n ; j++) {
            res+=dp[m][j];
        }
        System.out.println(res%10000);
        Arrays.stream(dp).forEach(x->{
            System.out.println(Arrays.toString(x));
        });
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
