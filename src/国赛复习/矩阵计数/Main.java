package 国赛复习.矩阵计数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * DFS:我们转化成矩阵中不能出现连续一行3个1和连续一列3个1比较方便赋值
 */
public class Main {
    public static int n;
    public static int m;
    public static int[][] map;
    public static int ans=0;
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        n=nextInt();
        m=nextInt();
        map=new int[n][m];
        dfs(0,0);
        System.out.println(ans);
    }
    public static void dfs(int i,int j){
        //程序已经执行到了第n行，数组下标最大为n-1，到这里算一种情况
        if(i==n){
            ans++;
            return;
        }
        //判断能否将当前位置插入一个1
        if(judge(i,j)){
            map[i][j]=1;
            if(j<m-1){  //对该行逐个dfs
                dfs(i,j+1);
            }else{
                //说明当前行的全部位置都执行完了，执行下一行，从第一个开始
                dfs(i+1,0);
            }
            //复原，回溯
            map[i][j]=0;
        }
        //当前位置不能插入一个1，那就跳过当前位置，执行下一个位置
        if(j<m-1){  //该行还没填满，j=0~m-1
            dfs(i,j+1);
        }else{  //该行已经填满，从下一行的第一个位置开始
            dfs(i+1,0);
        }
    }
    //要求矩阵中不存在连续一行3个1或者连续一列3个1
    public static boolean judge(int i,int j){
        if(n>2&&i>=2){
            if(map[i-1][j]==map[i-2][j]&&map[i-1][j]==1){
                return false;
            }
        }
        if(m>2&&j>=2){
            //前两行已经有两个1了，不能再插
            if(map[i][j-1]==map[i][j-2]&&map[i][j-1]==1){
                return false;
            }
        }
        //可以插入一个1
        return true;
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
