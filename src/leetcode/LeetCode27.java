package leetcode;
//leetcode27:移除元素
public class LeetCode27 {
    //双指针法:left指向每次需要插入元素的位置，right用来遍历
    public static int removeElement(int[] nums,int val){
        //右指针right指向当前将要处理的元素
        //左指针left指向下一个将要赋值的位置
        int left=0;
        for (int right = 0; right <nums.length ; right++) {
            if(nums[right]!=val){
                nums[left]=nums[right];
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums={3,2,2,3};
        System.out.println(removeElement(nums, 3));
    }
}
