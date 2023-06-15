package Offer来了.常用算法;

import java.util.Arrays;

//基数排序
public class RadixSort {
    /**
     *
     * @param array 数组
     * @param maxDigit 数组最大位数
     * @return
     */
    public static int[] radixSort(int[] array,int maxDigit){
        //数组最大位数的数据上限，比如3位数的最大上限为1000
        double max = Math.pow(10, maxDigit + 1);
        int n=1;    //代表位数对应的数，1，10，100......
        int k=0;    //保存每一位排序后的结果用于下一位的排序输入
        int length=array.length;
        //bucket用于保存每次排序后的结果，将当前位上排序结果相同的数字放在同一个桶里
        int[][] bucket=new int[10][length];
        int[] order=new int[length];    //用于保存每个桶里面有多少个数字
        while(n<max){
            //将数组array里的每个数字都放在相应的桶里
            for (int num : array) {
                int digit=(num/n)%10;
                bucket[digit][order[digit]]=num;
                order[digit]++;
            }
            //将前一个循环的桶里的数据覆盖到原数组中，用于保存这一位的排序结果
            for (int i = 0; i < length; i++) {
                //在这个桶中有数据，从上到下遍历这个桶并将数据保存到原数组中
                if(order[i]!=0){
                    for (int j = 0; j < order[i]; j++) {
                        array[k]=bucket[i][j];
                        k++;
                    }
                }
                order[i]=0; //将桶中的计数器设置为0，用于下一次位排序
            }
            n*=10;
            k=0;    //将k设置为0，用于下一轮保存位排序结果
        }
        return array;
    }

    public static void main(String[] args) {
        int[] ints = radixSort(new int[]{1, 56, 7, 5, 304, 12, 102, 45, 183, 3, 345, 123}, 3);
        System.out.println(Arrays.toString(ints));
    }
}
