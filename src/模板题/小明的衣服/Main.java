package 模板题.小明的衣服;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.PriorityQueue;
//优先级队列，每次选最小的两个数的和累加，并把这个和再加入队列中
public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        long n = nextLong();
        long sum=0;
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (int i = 0; i <n; i++) {
            queue.offer(nextLong());
        }
        while(queue.size()>1){
            Long a = queue.poll();
            Long b = queue.poll();
            sum+=a+b;
            queue.offer(a+b);
        }
        System.out.println(sum);
    }
    public static long nextLong() throws IOException {
        st.nextToken();
        return (long)st.nval;
    }
}
