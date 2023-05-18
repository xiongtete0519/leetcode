package 第十届蓝桥杯国赛.矩阵计数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
//DFS:我们转化成不能出现矩阵中连续一行3个1和连续一列3个1比较方便赋值
public class Main {
    public static int n;    //矩阵大小n*m
    public static int m;
    public static int[][] map;  //矩阵
    public static int ans=0;    //存储结果
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        n=nextInt();
        m=nextInt();
        map=new int[n][m];
        dfs(0,0);
        System.out.println(ans);
    }

    public static void dfs(int i, int j) {
        //程序已经执行到了第n行，数组下标最大为n-1，到这里算一种情况
        if(i==n){
            ans++;//计算满足条件的结果总数
            return;
        }
        //判断能否将当前位置插入一个1
        if(judge(i,j)){
            map[i][j]=1;
            if(j<m-1){//对该行逐个dfs
                dfs(i,j+1);
            }else{
                //程序执行到这里说明当前行的全部位置都执行完了，执行下一行，从第一个开始
                dfs(i+1,0);
            }
            //复原，回溯
            map[i][j]=0;
        }
        //当前位置不能插入一个1，那就跳过当前位置，执行下一个位置
        if(j<m-1){//该行还没填满，j=0~m-1
            dfs(i,j+1);
        }else{  //该行已经填满，从下一行的第一个位置开始
            dfs(i+1,0);
        }

    }
    //要求矩阵中不存在连续一行3个X或者连续一列3个X
    public static boolean judge(int i,int j){
        //行数都没有3，那就不用谈连续三个了
        if(n>2&&i>=2){
            //前两列已经有两个1了，不能再插
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
        //可以插一个1
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
