package 模拟题.特别数的和;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long res=0;
        for (int i = 1; i <=n; i++) {
            if(have(i)){
                res+=i;
            }
        }
        System.out.println(res);
    }
    //判断一个数字中是否包含2、0、1、9
    public static boolean have(Integer num){
        String str = String.valueOf(num);
       if(str.contains("2")||str.contains("0")||str.contains("1")||str.contains("9")){
           return true;
       }else{
           return false;
       }
    }
}
