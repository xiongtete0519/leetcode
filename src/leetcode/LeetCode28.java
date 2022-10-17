package leetcode;
//leetcode28:找出字符串中第一个匹配项的下标
public class LeetCode28 {
    public static int strStr(String haystack,String needle){
        return haystack.indexOf(needle);
    }
    public static int strStr1(String haystack,String needle){
        int m=haystack.length();
        int n=needle.length();
        if(n==0||m<n)
            return -1;
        int i=0;    //目标串字符下标
        int j=0;    //模式串字符下标
        while(i<m&&j<n){
            if(haystack.charAt(i)==needle.charAt(j)){   //若两字符先等，则继续匹配后续字符
                i++;
                j++;
            }else{
                i=i-j+1;    //目标串下标回退到i-j+1
                j=0;        //模式串下标回退到0
                if(i>m-n)   //若目标串剩余子串的长度不够，则不再比较
                    break;
            }
        }
        return j==n?i-n:-1; //若匹配成功，则返回匹配子串符号，否则返回-1
    }

    public static void main(String[] args) {
//        System.out.println(strStr("leetcode", "leet"));
        System.out.println(strStr1("hello", "ll"));
    }
}
