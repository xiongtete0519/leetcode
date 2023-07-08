package 代码随想录.字符串.字符串匹配;

public class Main {
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
    //BF模式匹配算法
    public static int strStr1(String haystack, String needle) {
        int m=haystack.length();
        int n=needle.length();
        if(n==0||m<n){
            return -1;
        }
        int i=0;    //目标串字符下标
        int j=0;    //模式串字符下标
        while(i<m&&j<n){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }else{
                i=i-j+1;    //目标串下标回退到i-j+1
                j=0;        //模式串下标回退到0
                if(i>m-n){
                    //若目标串剩余子串的长度不够，则不再比较
                    break;
                }
            }
        }
        return j==n?i-n:-1;
    }
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
        System.out.println(strStr1("sadbutsad", "sad"));
        System.out.println(strStr1("leetcode", "leeto"));
    }
}
