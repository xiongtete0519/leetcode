package 国赛复习.部分省赛复习.蓝桥公园;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
       int N=nextInt();
       int M=nextInt();
       int Q=nextInt();
       long[][] dist=new long[N+1][N+1];
        for (int i = 1; i <=M ; i++) {
            Arrays.fill(dist[i],Long.MAX_VALUE>>1);
            dist[i][i]=0;
        }
        //初始化两点之间的距离
        for (int i = 1; i <=M ; i++) {
            int u=nextInt();
            int v=nextInt();
            long w=nextLong();
            dist[u][v]=Math.min(dist[u][v],w);
            dist[v][u]=Math.min(dist[v][u],w);
        }
        //Floyd
        for (int k = 1; k <=N ; k++) {
            for (int i = 1; i <=N ; i++) {
                for (int j = 1; j <=N ; j++) {
                    if(dist[i][j]>dist[i][k]+dist[k][j]){
                        dist[i][j]=dist[i][k]+dist[k][j];
                    }
                }
            }
        }
        //查询
        for (int i = 0; i < Q; i++) {
            int start=nextInt();
            int end=nextInt();
            if(dist[start][end]>=Long.MAX_VALUE>>1){
                System.out.println(-1);
            }else{
                System.out.println(dist[start][end]);
            }
        }
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
