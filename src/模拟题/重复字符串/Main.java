package 模拟题.重复字符串;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException{
        int k = nextInt();
        String s = nextString();
        //检查字符串能否等分成k份
        if(s.length()%k!=0){
            System.out.println(-1);
        }else{
            int num = s.length() / k;
            long sum=0;
            for (int i = 0; i <num; i++) {  //每个字符串长为num，逐个和同列字母比较即可
                int[] arr = new int[26];
                for (int j = i; j <s.length(); j+=num) {    //枚举同一列的字母，统计同列位置字母出现最多的次数
                    arr[s.charAt(j)-'a']++;
                }
                int max=Integer.MIN_VALUE;
                for (int x : arr) {
                    max=Math.max(x,max);
                }
                sum+=k-max; //总共k份减去该列字母出现最多的次数，剩下的就是要改的
            }
            System.out.println(sum);
        }

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
