package 模拟题.合数个数;

public class Main {
    public static void main(String[] args) {
        long res=0;
        for (int i = 1; i <=2020 ; i++) {
            if(compositeNumber(i)){
                res++;
            }
        }
        System.out.println(res);
    }
    //判断合数
    public static boolean compositeNumber(int x){
        if(x==1||x==2||x==3){
            return false;
        }
        for (int i = 2; i <=Math.sqrt(x); i++) {
            if(x%i==0){
                return true;
            }
        }
        return false;
    }
}

