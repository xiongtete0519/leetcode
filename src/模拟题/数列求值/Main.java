package 模拟题.数列求值;

public class Main {
    public static final int MOD=10000;
    public static void main(String[] args) {
        int[] arr = new int[20190325];
        arr[1]=1;
        arr[2]=1;
        arr[3]=1;
        for (int i = 4; i <=20190324 ; i++) {
            arr[i]=(arr[i-1]+arr[i-2]+arr[i-3])%MOD;
        }
        System.out.println(arr[20190324]);
    }
}
