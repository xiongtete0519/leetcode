package 第十三届蓝桥杯国赛.环境治理;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static int n;
    public static long Q,p;
    public static long[][] map;
    public static long[][] dist;
    public static long[][] limit;
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        n=nextInt();
        Q=nextLong();
        dist = new long[n + 1][n + 1];
        limit = new long[n + 1][n + 1];
        map=new long[n+1][n+1];
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=n; j++) {
                dist[i][j]=nextLong();
                map[i][j]=dist[i][j];
            }
        }
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=n; j++) {
                limit[i][j]=nextLong();
            }
        }
        p = countP();
        if(p<=Q){
            System.out.println(0);
            return;
        }
        long count=0;
        for (int i = 1; i <=1000000; i++) {
            count++;
            //开始改善
            int i1 = i % n;
            for (int j = 1; j <=n; j++) {
                //行减一
                if(dist[i1][j]>limit[i1][j]){
                    dist[i1][j]--;
                }
                //列减一
                if(dist[j][i1]>limit[j][i1]){
                    dist[j][i1]--;
                }
            }
            floyd();
            if(countP()<=Q){
                System.out.println(count);
                return;
            }
        }
        System.out.println(-1);
//        Arrays.stream(dist).forEach(x->{
//            System.out.println(Arrays.toString(x));
//        });
//        Arrays.stream(limit).forEach(x->{
//            System.out.println(Arrays.toString(x));
//        });
        //第一次计算
//        floyd();

//        Arrays.stream(dist).forEach(x->{
//            System.out.println(Arrays.toString(x));
//        });


    }

    public static void floyd(){
        for(int k=1;k<=n;k++){
            for (int i = 1; i <=n; i++) {
                for (int j = 1; j <=n ; j++) {
//                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                    if(dist[i][k]+dist[k][j]<dist[i][j]&&dist[i][k]+dist[k][j]>=limit[i][j]){
                        dist[i][j]=dist[i][k]+dist[k][j];
                    }
                }
            }
        }
    }
    public static void floyd1(){
        for(int k=1;k<=n;k++){
            for (int i = 1; i <=n; i++) {
                for (int j = 1; j <=n ; j++) {
//                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                    if(limit[i][k]+limit[k][j]<limit[i][j]){
                        limit[i][j]=limit[i][k]+limit[k][j];
                    }
                }
            }
        }
    }

    public static long countP() {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum += dist[i][j];
            }
        }
        return sum;
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
