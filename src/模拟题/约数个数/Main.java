package 模拟题.约数个数;

public class Main {
    public static void main(String[] args) {
        int n=1200000;
        System.out.println(factor(n));
    }
    public static long factor(int n){
        long sum=0;
        for (int i = 1; i <=Math.sqrt(n); i++) {
            if(n%i==0){
                sum++;
                int j = n / i;
                if(i!=j){
                    sum++;
                }
            }
        }
        return sum;
    }
}
