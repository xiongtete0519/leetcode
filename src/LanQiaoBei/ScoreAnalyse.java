package LanQiaoBei;

import java.math.BigDecimal;
import java.util.Scanner;

public class ScoreAnalyse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();//考试人数
        int[] scores=new int[n];
        for (int i = 0; i < n; i++) {
            scores[i]=sc.nextInt();
        }
        int max=scores[0];
        int min=scores[0];
        int sum=scores[0];
        for (int i = 1; i < n; i++) {
            if(scores[i]>max){
                max=scores[i];
            }
            if(scores[i]<min){
                min=scores[i];
            }
            sum+=scores[i];
        }
        BigDecimal b = new BigDecimal(sum);
        BigDecimal average = b.divide(new BigDecimal(n),2,BigDecimal.ROUND_HALF_UP);
        System.out.println(max);
        System.out.println(min);
        System.out.println(average);

    }
}
