package 模拟题.修改数组;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;


/**
 * 暴力：用一个数组exist标记输入的x是否被使用过(exist[x]=1)，若已经被使用过，则执行x++
 */
public class Main {
    public static int[] exist=new int[1000010];
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <=n ; i++) {
            int x = nextInt();
            while(exist[x]==1){
                x++;
            }
            exist[x]=1;
            list.add(x);
        }
        list.forEach(x->{
            System.out.print(x+" ");
        });
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
