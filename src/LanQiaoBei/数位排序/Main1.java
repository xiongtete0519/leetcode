package LanQiaoBei.数位排序;


import java.util.*;

public class Main1 {
    //返回位数和
    public static Integer sum(int number){
        int [] nums=new int[String.valueOf(number).length()];
        int temp=number;
        for (int i = 0; i < nums.length; i++) {
            nums[i]=temp%10;
            temp=(temp-nums[i])/10;
        }
        return Arrays.stream(nums).sum();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int m=scan.nextInt();
        Integer[] arr = new Integer[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i]=i;
        }
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr,1,n+1, (o1, o2) -> sum(o1)-sum(o2));
        System.out.println(arr[m]);
    }
}
