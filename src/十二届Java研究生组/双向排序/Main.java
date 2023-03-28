package 十二届Java研究生组.双向排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
//通过60%,超时了
public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int m = nextInt();
        Integer[] a = new Integer[n + 1];
        for (int i = 0; i <=n ; i++) {
            a[i]=i;
        }
        //m次操作
        for (int i = 0; i <m ; i++) {
            int p = nextInt();
            int q = nextInt();
            if(p==0){   //a1,a2...aqi降序排列
                Arrays.sort(a, 1, q+1, (o1, o2) -> o2-o1);
            }else{//a1i...an升序排列
                Arrays.sort(a,q,n+1);//比较器默认是升序的
            }
        }
        Arrays.stream(a).skip(1).forEach(x->{
            System.out.print(x+" ");
        });
    }
    public static int nextInt() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }
}
