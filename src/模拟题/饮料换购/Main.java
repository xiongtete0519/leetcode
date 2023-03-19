package 模拟题.饮料换购;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer scan = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        scan.nextToken();
        int n = (int) scan.nval;
        int count=n;
        while(true){
            //能换多少瓶
            int temp = n / 3;
            count+=temp;
            //计算剩余的瓶盖数量(算上刚刚新换的)
            n=n-temp*3+temp;
            if(n/3==0){
                break;
            }
        }
        System.out.println(count);
    }
}
