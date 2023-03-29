package 十一届Java研究生组.作物杂交;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.List;

public class Main {
    static class zhongZi{
        int x;  //编号
        int y;  //培育天数
        public zhongZi() {
        }
        public zhongZi(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();
        int t = nextInt();
        //每个瓶中培养时间
        int[] time = new int[n + 1];
        //该编号最早可以合成的时间
        int[] result = new int[n + 1];
        for (int i = 1; i <=n ; i++) {
            time[i]=nextInt();
        }
        //记录是否存在
        boolean[] set = new boolean[n + 1];
        //将存在的元素记为true
        for (int i = 1; i <=m; i++) {
            int x = nextInt();
            set[x]=true;
        }
        //记录每一个品种的合成路径
        List<zhongZi> list[] = new List[n+1];

    }

    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
