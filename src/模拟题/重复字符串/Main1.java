package 模拟题.重复字符串;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * 我们只需要统计出每列出现次数最多的字母即可，然后用k-这个字母出现的次数，
 * 结果就是我们在这一列上需要修改的次数
 */
public class Main1 {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static char[][] chars;

    public static void main(String[] args) throws IOException{
        int k = nextInt();
        String s = nextString();
        //检查字符串能否等分成k份
        if(s.length()%k!=0){
            System.out.println(-1);
        }else{
            int num = s.length() / k;
            long sum=0;
            chars=new char[k][num];//存储等位拆分后的字符串
            for (int i = 0; i <s.length(); i++) {
                chars[i/num][i%num]=s.charAt(i);
            }
//            Arrays.stream(chars).forEach(x->{
//                System.out.println(Arrays.toString(x));
//            });
            for (int i = 0; i <num; i++) {  //先遍历列
                int[] arr = new int[26];    //记录26个小写英文字母出现的次数
                for (int j = 0; j <k; j++) {//再遍历行
                    arr[chars[j][i]-'a']++; //统计每个字母出现的次数
                }
                //记录同一列中哪个字母出现的次数最多
                int max=Integer.MIN_VALUE;
                for (int x : arr) {
                    max=Math.max(x,max);
                }
                sum+=k-max; //总行数-出现最多的，剩下的就是要修改
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
