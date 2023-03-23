package 模拟题.美丽的区间;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

//美丽的区间
public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int s = nextInt();
        int[] arr = new int[n + 1];
        long[] sum = new long[n + 1];   //记录前缀和
        long ans=Integer.MAX_VALUE;
        for (int i = 1; i <=n ; i++) {
            arr[i]=nextInt();
            sum[i]=sum[i-1]+arr[i]; //前缀和:用来存储左边界到第i项的和
        }
        //枚举i 即二分的左边界，然后将以左边界为起始的前缀和组成的数组中来通过二分查找目标值s
        for (int i = 1; i <=n ; i++) {
            int left=i;
            int right=n;
            while(left<right){
                int mid=(left+right)>>1;
                //通过二分不断查找第一个满足大于等于s的序列下标
                if(sum[mid]-sum[i-1]>=s){
                    right=mid;
                }else{
                    left=mid+1;
                }
            }
            /**
             * 此时我们只需要将二分得到的最终结果sum[right]键入前i-1项的和便得到了满足大于给定值
             * 的和。因为我们枚举到了左边界，题目要求我们找到最短的区间，所以我们还应该找出结果当中
             * 最小的值，才是我们最终要求的答案
             */
            if(sum[right]-sum[i-1]>=s){
                ans=Math.min(ans,right-i+1);
            }
        }
        System.out.println(ans==Integer.MAX_VALUE?0:ans);

    }
    public static long nextLong() throws IOException{
        st.nextToken();
        return (long)st.nval;
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
