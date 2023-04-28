package 十三届蓝桥杯国赛.斐波那契数组;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
//55%
public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static int[] arr;
    public static long count=0;
    public static void main(String[] args) throws IOException{
        int n = nextInt();
        arr = new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=nextInt();
        }
//        Arrays.stream(arr).forEach(System.out::println);
        fun();
        System.out.println(count);
    }
    //暴力法破解
    public static void fun(){
        if(arr[0]!=arr[1]){
            arr[1]=arr[0];
            count++;
        }
        for(int i=2;i<arr.length;i++){
            if(arr[i]!=arr[i-1]+arr[i-2]){
                arr[i]=arr[i-1]+arr[i-2];
                count++;
            }
        }
    }

    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
