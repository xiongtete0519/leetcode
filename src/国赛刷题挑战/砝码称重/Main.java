package 国赛刷题挑战.砝码称重;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
//50%
public class Main {
    public static final int MAXN=100010;
    public static int[] a=new int[MAXN];//N个砝码的重量
    public static int[] vis=new int[MAXN];//记录每种称重是否出现过
    public static int n;//砝码的数量
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        n=nextInt();
        for (int i = 0; i <n; i++) {
            a[i]=nextInt();
        }
        dfs(0,0);
        long ans=0;
        for (int i = 1; i <MAXN; i++) {
            if(vis[i]==1){
                ans++;
            }
        }
        System.out.println(ans);

    }

    /**
     *
     * @param sum 当前已选用砝码的总重量
     * @param i 下一个将要选用砝码的序号
     */
    public static void dfs(int sum, int i) {
        if(i==n){//砝码已经选完了
            if(sum>=0){
                vis[sum]=1; //标记sum为1表示该重量被称出来
            }
            return;
        }
        dfs(sum+a[i],i+1);  //把a[i]放右边
        dfs(sum,i+1);             //不放a[i]
        dfs(sum-a[i],i+1);  //把a[i]放左边
    }

    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
