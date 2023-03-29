package 十一届Java研究生组.成绩统计;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i]=nextDouble();
        }
        //统计及格人数
        long count = Arrays.stream(a).filter(x -> x >= 60).count();
        //统计优秀人数
        long count1 = Arrays.stream(a).filter(x -> x >= 85).count();
        //计算及格率
        double v = count * 1.0 / n*100;
        double v1 = count1 * 1.0 / n*100;
        System.out.println(Math.round(v)+"%");  //返回参数中最接近的 long ，其中 long四舍五入为正无穷大。
        System.out.println(Math.round(v1)+"%");
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
    public static double nextDouble() throws IOException{
        st.nextToken();
        return st.nval;
    }
}
