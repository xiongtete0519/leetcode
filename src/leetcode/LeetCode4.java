package leetcode;
//leetcode4:两个正序数组的中位数
public class LeetCode4 {
    public static double findMedianSortedArrays(int[] num1,int[] num2){
        int m=num1.length;
        int n=num2.length;
        int[] result=new int[m+n];
        int i=0;
        int j=0;
        int count=0;
        while(count<m+n){
            if(i==m){   //第一个数组已经全部被复制
                result[count++]=num2[j++];
            }else if(j==n){   //第二个数组已经全部被复制
                result[count++]=num1[i++];
            }else if(num1[i]<=num2[j]){
                result[count++]=num1[i++];
            }else{
                result[count++]=num2[j++];
            }
        }
        if((m+n)%2==0){
            return (result[(m+n)/2-1]+result[(m+n)/2])/2.0;
        }else{
            return result[(m+n)/2];
        }
    }

    public static void main(String[] args) {
        int[] num1= new int[]{1, 2, 3, 4};
        int[] num2= new int[]{3, 6, 7,8};
        double medianSortedArrays = findMedianSortedArrays(num1, num2);
        System.out.println(medianSortedArrays);
    }
}
