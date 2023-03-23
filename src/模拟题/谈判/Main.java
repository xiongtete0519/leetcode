package 模拟题.谈判;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.PriorityQueue;

//谈判
public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        long sum=0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1-o2);
        for (int i = 0; i <n ; i++) {
            queue.add(nextInt());
        }
        while(queue.size()>=2){
            Integer x1 = queue.poll();
            Integer x2 = queue.poll();
            sum+=x1+x2;
            queue.offer(x1+x2);
        }
        System.out.println(sum);
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
