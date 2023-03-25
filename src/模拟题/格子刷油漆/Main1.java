package 模拟题.格子刷油漆;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        long [] a = new long[N+1];
        long [] b = new long[N+1];
        a[1]=1;
        b[1]=1;
        a[2]=6;
        b[2]=2;
        long sum=0;
        long x = (long)Math.pow(10, 9)+7;
        if(N==1){
            System.out.println(2);
            return;
        }
        if(N==2){
            System.out.println(24);
            return;
        }
        for(int i=2;i<=N;i++){
            b[i]=2*b[i-1]%x;
        }
        for(int i=3;i<=N;i++){
            a[i]=(2*a[i-1]+4*a[i-2]+b[i])%x;
        }
        sum=(4*a[N])%x;
        for(int j=2;j<N;j++){
            sum+=(8*b[j-1]*a[N-j])%x+(8*b[N-j]*a[j-1])%x;
            sum%=x;
        }
        System.out.print(sum);

    }
}
