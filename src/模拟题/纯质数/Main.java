package 模拟题.纯质数;

public class Main {
    public static void main(String[] args) {
        long res=0;
        for (int i = 1; i <=20210605; i++) {
            if(isPrime(i)&&isActualPrime(i)){
                res++;
            }
        }
        System.out.println(res);
    }
    //判断是否是纯质数
    public static boolean isActualPrime(int x){
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int tmp = Integer.parseInt(String.valueOf(chars[i]));
            if(!isPrime(tmp)){
                return false;
            }
        }
        return true;
    }
    //判断是否是质数
    public static boolean isPrime(int x){
        if(x==0||x==1){
            return false;
        }
        for (int i = 2; i <=Math.sqrt(x); i++) {
            if(x%i==0){
                return false;
            }
        }
        return true;
    }
}
