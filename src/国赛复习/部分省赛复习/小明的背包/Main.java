package 国赛复习.部分省赛复习.小明的背包;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int N=nextInt();    //物品数量
        int V=nextInt();    //背包容量
        int[] w=new int[N+1];   //物品体积
        int[] v=new int[N+1];   //物品价值
        //记录最优解，我们的目标是f[N][V]
        int[][] f=new int[N+1][V+1];
        for (int i = 1; i <=N ; i++) {
            w[i]=nextInt();
            v[i]=nextInt();
        }
        for (int i = 1; i <=N ; i++) {  //i代表N遍历物品
            for (int j = 1; j <=V ; j++) {  //j表示背包容量
                if(w[i]>j){ //太重，装不下
                    f[i][j]=f[i-1][j];
                }else{
                    //max{不拿第i件，拿第i件}
                    f[i][j]=Math.max(f[i-1][j],f[i-1][j-w[i]]+v[i]);
                }
            }
        }
        System.out.println(f[N][V]);
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
