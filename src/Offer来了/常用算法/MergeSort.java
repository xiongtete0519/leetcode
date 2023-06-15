package Offer来了.常用算法;

import java.util.Arrays;
//归并排序
public class MergeSort {
    public static int[] mergeSort(int[] data){
        sort(data,0,data.length-1);
        return data;
    }
    //对左右两边的数据进行递归
    public static void sort(int[] data,int left,int right){
        if(left>=right){
            return;
        }
        //找出中间索引
        int center=(left+right)>>1;
        //对左边的数组进行递归排序
        sort(data,left,center);
        //对右边的数组进行递归排序
        sort(data,center+1,right);
        //对两个数组进行归并
        merge(data,left,center,right);
    }
    //和两个有序数组的合并操作类似，最后剩余的直接接过去就行
    public static void merge(int[] data,int left,int center,int right){
        //临时数组
        int[] tmpArr=new int[data.length];
        //右边数组第一个元素的索引
        int mid=center+1;
        //third记录临时数组的索引
        int third=left;
        //缓存左边数组第一个元素的索引
        int tmp=left;
        while(left<=center&&mid<=right){
            //从两个数组中取出最小的值放入临时数组中
            if(data[left]<=data[mid]){
                tmpArr[third++]=data[left++];
            }else{
                tmpArr[third++]=data[mid++];
            }
        }
        //将剩余部分依次放入临时数组中(在实际工作中，两个while只会执行其中一个)
        while(mid<=right){
            tmpArr[third++]=data[mid++];
        }
        while(left<=center){
            tmpArr[third++]=data[left++];
        }
        //将临时数组的内容复制到原始数组中
        //(原left-right范围内的内容被复制到原数组中)
        while(tmp<=right){
            data[tmp]=tmpArr[tmp++];
        }
    }

    public static void main(String[] args) {
        int[] ints = mergeSort(new int[]{4, 1, 3, 9, 6, 8});
        System.out.println(Arrays.toString(ints));
    }
}
