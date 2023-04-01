package 十届Java研究生组.RSA解密;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        System.out.println(findPQ(1001733993063167141L,212353L));
        BigInteger n = new BigInteger("1001733993063167141");
        BigInteger d = new BigInteger("212353");
        BigInteger c = new BigInteger("20190324");

        BigInteger p = new BigInteger("891234941");
        BigInteger q = new BigInteger("1123984201");
        //由于d.e%(p-1)(q-1)==1,利用逆元求解e的值
        BigInteger e = d.modInverse(p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)));

        //原文:X=C^e %n
        BigInteger res = c.modPow(e, n);
        System.out.println(res);
    }
    //p=891234941   q=1123984201
    //找p和q   其中d与(p-1)(q-1)互质：也就是最大公约数是1
    public static List<Long> findPQ(long n,long d){
        ArrayList<Long> list = new ArrayList<>();
        for (long i = 2L; i <=Math.sqrt(n); i++) {
            if(n%i==0&&gcd(d,(n/i-1)*(i-1))==1&&isPrime(i)&&isPrime(n/i)){
                list.add(i);
                list.add(n/i);
            }
        }
        return list;
    }
    public static boolean isPrime(long n){
        if(n==0||n==1){
            return false;
        }
        for (int i = 2; i <=Math.sqrt(n) ; i++) {
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    //求gcd
    public static long gcd(long a,long b){
        if(b==0){
            return a;
        }
        long min = Math.min(a, b);
        long max = Math.max(a, b);
        return gcd(min,max%min);
    }
}
