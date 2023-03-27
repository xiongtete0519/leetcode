package 模拟题.对局匹配;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.TreeSet;

public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException{
        int n = nextInt();
        int k = nextInt();
        int[] arr = new int[100010];
        int max=0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i <=n ; i++) {
            int x = nextInt();
            set.add(x);
            arr[x]++;
            max=Math.max(max,x);
        }
        if(k==0){   //k=0时只需要统计不相等元素的个数即可。
            System.out.println(set.size());
        }else{
            for (int i = 1; i <max+1; i++) {
                if(i-2*k>=0){
                    arr[i]=Math.max(arr[i-2*k]+arr[i],arr[i-k]);
                }else if(i-k>=0){
                    arr[i]=Math.max(arr[i],arr[i-k]);
                }
            }
            int ans=0;
            //把k组的答案统计起来
            for (int i = max; i >max-k; i--) {
                ans+=arr[i];
            }
            System.out.println(ans);
        }
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }
    public static long nextLong() throws IOException{
        st.nextToken();
        return (long)st.nval;
    }
}
