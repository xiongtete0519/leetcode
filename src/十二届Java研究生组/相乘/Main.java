package 十二届Java研究生组.相乘;

public class Main {
    public static final long MOD=1000000007;
    public static final long NUM=999999999;
    public static void main(String[] args) {
        long ans=0;
        for (long i = 1; i <MOD; i++) {
            if(i*2021%MOD==NUM){
               ans=i;
               break;
            }
        }
        System.out.println(ans);
    }
}
