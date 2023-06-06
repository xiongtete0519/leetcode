package 国赛复习.斐波那契数组;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 即使初值为1，到第31个的时候就超出了范围，也就是说后面的值都需要修改
 * 初始值并没有指定，并没有说明初始值就是1，遍历也不会超时，每次不超过30次
 *
 */
public class Main {
    public static final int MAXN=1000010;
    public static final int N=1000000;
    public static int[] arr=new int[MAXN];  //需要修改的数组
    public static int[] f=new int[MAXN];    //正确的斐波那契数组
    public static int max=0;    //输入数组与正确数组的匹配的最大值
    public static int items=0;  //正确数组中，值不超过1000000的个数
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int n=nextInt();
        for (int i = 0; i <n; i++) {
            arr[i]=nextInt();
        }
        for (int i = 1; i <=N; i++) {
            getFibon(i);//生成以i为初始值的斐波那契数列
            //将输入的数组生成的斐波那契数组进行匹配，看匹配个数
            int count=compare();
            max=Math.max(max,count);
        }
        //总项数-匹配的最大值就是最少修改的次数
        System.out.println(n-max);
    }
    //根据指定初始值生成斐波那契数列
    public static void getFibon(int first){
        items=2;
        f[0]=f[1]=first;
        for (int i = 2; ; i++) {
            f[i]=f[i-1]+f[i-2];
            if(f[i]>N){
                break;
            }
            items++;
        }
    }
    public static int compare(){
        int count=0;
        for (int i = 0; i <items; i++) {
            if(arr[i]==f[i]){
                count++;
            }
        }
        return count;
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
