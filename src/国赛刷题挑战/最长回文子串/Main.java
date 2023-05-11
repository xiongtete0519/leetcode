package 国赛刷题挑战.最长回文子串;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//求最长回文子串的长度
//中心扩展法，把每个点都当作回文串的中心进行扩展(中心有1个点和2个点两种情况)
public class Main {
    public static String str;
    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        str=br.readLine();
        int max=0;
        for (int i = 0; i <str.length() ; i++) {
            int ans=Math.max(huiwen(i,i),huiwen(i,i+1));
            max=Math.max(max,ans);
        }
        System.out.println(max);
    }
    //中心扩展
    public static int huiwen(int left,int right){
        while(left>=0&&right<str.length()){
            if(str.charAt(left)==str.charAt(right)){
                left--;
                right++;
            }else{
                break;
            }
        }
        return right-left-1;
    }

}
