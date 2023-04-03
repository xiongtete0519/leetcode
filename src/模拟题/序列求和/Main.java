package 模拟题.序列求和;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
//严重超时
public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count=1;
        for (int i = 1; i <=60 ; i++) {
            for (int j = 1; j <=Integer.MAX_VALUE ; j++) {
                if(factor(j)==i){
                    System.out.println(factor(j)+" "+i);
                    map.put(i,factor(j));
                    break;
                }
            }
        }
        long sum = map.entrySet().stream().map(Map.Entry::getValue).mapToLong(x->x).sum();
        System.out.println(sum);

    }
    public static int factor(int x){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <=Math.sqrt(x) ; i++) {
            if(x%i==0){
                set.add(i);
                int j = x / i;
                set.add(j);
            }
        }
        return set.size();
    }
}
