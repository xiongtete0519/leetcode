package 蓝桥杯.约数个数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int) st.nval;
        long count=0;
        for (int i = 1; i <=n ; i++) {
            if(n%i==0){
                count++;
            }
        }
        System.out.println(count);
        System.out.println(yeushu(n));
    }
    public static int yeushu(int n){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <=Math.sqrt(n) ; i++) {
            if(n%i==0){
                set.add(i);
                set.add(n/i);
            }
        }
        return set.size();
    }
}
