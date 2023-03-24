package 模拟题.一元三次方程求解;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main1 {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        double a = nextDouble();
        double b = nextDouble();
        double c = nextDouble();
        double d = nextDouble();
        for (double i = -100; i <100 ; i+=0.01) {
            if(Math.abs(a*i*i*i+b*i*i+c*i+d)<0.000001){
                System.out.printf("%.2f ",i);
            }
        }
    }
    public static double nextDouble() throws IOException {
        st.nextToken();
        return st.nval;
    }
}
