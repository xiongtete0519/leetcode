package 国赛复习.好等差数列;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int n=nextInt();
        int[] arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=nextInt();
        }
        int m=nextInt();
        //m次修改
        int[] ans=new int[m];
        for (int i = 0; i <m ; i++) {
            int index=nextInt();
            int value=nextInt();
            arr[index]=value;
            //调用函数计算与好等差数列之间的距离
            ans[i]=distance(arr);
        }
        for (int i = 0; i <ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
    }
    //计算与好等差数列之间的距离
    public static int distance(int[] arr) {
        int max=Integer.MIN_VALUE;
        //统计斜率和出现的次数  斜率:出现次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <arr.length; i++) {   //枚举每个点为基准点，计算与其他点的斜率
            for (int j = 0; j <arr.length ; j++) {
                if(i==j){
                    continue;
                }
                int y=arr[j]-arr[i];
                int x=j-i;
                if(y%x==0){ //只统计整数的斜率
                    //计算斜率
                    int k=y/x;
                    map.put(k,map.getOrDefault(k,0)+1);
                }
            }
            //统计相同斜率出现最多的次数
            Integer count = map.entrySet().stream().map(Map.Entry::getValue).max((o1, o2) -> o1 - o2).orElse(0);
            max=Math.max(max,count);
            map.clear();
        }
        //相同斜率为max个，点有max+1个，所以需要修改的点的数量为arr.length-max-1
        return arr.length-max-1;
    }

    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
