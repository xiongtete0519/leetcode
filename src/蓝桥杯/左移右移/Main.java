package 蓝桥杯.左移右移;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i <n; i++) {
            list.addLast(i+1);
        }
        for (int i = 0; i <m ; i++) {
            String s = scan.next();
            int num = scan.nextInt();
            if(s.equals("L")){//左移
                //删除此列表中指定元素的第一个出现（从头到尾遍历列表时
                //由于此集合中没有重复元素，所以结果正确
                list.removeFirstOccurrence(num);
                list.addFirst(num);
            }else{//右移
                list.removeFirstOccurrence(num);
                list.addLast(num);
            }
        }
        list.forEach(x->{
            System.out.print(x+" ");
        });
        scan.close();
    }
}
