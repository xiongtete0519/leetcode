package Offer来了.常用算法;

import java.util.Arrays;

//希尔排序
public class ShellSort {
    public static int[] shellSort(int[] arr){
        int dk=arr.length/3+1;
        while(dk!=1){
            shellInsertSort(arr, dk);
            dk=dk/3+1;
        }
        //dk==1
        shellInsertSort(arr,dk);
        return arr;
    }
    public static void shellInsertSort(int[] a,int dk){
        //类似于插入排序算法，但插入排序算法的增量是1，这里的增量是dk,将1换成dk即可
        for (int i = dk; i <a.length ; i++) {
            if(a[i]<a[i-dk]){
                int j;
                int x=a[i]; //x为待插入的元素
                a[i]=a[i-dk];
                for(j=i-dk;j>=0&&x<a[j];j=j-dk){
                    //通过循环，逐个后移一位找到待插入的位置
                    a[j+dk]=a[j];
                }
                a[j+dk]=x;//将数据插入对应的位置
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = shellSort(new int[]{21, 25, 49, 26, 16, 8});
        System.out.println(Arrays.toString(ints));
    }
}
