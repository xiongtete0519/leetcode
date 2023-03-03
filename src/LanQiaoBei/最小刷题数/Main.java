package LanQiaoBei.最小刷题数;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=scan.nextInt();
        }
        StringBuilder builder = new StringBuilder();
        //拷贝数组
        int[] count = Arrays.copyOf(arr, arr.length);
        Arrays.sort(count);
        int index=n/2;//定义中间数下标
        int middle=count[index];    //找出中间数
        for (int i = 0; i < n; i++) {
            if(arr[i]<middle&&n%2==0){  //小于中间数对应的数字，且个数为偶数
//                System.out.print(" "+(middle-arr[i]));    //用中间数-对应的数字
                builder.append(" ").append(middle - arr[i]);
            }else if(arr[i]<middle&&n%2!=0){//小于中间数对应的数字，且个数为奇数
//                System.out.print(" "+(middle-arr[i]+1));//中间数-对应的数字+1
                builder.append(" ").append(middle - arr[i]+1);
            }else if(arr[i]==middle||arr[i]>middle){//如果>=中间数对应的数字
//                System.out.print(" "+0);  //打印0
                builder.append(" ").append(0);
            }
        }
        System.out.println(builder.toString().trim());

        scan.close();
    }
}
