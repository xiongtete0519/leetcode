package LanQiaoBei.重新排序;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=scan.nextInt();
        }
        //查询的数目
        int m = scan.nextInt();
        int[][] query = new int[m][2];
        //用一个count数组存储元素被加过的次数
        int[] count = new int[n];
        for (int i = 0; i < query.length; i++) {
            query[i][0]=scan.nextInt();
            query[i][1]=scan.nextInt();
        }

        //开始记录每个元素被加过的次数
        for (int i =0; i <query.length; i++) {
            for (int j = query[i][0]-1; j <=query[i][1]-1; j++) {
                count[j]++;
            }
        }
//        System.out.println(Arrays.toString(count));

        //未排序之前的和
        int sum = SUM(arr, count);
//        System.out.println("未排序之前的和为:"+sum);
        //要想重新排列数组使得查询结果的综合最大
        //只需让arr最大的元素被加的次数最多即可
        //为了方便计算，将arr与count排序之后再进行计算
        Arrays.sort(arr);
        Arrays.sort(count);

        int addSum=SUM(arr,count);
        System.out.println(addSum-sum);

        scan.close();
    }

    public static int SUM(int[] arr,int[] count){
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i]*count[i];
        }
        return sum;
    }
}
