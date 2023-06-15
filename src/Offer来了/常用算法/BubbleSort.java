package Offer来了.常用算法;

import java.util.Arrays;

//冒泡排序
public class BubbleSort {
    public static int[] bubbleSort(int[] arr){
        //外层循环控制排序趟数
        for (int i = 0; i <arr.length-1; i++) {
            //内层循环控制每一趟的排序次数
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] ints = bubbleSort(new int[]{4, 5, 6, 3, 2, 1});
        System.out.println(Arrays.toString(ints));
    }
}
