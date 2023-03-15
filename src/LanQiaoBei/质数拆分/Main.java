package LanQiaoBei.质数拆分;


public class Main {
    public static void main(String[] args) {
        int sum=0;
        int count=0;
        int number=2022;
        for (int i = 2; i <Integer.MAX_VALUE ; i++) {
            if(isPrime(i)){
                sum+=i;
                count++;
            }
            if(sum>number){
                System.out.println(count-1);
                break;
            }
            if(sum==number){
                System.out.println(count);
                break;
            }

        }
    }
    public static boolean isPrime(int num){
        for (int i = 2; i <=Math.sqrt(num) ; i++) {
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}
