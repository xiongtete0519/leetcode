package LanQiaoBei.星期计算;

public class Main {
    public static void main(String[] args) {
        long n = (long) (Math.pow(20, 22) % 7);
        long week=(n+6)%7;
        System.out.println(week==0?7:week);
    }
}
