package 国赛打游击.二进制问题;

import java.util.Scanner;
//40%
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        int k = scan.nextInt();
        long res=0;
        for (int i = 1; i <=n; i++) {
            //转换为二进制字符串
            String s = Long.toBinaryString(i);
//            int count=0;
//            //统计二进制字符串中1的个数
//            for (int j = 0; j <s.length() ; j++) {
//                if(Long.parseLong(String.valueOf(s.charAt(j)))==1){
//                    count++;
//                }
//            }
            int count=s.replaceAll("0","").length();
            if(count==k){
                res++;
            }
        }
        System.out.println(res);
    }
}
