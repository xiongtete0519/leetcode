package 模拟题.买不到的数目;

import java.util.HashSet;
import java.util.Scanner;

//ax+by=C不定方程，若a、b互质，则方程一定有解，且解的数目有无穷多个
//若C是gcd(a,b)的倍数，方程一定有解，无穷多解
//在所有使得方程不成立的解中，C最大=a*b-a-b
//x,y都是大于等于0的整数，在这个限定条件下有的C是无解的，C的上届是a*b
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        System.out.println(a*b-a-b);

        fun(a,b);

        scan.close();
    }

    //方法二：枚举a*x=b*y的值，上边界是a*b
    //可以确定a*b>=28得到所有制都能够拼出来
    public static void fun(int a,int b){
        HashSet<Integer> set = new HashSet<>();
        //记录所有a*b以内能用a和b拼出来的值
        for (int x = 0; a*x <=a*b ; x++) {
            for (int y = 0; a*x+b*y<=a*b; y++) {
                set.add(a*x+b*y);
            }
        }
        for (int i = a*b; i >=0; i--) {
            if(!set.contains(i)){
                System.out.println(i);
                break;
            }
        }
    }
}
