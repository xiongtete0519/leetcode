package 第十届蓝桥杯国赛.无方集合;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 1; i <=100; i++) {
            if(check(i)){
                list1.add(i);
            }else{
                list.add(i);
            }
        }
        list1.forEach(x->{
            System.out.print(x+" ");
        });
        System.out.println();
        list.forEach(x->{
            System.out.print(x+" ");
        });
    }

    //判断是否是完全平方数
    public static boolean check(int n) {
        long sqrt = (long) Math.sqrt(n);
        if (sqrt * sqrt == n) {
            return true;
        }
        return false;
    }

}
