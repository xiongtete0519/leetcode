package 模拟题.一元三次方程求解;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static double a;
    public static double b;
    public static double c;
    public static double d;
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        a = nextDouble();
        b = nextDouble();
        c = nextDouble();
        d = nextDouble();
        for (int i = -100; i <100 ; i++) {
            double left=i;
            double right=i+1;
            double y1=fun(left);
            double y2=fun(right);
            if(y1==0){
                System.out.printf("%.2f ",left);
            }else if(y1*y2<0){   //x1<x2,且f(x1)*f(x2)<0,则在(x1,x2)之间一定有根
                //二分法求解
                while(right-left>1e-8){
                    double mid=(left+right)/2;
                    if(fun(mid)*fun(right)<=0){
                        left=mid;
                    }else{
                        right=mid;
                    }
                }
                System.out.printf("%.2f ",right);
            }
        }
    }
    public static double fun(double x){
        return a*x*x*x+b*x*x+c*x+d;
    }
    public static double nextDouble() throws IOException {
        st.nextToken();
        return st.nval;
    }
}
