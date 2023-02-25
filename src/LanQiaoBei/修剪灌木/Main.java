package LanQiaoBei.修剪灌木;

import java.util.Scanner;

public class Main {
    /**
     * 从每次被修以后到下一次被修的时间间隔就是能长的长度，
     * 时间间隔有alice到左边返回和到右边返回两种，取里面最大的
     * 灌木丛的最大长度是两边对称的
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        //遍历每一颗灌木丛
        for (int i = 0; i < n; i++) {
            //看看灌木丛是离最左边远还是最右边远
           int max=Math.max(i,n-1-i);
           //长度乘以2
            System.out.println(max*2);
        }
        scan.close();
    }
}
