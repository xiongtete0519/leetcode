package 模拟题.左移右移;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        Integer[] a = new Integer[n+1];
        Integer[] index = new Integer[n + 1];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            map.put(i,i);
        }
        int left=0;
        int right=0;
        int m = nextInt();//m次操作
        for (int i = 0; i <m; i++) {
            String s = nextString();
            int num = nextInt();
            if(s.equals("L")){
                left--;
                map.put(num,left);
            }else{
                right++;
                map.put(num,right);
            }
        }
//        System.out.println(map);
//        map.entrySet().stream().sorted((x1,x2)->x1.getValue()-x2.getValue()).forEach(x->{
//            System.out.print(x.getKey()+" ");
//        });
        map.entrySet().stream().sorted((x1, x2)->x1.getValue()-x2.getValue()).map(Map.Entry::getKey).forEach(x->{
            System.out.print(x+" ");
        });

    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
    public static String nextString() throws IOException{
        st.nextToken();
        return st.sval;
    }
}
