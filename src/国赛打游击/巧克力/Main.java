package 国赛打游击.巧克力;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int x=nextInt();
        int n=nextInt();
        Node[] chos=new Node[n];
        for (int i = 0; i <n; i++) {
            int price=nextInt();
            int expire=nextInt();
            int count=nextInt();
            chos[i]=new Node(price,expire,count);
        }
        Arrays.sort(chos, (o1, o2) -> {
            if(o1.expire==o2.expire){ //保质期相等的按照价格排序
                return o1.price-o2.price;
            }else{
                //按照保质期逆序排
                return o2.expire-o1.expire;
            }
        });
//        System.out.println(Arrays.toString(chos));
        long ans=0;
        int day=x;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int i=0;
        while (day>0){
            while (i<n&&chos[i].expire>=day){
                queue.add(chos[i]);
                i++;
            }
            if(queue.size()==0){
                System.out.println(-1);
                return;
            }else{
                Node cur = queue.peek();
                if(cur.count>0){
                    cur.count--;
                    ans+=cur.price;
                    day--;
                }else{
                    queue.poll();
                }
            }
        }
        System.out.println(ans);
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
class Node implements Comparable<Node>{
      int price;//单价
      int expire;  //剩余保质期
      int count;//数量

    public Node(int price, int expire, int count) {
        this.price = price;
        this.expire = expire;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Node{" +
                "price=" + price +
                ", expire=" + expire +
                ", count=" + count +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.price-o.price;
    }
}