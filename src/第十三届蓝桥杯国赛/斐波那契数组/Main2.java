package 第十三届蓝桥杯国赛.斐波那契数组;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
//ac
//超过1000000的值都是需要修改的
public class Main2 {
    static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static int max=0;//输入数列与正确的斐波那契数列匹配的最大值
    static int items=0; //正确数组中，值不超过1000000的个数
    static int[] arr=new int[1000010];  //输入数组
    static int[] f=new int[1000010];    //正确的斐波那契数组
    public static final int N=1000000;
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for (int i = 0; i <n; i++) {
            arr[i]=nextInt();
        }
        for (int i = 1; i <=N ; i++) {
            getFibon(i);    //生成以i为初项的斐波那契数列
            //将输入数组与生成的斐波那契数列匹配
            int count = compare();
            max=Math.max(max,count);    //找出匹配个数最多的次数
        }
        //总项数-匹配的最大值就是最少需要修改的次数
        System.out.println(n-max);
    }
    //将输入数组与生成的斐波那契数列匹配,返回匹配的个数
    public static int compare(){
        int count=0;
        for(int i=0;i<items;i++){
            if(arr[i]==f[i]){
                count++;
            }
        }
        return count;
    }

    //根据指定初始值生成斐波那契数列
    public static void getFibon(int first){
        items=2;
        f[0]=f[1]=first;
        for (int i = 2;; i++) {
            f[i]=f[i-1]+f[i-2];
            if(f[i]>N){
                break;
            }
            items++;
        }
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
