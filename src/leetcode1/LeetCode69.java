package leetcode1;
// x的平方根，不允许使用pow内置函数
public class LeetCode69 {
    public static int mySqrt(int x){
        int left = 0, right = x, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
        System.out.println(mySqrt(8));
    }
}
