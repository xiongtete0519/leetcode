package 笔试.ACM模式练习.普通读;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main2_1 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("\\s");
            System.out.println(Arrays.stream(split).skip(1).mapToInt(Integer::parseInt).sum());
            System.out.println();
        }
        br.close();
    }
}
