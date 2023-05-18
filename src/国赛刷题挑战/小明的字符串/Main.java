package 国赛刷题挑战.小明的字符串;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//求T串的前缀在S串种出现的最长长度为多少
public class Main {
    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String S = br.readLine();
        String T = br.readLine();
        long ans=0;
        for (int i = 0; i <T.length() ; i++) {
            String sub = T.substring(0, i+1);
            if(S.contains(sub)){
                ans=sub.length();
            }
        }
        System.out.println(ans);
    }
}
