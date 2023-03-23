package 模拟题.扫雷;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

//扫雷
public class Main {
    //定义周围八个点的坐标
    public static int[][] dirs={
            {-1,-1},
            {-1,0},
            {-1,1},
            {0,-1},
            {0,1},
            {1,-1},
            {1,0},
            {1,1}
    };
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int m = nextInt();
        int[][] a = new int[n + 1][m + 1];
        int[][] s = new int[n + 1][m + 1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m; j++) {
                a[i][j]=nextInt();
            }
        }
        //开始统计地雷
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m; j++) {
                if(a[i][j]==1){
                    s[i][j]=9;
                    continue;
                }
                //每找到一个点我们就开始扩展
                for (int[] dir : dirs) {
                    int x = i+dir[0];
                    int y = j + dir[1];
                    if(x>=1&&x<=n&&y>=1&&y<=m){//判断扩展的点是否越界
                        if(a[x][y]!=0){
                            s[i][j]+=1;
                        }
                    }
                }
            }
        }
        for (int i = 1; i < s.length; i++) {
            for (int j = 1; j <s[i].length; j++) {
                System.out.print(s[i][j]+" ");
            }
            System.out.println();
        }

    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
