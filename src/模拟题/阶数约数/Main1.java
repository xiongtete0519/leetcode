package 模拟题.阶数约数;

/**
 * 任意一个正整数x都可以表示成若干个质数乘机的形式
 * 最后的结果就是质因子的出现次数+1之后连乘即可
 * 正约数个数=(a1+1)*(a2+1)...(an+1),a1,a2,an分别是各个质因子的出现次数
 * 比如8=2*2*2, 约数为1,2,4,8   正约数=(3+1)=4
 * 比如180=2*2*3*3*5  则正约数=(2+1)*(2+1)*(1+1)=18
 *
 */
public class Main1 {
    public static int[] arr;
    public static long sum=1;
    public static void main(String[] args) {
        arr = new int[101];
        for (int i = 2; i <=100 ; i++) {
            zhiyin(i);
        }
        for (int i = 2; i <=100; i++) {
            if(arr[i]!=0){
               sum*=(arr[i]+1);
            }
        }
        System.out.println(sum);
    }
    //统计n的质因数出现次数，并用arr数组记录
    public static void zhiyin(int n){
        int i=2;
        while(n!=1){
            if(n%i==0&&isPrime(i)){
               arr[i]++;
               n/=i;
            }else{
                i++;
            }
        }
    }
    public static boolean isPrime(int x){
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
