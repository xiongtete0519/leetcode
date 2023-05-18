package 国赛打游击.异或三角;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int t=nextInt();
        long[] arr = new long[t];
        for (int i = 0; i <t; i++) {
            arr[i]=nextLong();
        }
        for (int i = 0; i < arr.length; i++) {
            long check = check(arr[i]);
            System.out.println(check);
        }


    }
    public static long check(long x){
        long count=0;
        for (int a = 1; a <=x; a++) {
            for (int b = 1; b <=x ; b++) {
                int c=a^b;
                if(c>=1&&c<=x&&a+b>c&&a+c>b&&b+c>a){
                    count++;
                }
            }
        }
        return count;
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
    public static long nextLong() throws IOException{
        st.nextToken();
        return (long)st.nval;
    }

}
