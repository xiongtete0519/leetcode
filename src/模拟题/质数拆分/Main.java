package 模拟题.质数拆分;

//类似0-1背包问题
/**
 * 找出2019以内的所有质数，
 * 然后从这些质数中挑选数字
 * dp[j]:j能凑成2019的种类数
 * prime[i]:第i个质数
 * dp[j]=dp[j-prime[i]]+dp[j]
 */
public class Main {
    public static void main(String[] args) {
        int[] prime = new int[2019];
        long[] dp = new long[2021];
        int cnt=1;
        for (int i = 1; i <=2019; i++) {
            if(isPrime(i)){
                prime[cnt++]=i;
            }
        }
        dp[0]=1;
        for (int i = 1; i <cnt; i++) {
            for (int j = 2019; j >=prime[i]; j--) {
                dp[j]+=dp[j-prime[i]];
            }
        }
        System.out.println(dp[2019]);
    }
    public static boolean isPrime(int x){
        if(x==0||x==1){
            return false;
        }
        for (int i = 2; i <=Math.sqrt(x) ; i++) {
            if(x%i==0){
                return false;
            }
        }
        return true;
    }
}
