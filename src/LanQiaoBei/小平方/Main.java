package LanQiaoBei.小平方;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        long count=0;
        double half=n/2.0;
        for (long i = 1; i < n; i++) {
            if((i*i)%n<half){
                count++;
            }
        }
        System.out.println(count);
        scan.close();
    }
}
