package 十二届Java研究生组.最少砝码;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 1个砝码：最大称到 1
 * 2个砝码： 1和2： 1=1,2=2,3=2+1
 *          1和3:1=1,2=3-1,3=3,4=3+1;
 *          选最大重量大一点，选1和3,最大可以满足4
 * 3个砝码： 1、3、9
 *  1=1，2=3-1，3=3，4=1+3，5=9-3-1，6=9-3，7=9-3+1，8=9-1，9=9，10=9+1，11=9+3-1，
 *  12=9+3，13=9+3+1
 *   最大称到13
 *   1->1
 *   2->4
 *   3->13
 *   s(n+1)=3s(n)+1
 */
public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException{
        long total = nextLong();
        long num= 1L;
        long count=1L;
        while(num<total){
            num=num*3+1;
            count++;
        }
        System.out.println(count);

    }
    public static long nextLong() throws IOException {
        st.nextToken();
        return (long)st.nval;
    }
}
