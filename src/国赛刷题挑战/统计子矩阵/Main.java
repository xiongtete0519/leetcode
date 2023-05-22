package 国赛刷题挑战.统计子矩阵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static long[][] arr;
    public static long[][] s;
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int n=nextInt();
        int m=nextInt();
        int k=nextInt();
        arr = new long[n+1][m+1];
        s = new long[n+1][m+1];
        long res=0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <arr[i].length ; j++) {
                arr[i][j]=nextInt();
                //计算二维前缀和
                s[i][j]=s[i][j-1]+s[i-1][j]-s[i-1][j-1]+arr[i][j];
            }
        }

        //枚举左上角和右小角坐标
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                for (int l = i; l <=n ; l++) {
                    for (int o = j; o <=m ; o++) {
                        if(check(i,j,l,o)<=k){
                            res++;
                        }
                    }
                }
            }
        }
        System.out.println(res);

    }
    //根据左上角和右下角求矩阵和
    public static long check(int x1,int y1,int x2,int y2){
        return s[x2][y2]-s[x2][y1-1]-s[x1-1][y2]+s[x1-1][y1-1];
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
