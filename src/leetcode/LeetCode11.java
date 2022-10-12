package leetcode;
//leetcode11:盛水最多的容器
public class LeetCode11 {

    //超时
    public static int maxArea1(int[] height) {
        int min=1;
        int len=1;
        int tempArea=0;
        int area=0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height.length; j++) {
                min= Math.min(height[i], height[j]);
                len=j-i;
                tempArea=min*len;
                if(tempArea>area){
                    area=tempArea;
                    System.out.println("i="+i);
                    System.out.println("j="+j);
                }
            }
        }
        return area;
    }
    //左右工作指针，每次只移动min那边的指针
    public static int maxArea(int[] height) {
        int min=0;  //记录两个值中的最小值
        int len=1;  //两个值之间的距离，算面积要用
        int left=0; //左指针
        int right=height.length-1;  //右指针
        int area=0; //记录面积
        while(left<=height.length-1&&right>=0){//左指针往右边移，右指针往左边移
            //计算两个值之间的距离
            len=Math.abs(right-left);
            //求得最小值
            min=Math.min(height[left],height[right]);
            //每次只移动min那边的指针
            if(height[left]>height[right]){
                right--;    //右指针左移
            }else{
                left++;     //左指针右移
            }
            if(len*min>area){
                area=len*min;   //记录最大面积
            }
        }
        return area;
    }

    public static void main(String[] args) {
//        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
