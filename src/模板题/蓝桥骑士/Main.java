package 模板题.蓝桥骑士;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//贪心+二分查找
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=scan.nextInt();
        }
        ArrayList<Integer> s = new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            if(s.isEmpty()||a[i]>s.get(s.size()-1)){
                s.add(a[i]);
            }else{
                //二分查找
                int j = Collections.binarySearch(s, a[i]);
                if(j<0){
                    j=-j-1;
                }
                s.set(j,a[i]);
            }
        }
        System.out.println(s.size());
    }
}
