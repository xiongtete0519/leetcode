package 国赛打游击.翻转括号序列;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
//50%
public class Main {
    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static int n;    //括号序列长度
    public static int m;    //操作次数
    public static char[] chars;
    public static void main(String[] args) throws IOException {

        String[] split = br.readLine().split(" ");
        n=Integer.parseInt(split[0]);
        m=Integer.parseInt(split[1]);
        chars=new char[n+1];
        String str = br.readLine();
        for (int i = 1; i <=n ; i++) {
            chars[i]=str.charAt(i-1);
        }
        //m次操作
        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            if(s1.length==2){//操作2
                //以left为左端点，找到最长的合法括号序列
                int left=Integer.parseInt(s1[1]);
                int len = longestCheck(left);
                System.out.println(len);
            }else{  //操作1
                //指定区间的左右括号翻转
                int left = Integer.parseInt(s1[1]);
                int right=Integer.parseInt(s1[2]);
                reverseLR(left,right);
            }
        }


    }
    //判断括号序列是否合法
    public static boolean check(char[] chars){
        if(chars.length%2!=0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if(c=='('){
                stack.push(c);
            }else if(c==')'){
                //若栈中没有左括号直接返回false
                if(!stack.contains('(')){
                    return false;
                }
                while(!stack.isEmpty()&&stack.pop()!='('){
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
    //区间翻转：将指定区间[Li,Ri]的括号反向
    public static void reverseLR(int left,int right){
        for (int i = left; i <=right ; i++) {
            if(chars[i]=='('){
                chars[i]=')';
            }else{
                chars[i]='(';
            }
        }
    }
    //寻找最长的合法括号序列
    public static int longestCheck(int left){
        if(left==chars.length){
            return 0;
        }
        int right=left+1;
        int res=0;
        while(right<=chars.length){
            char[] tmpChar = Arrays.copyOfRange(chars, left, right+1);
            if(check(tmpChar)){
                res=right;
            }
            right++;
        }
        return res;
    }
}
