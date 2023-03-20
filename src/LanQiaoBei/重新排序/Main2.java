package LanQiaoBei.重新排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
//80%
public class Main2 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int)st.nval;
        long[] arr = new long[n];
        for (int i = 0; i < arr.length; i++) {
            st.nextToken();
            arr[i]=(long)st.nval;
        }
        //查询的数目
        st.nextToken();
        int m = (int)st.nval;
        int[][] query = new int[m][2];
        //用一个count数组存储元素被加过的次数
        int[] count = new int[n];
        for (int i = 0; i < query.length; i++) {
            st.nextToken();
            query[i][0]=(int)st.nval;
            st.nextToken();
            query[i][1]=(int)st.nval;
        }

        //开始记录每个元素被加过的次数
        for (int i =0; i <query.length; i++) {
            for (int j = query[i][0]-1; j <=query[i][1]-1; j++) {
                count[j]++;
            }
        }
//        System.out.println(Arrays.toString(count));

        //未排序之前的和
        long sum = SUM(arr, count);
//        System.out.println("未排序之前的和为:"+sum);
        //要想重新排列数组使得查询结果的综合最大
        //只需让arr最大的元素被加的次数最多即可
        //为了方便计算，将arr与count排序之后再进行计算
        Arrays.sort(arr);
        Arrays.sort(count);

        long addSum=SUM(arr,count);
        System.out.println(addSum-sum);

    }

    public static long SUM(long[] arr,int[] count){
        long sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i]*count[i];
        }
        return sum;
    }
}
