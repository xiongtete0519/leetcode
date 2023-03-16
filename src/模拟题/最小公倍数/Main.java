package 模拟题.最小公倍数;


//a*b=最大公约数*最小公倍数
public class Main {
    public static void main(String[] args) {
        int count=0;
        int num=2021;
        for (int i = 1; i <=2021 ; i++) {
            //求i与2021的最小公倍数=a*b/最大公约数
            int tmp = num * i / gcb(num, i);
            if(tmp==4042){
                count++;
            }
        }
        System.out.println(count);
    }
    //求a和b的最大公约数 gcb(a,b)=gcb(b,a%b),a>b
    public static int gcb(int a,int b){
        if(b==0){
            return a;
        }
        return gcb(b,a%b);
    }
}
