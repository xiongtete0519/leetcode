package 国赛复习.答疑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
//贪心
public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int n=nextInt();
        int[][] arr=new int[n][3];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <3 ; j++) {
                arr[i][j]=nextInt();
            }
        }
        //根据每行的总和大小进行排序
        Arrays.sort(arr,(a,b)->(a[0]+a[1]+a[2])-(b[0]+b[1]+b[2]));
        //最小时间
        long res=0; //记录发消息时刻的时间和
        long sum=0; //记录所有总和
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <3 ; j++) {
                sum+=arr[i][j];
                if(j==1){
                    res+=sum;
                }
            }
        }
        System.out.println(res);
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
