package 国赛复习.阶乘约数;
//数论
public class Main {
    public static int[] arr;    //统计质因子的出现次数
    public static long sum=1;
    public static void main(String[] args) {
        arr=new int[101];
        for (int i = 2; i <=100 ; i++) {
            zhiyin(i);
        }
        for (int i = 2; i <=100 ; i++) {
            if(arr[i]!=0){
                sum*=(arr[i]+1);
            }
        }
        System.out.println(sum);
    }
    //统计n的质因数出现次数,并用arr数组记录
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
