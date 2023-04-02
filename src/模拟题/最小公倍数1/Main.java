package 模拟题.最小公倍数1;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        BigInteger res = BigInteger.ONE;
        for (int i = 1; i <=n; i++) {
            BigInteger s = BigInteger.valueOf(i);
            BigInteger gcd = res.gcd(s);
            res = res.multiply(s).divide(gcd);
        }
        System.out.println(res);
    }
    //a*b=最大公约数*最小公倍数
    public static long multiple(long a,long b){
        long gcd = gcd(a, b);
        return a*b/gcd;
    }
    public static long gcd(long a,long b){
        if(b==0){
            return a;
        }
        long min = Math.min(a, b);
        long max = Math.max(a, b);
        return gcd(min,max%min);
    }
}
