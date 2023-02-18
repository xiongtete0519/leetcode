package CSDN;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str_0 = scan.nextLine().trim();
        int n = Integer.parseInt(str_0);




        String str_1 = scan.nextLine();
        String[] line_list_1 = str_1.trim().split(" ");
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < line_list_1.length; i++){
            arr.add(Integer.parseInt(line_list_1[i]));
        }



        scan.close();

        int result = solution(n, arr);

        System.out.println(result);

    }

    public static int solution(int n, ArrayList<Integer> arr){
        int result = 0;

        // TODO: 请在此编写代码
        BigDecimal maxValue= BigDecimal.valueOf(1e18);
        System.out.println(maxValue);


        return result;
    }
}

