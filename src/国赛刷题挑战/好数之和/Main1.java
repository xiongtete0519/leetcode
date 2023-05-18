package 国赛刷题挑战.好数之和;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashSet;

/**
 * AC
 * 直接生成含有2022的数，比较L和R是否符合，然后加入set避免重复
 */
public class Main1 {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        long sum=0;
        long L=nextLong();
        long R=nextLong();
        String sl = String.valueOf(L);
        String sr = String.valueOf(R);
        int ll=sl.length();
        int lr=sr.length();
        if(R<2022){
            System.out.println(0);
        }
        if(R==2022){
            System.out.println(2022);
        }
        if(R>2022){
            HashSet<Long> set = new HashSet<>();
            for (int i = 0; i <=lr-4; i++) {
                for (int j = 0; j <=lr-4-i; j++) {
                    for (int k = 0; k <= Math.pow(10,j)-1 ; k++) {
                        for (int l = 0; l <=Math.pow(10,i)-1 ; l++) {
                            long temp=(long)(2022*Math.pow(10,j)+k+l*Math.pow(10,4+j));
                            if(temp>=L&&temp<=R&&!set.contains(temp)){
                                sum+=temp;
                                set.add(temp);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(sum);
    }
    public static long nextLong() throws IOException{
        st.nextToken();
        return (long)st.nval;
    }
}
