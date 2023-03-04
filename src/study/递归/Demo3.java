package study.递归;

/**
 * Demo3
 * - 两个整数的最大公约数等于其中较小的数和两数相除余数的最大公约数（gcd)
 * - gcd(a,b) = gcd(b ,a%b)  a>b :当 b的值变成0的时候，a就是要求的最大公约数
 * 12和4的最大公约数  = 4 和 0     4
 */
public class Demo3 {
    public static void main(String[] args) {

        System.out.println(gcb(10,7));
        System.out.println(gcbFor(10,7));
    }
    //辗转相除法递归解法
    // 两个整数的最大公约数等于其中较小的数和两数相除余数的最大公约数
    public static int gcb(int a,int b){
        if(b==0){
            return a;
        }
        return gcb(b,a%b);
    }

    //循环
    public static int gcbFor(int a,int b){
        //这里a>b
        a= Math.max(a, b);
        b= Math.min(b, a);
       while(b!=0){
           int c=a%b;
           a=b;
           b=c;
       }
        return a;
    }
}
