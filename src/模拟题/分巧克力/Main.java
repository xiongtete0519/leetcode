package 模拟题.分巧克力;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 暴力+二分
 * 假设已经找到了最大的那条边长，那么巧克力可以分成的最大块数
 * 则是(巧克力的长/最大边长)*(巧克力的宽/最大边长)
 */
public class Main {
    public static int[] h=new int[100000];
    public static int[] w=new int[100000];
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int left=0;
        int right=100001;
        int result=0;
        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        int k = (int) st.nval;
        for (int i = 0; i <n; i++) {
            st.nextToken();
            h[i]=(int)st.nval;
            st.nextToken();
            w[i]=(int)st.nval;
        }
        //枚举+二分
        while(left<=right){
            int mid=(left+right)/2;
            int count=0;
            for (int i = 0; i <n ; i++) {
               count+=(h[i]/mid)*(w[i]/mid);
            }
            if(count>=k){
                left=mid+1;
                result=mid;
            }else{
                right=mid-1;
            }
        }
        System.out.println(result);
    }
}
