package 代码随想录.数组.长度最小的子数组;

public class Main {
    //暴力
    public static int minSubArrayLen(int target, int[] nums) {
        int ans=Integer.MAX_VALUE;
        //前缀和数组
        int[] sum=new int[nums.length];
        sum[0]=nums[0];
        for (int i = 1; i <nums.length ; i++) {
            sum[i]=sum[i-1]+nums[i];
        }
        if(sum[nums.length-1]<target){
            return 0;
        }
        if(sum[nums.length-1]==target){
            return nums.length;
        }

        for (int i = 0; i < nums.length; i++) {
            int tempSum;
            for (int j = i; j <nums.length ; j++) {
                if(i==0){
                    tempSum=sum[j];
                }else{
                    tempSum=sum[j]-sum[i-1];
                }
                if(tempSum>=target){
                    ans=Math.min(ans,j-i+1);
                }
            }
        }
        return ans;
    }

    //滑动窗口
    public static int minSubArrayLen1(int target, int[] nums) {
        int left=0; //滑动窗口起始位置
        int sum=0;  //滑动窗口数值之和
        int result=Integer.MAX_VALUE;
        for (int right = 0; right <nums.length ; right++) {
            sum+=nums[right];
            while(sum>=target){
                result=Math.min(result,right-left+1);
                sum-=nums[left++];  //不断变更子序列的起始位置
            }
        }
        //如果result没有被赋值，就返回0，说明没有符合条件的子序列
        return result==Integer.MAX_VALUE?0:result;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen1(7, new int[]{2, 3, 1, 2, 4, 3}));
//        System.out.println(minSubArrayLen(15, new int[]{1, 2, 3, 4, 5}));

//        System.out.println(minSubArrayLen1(15, new int[]{1, 2, 3, 4, 5}));
    }
}
