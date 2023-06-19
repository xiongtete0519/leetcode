package 笔试.携程2022春招笔试第一批.质因子统计;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static Map<Long,Long> res = new HashMap<>();
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int n=nextInt();
        long[] arr = new long[n + 1];
        for (int i = 1; i <=n ; i++) {
            arr[i]=nextLong();
        }
        for (int i = 1; i <=n ; i++) {
            long tmp = factor(arr[i]);
            if(!res.containsKey(tmp)){
                long factor = factor(tmp);
                res.put(tmp,factor);
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <=n; j++) {
                long tmp=arr[i]*arr[j];
                if(!res.containsKey(tmp)){
                    long factor = factor(tmp);
                    res.put(tmp,factor);
                }
            }
        }

    }
    //统计质因子个数
    public static long factor(long x){
        HashSet<Long> set = new HashSet<>();
        long i=2;
        while(x!=1){
            if(isPrime(i)&&x%i==0){
                x/=i;
                set.add(i);
            }else{
                i++;
            }
        }
        return set.size();
    }
    public static boolean isPrime(long x){
        if(x==0||x==1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(x);i++){
            if(x%i==0){
                return false;
            }
        }
        return true;
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
    public static long nextLong() throws IOException{
        st.nextToken();
        return (long)st.nval;
    }
}
