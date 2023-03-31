package 模拟题.阶数约数;

public class Main {
    public static void main(String[] args) {
        //存储每个数分解完后，出现的次数(幂数)
        int[] arr = new int[101];
        long sum=1;
        for (int i = 2; i <=100 ; i++) {
            //将每个数分解质因数，即将这个数拆分为质数乘积的形式，记录分解的数的出现次数
            int j=2;
            int k=i;
            while(k!=j){
                if(k%j==0){
                    arr[j]++;
                    k=k/j;
                }else{
                    j++;
                }
            }
            //最后k==j就是分解到最后一个质数，将这个质数记录
            arr[j]++;
        }
        //根据公式，约数个数=(a1+1)*(a2+1)*...(an+1)  a就是质因数出现次数(幂数)
        for (int i = 2; i <=100;i++) {
            if(arr[i]!=0){
                sum*=(arr[i]+1);
            }
        }
        System.out.println(sum);
    }
}
