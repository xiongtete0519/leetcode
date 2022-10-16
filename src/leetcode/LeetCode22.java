package leetcode;

import java.util.ArrayList;
import java.util.List;

//leetcode22:括号生成
public class LeetCode22 {
    //方法一：暴力+递归
    public static List<String> generateParenthesis(int n){
        ArrayList<String> combinations = new ArrayList<>();
        generateAll(new char[2*n],0,combinations);
        return combinations;
    }
    public static void generateAll(char[] current,int pos,List<String> result){
        //长度达到要求并且有效，添加到结果集合中
        if(pos==current.length){
            if(valid(current)){
                result.add(new String(current));
            }
        }else{  //生成所有情况
            //可以理解为每个位置都出现过前后括号
            current[pos]='(';
            generateAll(current,pos+1,result);
            current[pos]=')';
            generateAll(current,pos+1,result);
        }
    }
    //判断是否是有效括号
    public static boolean valid(char[] current){
        int balance=0;
        for (char c : current) {
            if(c=='('){
                ++balance;
            }else{
                --balance;
            }
            if(balance<0){
                return false;
            }
        }
        return balance==0;
    }
    private static List<String> res = new ArrayList<>();
    //方法二：DFS
    public static List<String> generateParenthesis1(int n){
        dfs(n,n,"");
        return res;
    }

    private static void dfs(int left, int right, String curStr) {
        if(left==0&&right==0){  //左右括号都不剩余了，递归终止
            res.add(curStr);
            return;
        }
        if(left>0){ //如果左括号还剩余的话，可以拼接左括号
            dfs(left-1,right,curStr+"(");
        }
        if(right>left){ //如果右括号剩余多于左括号剩余的话，可以拼接右括号
            dfs(left,right-1,curStr+")");
        }
    }

    public static void main(String[] args) {
//        System.out.println(generateParenthesis(3));
//        System.out.println(generateParenthesis1(3));
        System.out.println(generateParenthesis1(1));
    }
}
