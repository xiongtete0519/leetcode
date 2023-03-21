package 模拟题.递增三元组;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        long count=0;
        for (int i = 0; i <n ; i++) {
            A[i]=nextInt();
        }
        for (int i = 0; i <n ; i++) {
            B[i]=nextInt();
        }
        for (int i = 0; i <n ; i++) {
            C[i]=nextInt();
        }
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        int p=0;
        int q=0;
        for (int i = 0; i <n ; i++) {
            while(p<n&&A[p]<B[i]){
                p++;
            }
            while(q<n&&C[q]<=B[i]){
                q++;
            }
            count+=(long)p*(n-q);
        }
        System.out.println(count);
        //超时
//        for (int i = 1; i <=n ; i++) {
//            for (int j = 1; j <=n ; j++) {
//                for (int k = 1; k <=n ; k++) {
//                    if(A[i]<B[j]&&B[j]<C[k]){
//                        count++;
//                    }
//                }
//            }
//        }
    }
    public static int nextInt() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }
}
