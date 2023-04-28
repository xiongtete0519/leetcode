package 模拟题.交换瓶子;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int[] a = new int[n+1];
        for (int i = 1; i <=n ; i++) {
            a[i]=nextInt();
        }
        long count=0;
        for (int i = 1; i <=n; i++) {
            if (a[i] != i) {
                for (int j = i + 1; j <=n; j++) {
                    if (a[j] == i) {
                        int temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                        count++;
                        break;
                    }
                }
            }
        }
//        Arrays.stream(a).skip(1).forEach(x->{
//            System.out.print(x+" ");
//        });
//        System.out.println();
        System.out.println(count);
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
