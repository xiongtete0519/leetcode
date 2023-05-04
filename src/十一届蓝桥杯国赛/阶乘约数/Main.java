package 十一届蓝桥杯国赛.阶乘约数;
import java.util.HashMap;
import java.util.Map;

/**
 * 5!=2*3*4*5=(2^3)*(3^1)*(5^1)
 * 则阶乘约数=(3+1)*(1+1)*(1+1)=16
 */
public class Main {
    public static Map<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        long res=1;
        for (int i = 2; i <=100 ; i++) {
            fun(i);
        }
        //统计质因子幂数然后利用约数定理计算结果
        for (Integer value : map.values()) {
            res*=(value+1);
        }
        System.out.println(res);
    }
    //统计质因数和出现的次数即可。
    public static void fun(int x){
        int i=2;
        while(x!=1){
            if(x%i==0&&isPrime(i)){
                if(map.containsKey(i)){
                    map.put(i,map.get(i)+1);
                }else{
                    map.put(i,1);
                }
                x/=i;
            }else{
                i++;
            }
        }
    }

    public static boolean isPrime(int x){
        if(x==1||x==0){
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
