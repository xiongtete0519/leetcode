package leetcode1;
//合并两个有序数组
public class LeetCode88 {
    public static void merge(int[] nums1,int m,int[] nums2,int n){
        int i=0;
        int j=0;
        int k=0;
        int[] num=new int[m+n];
        while(i<m&&j<n){
            if(nums1[i]<=nums2[j]){
                num[k++]=nums1[i++];
            }else{
                num[k++]=nums2[j++];
            }
        }
        while(i<m){
            num[k++]=nums1[i++];
        }
        while(j<n){
            num[k++]=nums2[j++];
        }
        for (int i1 = 0; i1 < num.length; i1++) {
            nums1[i1]=num[i1];
        }
    }

    public static void main(String[] args) {
        int[] nums1=new int[]{1,2,3,0,0,0};
        int[] nums2=new int[]{2,5,6};
        int m=3;
        int n=3;
        for (int i : nums1) {
            System.out.println(i);
        }
    }

}
