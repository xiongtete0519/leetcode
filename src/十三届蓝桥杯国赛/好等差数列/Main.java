package 十三届蓝桥杯国赛.好等差数列;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;
//40%

public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int n=nextInt();    //数列长度
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=nextInt();
        }
        int m=nextInt();    //修改的次数
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int index=nextInt();    //要修改的索引
            int value=nextInt();    //修改后的值
            a[index]=value;
            //调用函数计算与好等差数列的距离
            ans[i]=distance(a);
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
    }
    //计算当前数列与好等差数列的距离
    public static int distance(int[] a){
        //统计斜率和出现的次数  斜率：出现次数
        HashMap<Integer, Integer> map = new HashMap<>();
        int max=Integer.MIN_VALUE;
        //枚举每一个点作为基准点，求与其他点的斜率，剔除非整数的斜率值
        for (int i = 0; i <a.length; i++) {
            for (int j = 0; j <a.length; j++) {
                if(i==j){
                    continue;
                }
                int y=a[j]-a[i];
                int x=j-i;
                if(y%x==0){
                    //计算斜率
                    int k=y/x;
                    if(map.containsKey(k)){
                        map.put(k,map.get(k)+1);
                    }else{
                        map.put(k,1);
                    }
                }
            }
            //统计相同斜率出现最多的次数
            Integer count = map.entrySet().stream().map(Map.Entry::getValue).max((o1, o2) -> o1 - o2).orElse(0);
            max=Math.max(max,count);
            map.clear();
        }
        return a.length-max-1;
    }

    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
