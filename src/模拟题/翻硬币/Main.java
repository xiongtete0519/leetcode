package 模拟题.翻硬币;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//翻硬币：直接对两个字符串从头到尾扫描，不一样就翻相邻的两个字符
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        long sum=0;
        for (int i = 0; i <str1.length; i++) {
            if(str1[i]!=str2[i]){
                sum++;
                str1[i]=str2[i];
                //相邻的位置也要翻转
                if(i+1<str1.length&&str1[i+1]=='*'){
                    str1[i+1]='o';
                }else if(i+1<str1.length&&str1[i+1]=='o'){
                    str1[i+1]='*';
                }
            }
        }
        System.out.println(sum);
        br.close();
    }
}
