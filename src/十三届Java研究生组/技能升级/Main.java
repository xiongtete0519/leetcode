package 十三届Java研究生组.技能升级;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.PriorityQueue;
//40%  直接把每个技能都点满，然后取前m个最大的就行，用优先级队列是为了避免全局排序，不过也超时了
public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        long res=0;
        long n = nextLong();
        long m = nextLong();
        PriorityQueue<Long> queue = new PriorityQueue<>((o1, o2) -> (int) (o2 - o1));
        for (int i = 0; i < n; i++) {
            long a = nextLong();
            long b = nextLong();
            while(a>0){
                queue.add(a);
                a-=b;
            }
        }
        for (int i = 0; i < m; i++) {
            if(!queue.isEmpty()){
                res+=queue.poll();
            }
        }
        System.out.println(res);
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
