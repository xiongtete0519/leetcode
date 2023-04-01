package 十届Java研究生组.质数;

public class Main {
    public static void main(String[] args) {
        long count=0;
        long res=0;
        for (int i = 1; i <Integer.MAX_VALUE ; i++) {
            if(isPrime(i)){
                count++;
            }
            if(count==2019){
                res=i;
                break;
            }
        }
        System.out.println(res);

    }
    public static boolean isPrime(int n){
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
}
