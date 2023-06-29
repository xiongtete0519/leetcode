package 代码随想录.数组.移除元素;

public class Main {
    //暴力：找到需要删除的元素之后，后续元素前移一位即可
    public static int removeElement1(int[] nums, int val) {
       int len=nums.length;
        for (int i = 0; i < len; i++) {
            if(nums[i]==val){
                for (int j = i+1; j <len ; j++) {
                    nums[j-1]=nums[j];
                }
                i--;
                len--;
            }
        }
        return len;
    }
    /**
     * 双指针法则
     * 快指针：寻找新数组的元素，新数组就是不包含有目标元素的数组
     * 慢指针：指向更新 新数组小标的位置
     */

    public static int removeElement(int[] nums, int val) {
        int slowIndex=0;
        for (int fastIndex = 0; fastIndex <nums.length; fastIndex++) {
            if(nums[fastIndex]!=val){
                nums[slowIndex]=nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
    public static void main(String[] args) {
        System.out.println(removeElement1(new int[]{3, 2, 2, 3}, 3));
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
    }
}
