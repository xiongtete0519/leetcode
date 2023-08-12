package 笔试.ACM模式练习.快读;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for (int i = 0; i < n; i++) {
            int m = nextInt();
            int[] arr = new int[m];
            for (int j = 0; j < m; j++) {
                arr[i] = nextInt();
            }
            System.out.println(Arrays.stream(arr).sum());
            System.out.println();
        }
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

    public static long nextLong() throws IOException {
        st.nextToken();
        return (long) st.nval;
    }
}
