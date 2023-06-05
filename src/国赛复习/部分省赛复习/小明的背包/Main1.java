package 国赛复习.部分省赛复习.小明的背包;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

//背包容量为8，4件物品
public class Main1 {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int[] w={0,2,3,4,5};    //各物品的重量
        int[] v={0,3,4,5,8};    //各物品的价值
        int[] f=new int[9];
        for (int i = 1; i <5 ; i++) {
            for (int j = 8; j >=w[i] ; j--) {
                f[j]=Math.max(f[j],f[j-w[i]]+v[i]);
            }
        }
//        Arrays.stream(f).skip(1).forEach(x->{
//            System.out.print(x+" ");
//        });
        System.out.println(f[8]);
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
