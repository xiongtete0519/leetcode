package 模拟题.倍数;

public class Main {
    public static void main(String[] args) {
        long sum=0;
        for (int i = 1; i <=2020 ; i++) {
            if(i%4==0&&i%6==0){
                sum++;
            }
        }
        System.out.println(sum);
    }
}
