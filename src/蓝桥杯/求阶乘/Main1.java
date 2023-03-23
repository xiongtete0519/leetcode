package 蓝桥杯.求阶乘;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        //二分查找
        Scanner scan = new Scanner(System.in);
        long k = scan.nextLong();   //末尾0的个数
        long l=1;
        long r=Long.MAX_VALUE-5;
        while(l<r){ //找符合条件的最小值
            long mid=(l+r)/2;
            if(getF(mid)>=k){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        if(getF(l)==k){
            System.out.println(l);
        }else{
            System.out.println(-1);
        }
        scan.close();

    }
    //求阶乘尾数0的个数其实就是求阶乘因子中5的个数
    public static long getF(long num){
        long res=0;
        while(num>0){
            res+=num/5;
            num/=5;
        }
        return res;
    }
}
