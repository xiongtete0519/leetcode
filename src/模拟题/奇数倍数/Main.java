package 模拟题.奇数倍数;

public class Main {
    public static void main(String[] args) {
        for (long i = 2019; i <=Long.MAX_VALUE ; i+=2019) {
            if(i%2019==0&&check(i)){
                System.out.println(i);
                break;
            }
        }
    }
    //判断num的每一位数字是否是奇数
    public static boolean check(long num){
        String str = String.valueOf(num);
        for (int i = 0; i <str.length() ; i++) {
            int temp = Integer.parseInt(String.valueOf(str.charAt(i)));
            if(temp%2==0){
                return false;
            }
        }
        return true;
    }
}
