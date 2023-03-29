package 十一届Java研究生组.约数个数;

public class Main {
    public static void main(String[] args) {
        System.out.println(fun(78120));
    }
    //求约数个数
    public static long fun(int n){
        long count=0;
        for (int i = 1; i <=Math.sqrt(n) ; i++) {
            if(n%i==0){
                count++;
                int j = n / i;
                if(i!=j){
                    count++;
                }
            }
        }
        return count;
    }
}
