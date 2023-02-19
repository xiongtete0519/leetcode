package leetcode1;

/**
 * Excel表列序号
 */
public class LeetCode171 {
    /**
     * 进制转换，
     * 通用规则如下,ans=0,ans=ans*进制+vali
     * 这里为ans=ans*26+vali,但是由于没有0，所以减去'A'之后要+1
     */
    public static int titleToNumber(String columnTitle) {
        int ans=0;
        for (int i = 0; i <columnTitle.length(); i++) {
            int num = columnTitle.charAt(i) - 'A' + 1;
            ans=ans*26+num;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
        System.out.println(titleToNumber("FXSHRXW"));
        System.out.println(titleToNumber("AZY"));
    }
}
