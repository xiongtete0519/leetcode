package 十三届Java研究生组.质因数个数;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(in.readLine());
        List<Long> list = yueshu(n);
//        out.println(list);
        //统计所有因子中质数的数量即可,我们在集合添加的时候就做过重复的判断了，这里用distinct是为了保险一点
        long count = list.stream().filter(Main::isPrime).distinct().count();
        out.println(count);
        out.flush();
        out.close();
        in.close();
    }
    //返回所有因子
    public static List<Long> yueshu(long x){
        ArrayList<Long> list = new ArrayList<>();
        for (long i = 1L; i <=Math.sqrt(x); i++) {
            if(x%i==0){
                list.add(i);
                long j = x / i;
                if(j!=i){
                    list.add(j);
                }
            }
        }
        return list;
    }
    //判断质数
    public static boolean isPrime(long num){
        if(num==0||num==1){
            return false;
        }
        for (long i = 2L; i <=Math.sqrt(num); i++) {
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}
