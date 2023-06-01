package 国赛打游击.出差;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
    static final int N=1010;
    static int[][] gra=new int[N][N];
    static int[] dist=new int[N];
    static int[] g=new int[N];
    static boolean[] st=new boolean[N];
    static int n,m;
    public static StreamTokenizer in=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        n=nextInt();
        m=nextInt();
        for (int i = 1; i <=n ; i++) {
            g[i]=nextInt();
        }
        g[n]=0;
        for (int[] row : gra) {
            Arrays.fill(row,0x3f3f3f);
        }
        for (int i = 1; i <=m; i++) {
            int u=nextInt();
            int v=nextInt();
            int c=nextInt();
            gra[u][v]=g[v]+c;
            gra[v][u]=g[u]+c;
        }
        System.out.println(dijkstra());
    }
    public static int dijkstra(){
        Arrays.fill(dist,0x3f3f3f);
        dist[1]=0;
        for (int i = 0; i <n-1 ; i++) {
            int t=-1;
            for (int j = 1; j <=n ; j++) {
                if(!st[j]&&(t==-1||dist[t]>dist[j])){
                    t=j;
                }
            }
            st[t]=true;
            for (int j = 1; j <=n ; j++) {
                dist[j]=Math.min(dist[j],dist[t]+gra[t][j]);
            }
        }
        return dist[n];
    }
    public static int nextInt() throws IOException{
        in.nextToken();
        return (int)in.nval;
    }
}
