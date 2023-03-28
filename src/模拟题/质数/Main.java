package 模拟题.质数;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i <n; i++) {
            if(zhishu(i)){
                list.add(i);
            }
        }
        list.forEach(x->{
            System.out.print(x+" ");
        });
        System.out.println();
        System.out.println(list.size());
        scan.close();
    }
    //判断一个数是不是质数
    public static boolean zhishu(int n){
        for (int i = 2; i <=Math.sqrt(n) ; i++) {
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
