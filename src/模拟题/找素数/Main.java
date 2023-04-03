package 模拟题.找素数;

public class Main {
    public static void main(String[] args) {
       int n=100002;
       int count=0;
        for (int i = 2; i <Integer.MAX_VALUE; i++) {
            if(isPrime(i)){
                count++;
            }
            if(count==n){
                System.out.println(i);
                break;
            }
        }
    }
    //判断素数
    public static boolean isPrime(long x){
        if(x==0||x==1){
            return false;
        }
        for (int i = 2; i <=Math.sqrt(x) ; i++) {
            if(x%i==0){
                return false;
            }
        }
        return true;
    }
}
