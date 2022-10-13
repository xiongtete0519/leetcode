package leetcode;
//最长公共前缀
public class LeetCode14 {

    /**
     *纵向扫描，依次遍历每个字符串，更新最长公共前缀
     */
    public static String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0)  //不满足就返回空串
            return "";
        int length=strs[0].length();
        int count=strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i); //依次取出strs[0]的每个字符和其他strs对应位置比较
            for (int j = 1; j < count; j++) {
                if(i==strs[j].length()||strs[j].charAt(i)!=c){
                    ////如果已经遍历完某个strs或者对应位置的字符不相等，直接截取并返回
                    return strs[0].substring(0,i);
                }
            }
        }
        //走到这里说明strs[0]是最长公共前缀
        return strs[0];
    }

    public static void main(String[] args) {
        String[] strs={"flow","flows","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
