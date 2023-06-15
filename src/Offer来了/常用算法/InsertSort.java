package Offer来了.常用算法;

import java.util.Arrays;
//插入排序
public class InsertSort {

    public static int[] insertSort(int[] arr){
        for (int i = 1; i <arr.length ; i++) {
            //待插入的数据
            int insertVal=arr[i];
            //被插入的位置(准备和前一个数进行比较)
            int index=i-1;
            //如果插入的数比被插入的数小
            while(index>=0&&insertVal<arr[index]){
                //则将arr[index]向后移动
                arr[index+1]=arr[index];
                //将index向前移动
                index--;
            }
            //将待插入的数据放在合适的位置
            arr[index+1]=insertVal;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] ints = insertSort(new int[]{6, 2, 5, 7, 8});
        System.out.println(Arrays.toString(ints));
    }
}
