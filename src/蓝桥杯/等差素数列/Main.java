package 蓝桥杯.等差素数列;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Integer> list = new ArrayList<>();
    //素数：只能被1和本身整除
    public static  boolean isPrime(Integer number){
        for (Integer i = 2; i < number; i++) {
            if(number%i==0){
                return false;
            }
        }
        return true;
    }

    //计算长度为10的等差素数列的最小公差值
    public static Integer sequence(Integer len){
        for (int i = 1; i < 10000; i++) {//指定初值
            for (int j = 1; j <1000 ; j++) {//公差
                int k;
                //取len个值 看是否都为素数
                for (k = 0; k < len; k++) {
                    if(!isPrime(i+k*j)){
                        list.clear();
                        break;
                    }else{
                        list.add(i+k*j);
                    }
                }
                if(k==10){  //等差素数列已找到
                    return j;//返回公差最小值
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        System.out.println("长度为10的等差素数列的公差最小值为:"+sequence(10));
        list.forEach(x->{
            System.out.print(x+" ");
        });
    }

}
