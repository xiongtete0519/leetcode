package 国赛刷题挑战.斤斤计较的小z;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//s1在s2中出现了多少次
public class Main {
    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String s1 = br.readLine();
        String s2 = br.readLine();
        int len1 = s1.length();
        long count=0;
        for (int i =0; i+len1<=s2.length(); i++) {
            String tmpString = s2.substring(i, i + len1);
            if(tmpString.equals(s1)){
                count++;
            }
        }
        System.out.println(count);

    }
}
