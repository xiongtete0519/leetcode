package 国赛刷题挑战.钟表;

public class Main {
    public static void main(String[] args) {
        double sd,fd,md;
        for (double m = 0; m <60 ; m++) {
            md=360*m/60;
            for(double f=0;f<60;f++){
                fd=360*f/60;
                fd+=6*m/60;
                for(double s=0;s<=6;s++){
                    sd=360*s/12;
                    sd+=30*(f*60+m)/3600;

                    double A=Math.abs(fd-sd);
                    A=Math.min(A,360-A);
                    double B=Math.abs(fd-md);
                    B=Math.min(B,360-B);
                    if(A==2*B){
//                        System.out.println(s+""+f+""+m);
                        System.out.print(s);
                        System.out.print(f);
                        System.out.print(m);
                        System.out.println();
                    }
                }
            }
        }
    }
}
