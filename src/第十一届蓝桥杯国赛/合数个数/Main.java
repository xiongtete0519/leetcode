package 第十一届蓝桥杯国赛.合数个数;

public class Main {
    public static void main(String[] args) {
        long sum=0;
        //1到2020的合数
        for (int i = 1; i <=2020 ; i++) {
            if(check(i)){
                sum++;
            }
        }
        System.out.println(sum);
    }
    //判断合数
    public static boolean check(int x){
        if(x==1||x==0){
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
