package 十二届Java研究生组.回路计数;

public class Main {
    public static boolean[][] canGo=new boolean[22][22];
    //状压DP，dp[i][j]:状态为i并且最后走过j的方案数
    public static long[][] dp=new long[1<<21][22];
    public static void main(String[] args) {
        //先填表判断那些楼层之间右路
        for (int i = 1; i <=21 ; i++) {
            for (int j = 1; j <=21 ; j++) {
                if(gcd(i,j)==1){
                    canGo[i][j]=true;
                }
            }
        }
        dp[1][1]=1;
        for (int i = 1; i <(1<<21); i++) {
            for (int j = 1; j <=21 ; j++) {
                //j楼在i这种状态里    i的第j位是1
                if((i&(1<<(j-1)))>0){
                    //dp[i][j]+=dp[状态i中的j去掉][从哪些楼可以到j]
                    //dp[i][j]=没有走j之前的状态能够走到j的所有可能的和
                    for (int k = 1; k <=21 ; k++) {
                        if(canGo[k][j]){
                            dp[i][j]+=dp[i&~(1<<(j-1))][k];
                        }
                    }
                }
            }
        }
        long res=0;
        for (int i = 1; i <=21 ; i++) {
            res+=dp[(1<<21)-1][i];
        }
        System.out.println(res);
    }
    //最大公约数
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            int min = Math.min(a, b);
            int max = Math.max(a, b);
            return gcd(min, max % min);
        }
    }
}
