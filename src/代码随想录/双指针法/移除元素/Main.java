package 代码随想录.双指针法.移除元素;
//leetcode27：移除元素
public class Main {
    //暴力法O(n^2)：碰到要删除的直接把后面的元素前移一位
    public static int removeElement(int[] nums, int val) {
        int len=nums.length;
        int i=0;
        while(i<len){
            if(nums[i]==val){
                for (int j = i+1; j <len ; j++) {
                    nums[j-1]=nums[j];
                }
                //此时长度-1，这里不用进行i++,否则每次前移都会跳过一个元素
                len--;
            }else{
                i++;
            }
        }
        return len;
    }
    //双指针法:慢指针指向新数组
    public static int removeElement1(int[] nums,int val){
        int slow=0;//慢指针
        for (int fast = 0; fast < nums.length; fast++) {
            if(nums[fast]!=val){
                //只有快指针指向的元素!=val时才会执行慢指针移动
                nums[slow]=nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums={3,2,2,3};
//        int[] nums={0,1,2,2,3,0,4,2};
        int val=3;
//        int val=2;
        System.out.println(removeElement(nums, val));
        System.out.println(removeElement1(nums, val));
    }
}
