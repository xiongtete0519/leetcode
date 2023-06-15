package Offer来了.常用算法;

import java.util.Arrays;

public class QuickSort {
    //快速排序
    public static int[] quickSort(int[] arr, int low, int high) {
        int start = low;  //从前向后比较的索引
        int end = high;   //从后向前比较的索引
        int key = arr[low];   //基准值
        while (end > start) {
            //从后向前比较
            while (end > start && arr[end] >= key) {
                end--;
            }
            //如果没有比基准值小的，则比较下一个，直到有比基准值小的，则交换位置，然后又从前向后比较
            if (arr[end] <= key) {
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
            //从前向后比较
            while (end > start && arr[start] <= key) {
                start++;
            }
            //如果没有比基准值大的，则比较下一个，直到有比基准值大的，交换位置
            if (arr[start] >= key) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
            //此时第一次循环比较结束，基准值的位置已经确定。左边的值都比基准值小，
            //右边的值都比基准值大，但是两边的顺序还有可能不一样，接着进行下面的递归调用
        }
        //递归左边序列：从第一个索引位置到“基准索引值-1”
        if (start > low) {
            quickSort(arr, low, start - 1);
        }
        //递归右边序列，从“基准索引值+1”到最后一个位置
        if (end < high) {
            quickSort(arr, end + 1, high);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] ints = quickSort(new int[]{6, 9, 5, 7, 8}, 0, 4);
        System.out.println(Arrays.toString(ints));
    }
}
