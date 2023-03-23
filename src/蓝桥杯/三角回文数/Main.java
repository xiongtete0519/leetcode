package 蓝桥杯.三角回文数;

public class Main {
    //判断三角数(直接超时)
    public static boolean threeNumber(Integer number){
        for (long k = 1; k <= number; k++) {
            long temp=k*(k+1)/2;
            if(temp==number){
                return true;
            }
        }
        return false;
    }
    //判断是否是回文数
    public static boolean backNumber(Long number){
        StringBuilder reverse = new StringBuilder(String.valueOf(number)).reverse();
        return String.valueOf(number).equals(reverse.toString());
    }
    public static void main(String[] args) {
        //求第一个大于20220514的三角回文数
        long number=20220514;
        for (long i = 4496; i <Long.MAX_VALUE ; i++) {
            long n=i*(i+1)/2;   //此时的n已经是三角数
            if(backNumber(n)&&n>number){
                System.out.println(n);
                break;
            }
        }
    }
}
