package 十一届Java研究生组.排序;

import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
         //思路1:要求字典序最小，那肯定要尽量让字母从a开始挨个出现 —— a,b,c,d.....
        //思路2:冒泡排序中，如果一个数组是完全倒序，则需要的交换的次数最多,尽可能选用完全倒序的数组，可以使字母数尽可能少
        //思路3:完全倒序的数组，用冒泡排序一共要交换 n*(n-1)/2 次 —— (n-1) + (n-2) + ... + 3 + 2 + 1 , 等差数列求和公式
        //思路4:解方程 n*(n-1)/2 = 100, 得 n ~ 14.65 ,所以字母最少为15个
        //思路5: 15个字母从 a 开开始，依次是 a,b,c,d,e,f,g,h,i,j,k,l,m,n,o
        //思路5:但是当 n = 15时，完全倒序的数组需要排105次，显然不符合题目100次的要求，所以要在基础上进行修改
        //思路6: 15个字母完全倒序 —— o,n,m,l,k,j,i,h,g,f,e,d,c,b,a 扣除5次排序，还要字典序最小，将第六个字母 j 移至第一位即可
        //最终结果:j,o,n,m,l,k,i,h,g,f,e,d,c,b,a
        System.out.println("jonmlkihgfedcba");
        scan.close();
    }
}