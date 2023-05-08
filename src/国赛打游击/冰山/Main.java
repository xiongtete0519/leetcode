package 国赛打游击.冰山;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//2021国赛
public class Main {
    public static  HashMap<Long, Long> map = new HashMap<>();
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int n = nextInt();  //冰山数量
        int m = nextInt();  //观察的天数
        long k = nextLong();  //冰山的大小限制
        long[] v = new long[n + 1];   //每座冰山的体积
        long[] x = new long[m + 1]; //冰山的体积变化xi
        long[] y = new long[m + 1]; //每天结束前飘来体积为yi的冰山
        long[] res = new long[m + 1];   //收集结果
        //<val,count>:<冰山的体积val,体积为val的冰山数量>
//        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 1; i <=n ; i++) {
            v[i]=nextLong();
            push(v[i]);
        }
        for (int i = 1; i <=m ; i++) {
            x[i]=nextLong();
            y[i]=nextLong();
        }
        for (int i = 1; i <=m; i++) {
            //先全部加一个x
//            for (Map.Entry<Long, Long> entry : map.entrySet()) {
//                Long key = entry.getKey();
//                Long value = entry.getValue();
//                if (x[i]!=0) {
//                    long newKey = key + x[i];   //冰山体积加上x
//                    if (newKey == 0) {
//                        map.remove(key);
//                    }else if (newKey>k){//体积超过大小限制
//                        //一个k和newkey-k个1
//                        push(k);
//                        push(1,newKey-k);
//                        map.remove(key);
//                    }else{
//                        push(newKey);
//                        map.remove(key);
//                    }
//                }
//                //结束之前会飘来一个体积为y的冰山
//                push(y[i]);
//                long sum = map.entrySet().stream().mapToLong(t -> t.getValue() * t.getKey()).sum();
//                System.out.println(sum);
//            }
            Iterator<Map.Entry<Long, Long>> iterator = map.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<Long, Long> entry = iterator.next();
                Long key = entry.getKey();
                Long value = entry.getValue();
                if (x[i]!=0) {
                    long newKey = key + x[i];   //冰山体积加上x
                    if (newKey == 0) {
                        iterator.remove();
                    }else if (newKey>k){//体积超过大小限制
                        iterator.remove();
                        //分裂为一个k和newkey-k个1
                        push(k);
                        push(1,newKey-k);
                    }else{
                        iterator.remove();
                        push(newKey,value);
                    }
                }
                //结束之前会飘来一个体积为y的冰山
                push(y[i]);
            }
            long sum = map.entrySet().stream().mapToLong(t -> t.getValue() * t.getKey()).sum();
            System.out.println(sum);
        }
    }
    public static void push(long key){
        if(map.containsKey(key)){
            map.put(key,map.get(key)+1);
        }else{
            map.put(key,1L);
        }
    }
    public static void push(long key,long value){
        if(map.containsKey(key)){
            map.put(key,map.get(key)+1);
        }else{
            map.put(key,value);
        }
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

