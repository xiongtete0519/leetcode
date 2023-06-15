package Offer来了.常用算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//桶排序
public class BucketSort {
    public static int[] bucketSort(int[] arr){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i <arr.length ; i++) {
            max=Math.max(max,arr[i]);
            min=Math.min(min,arr[i]);
        }
        //创建桶
        int bucketNum=(max-min)/arr.length+1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<>());
        }
        //将每个元素都放入桶中
        for (int i = 0; i <arr.length; i++) {
            int num=(arr[i]-min)/(arr.length);
            bucketArr.get(num).add(arr[i]);
        }
        //对每个桶都进行排序
        for (int i = 0; i < bucketArr.size(); i++) {
            Collections.sort(bucketArr.get(i));
        }
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < bucketArr.size(); i++) {
            resultList.addAll(bucketArr.get(i));
        }
        for (int i = 0; i < resultList.size(); i++) {
            arr[i]=resultList.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] ints = bucketSort(new int[]{3, 6, 5, 9, 7, 8});
        System.out.println(Arrays.toString(ints));
    }
}
