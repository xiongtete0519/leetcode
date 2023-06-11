package 第十三届蓝桥杯国赛.排列距离;
//康托展开问题
public class Main1 {
    public static String A_STR="aejcldbhpiogfqnkr";
    public static String B_STR="ncfjboqiealhkrpgd";
    public static int n = 17;
    public static int[] A=new int[50];
    public static int[] B=new int[50];
    public static void main(String[] args) {
        long r1=0,r2=0; //存储当前字符串是全排列中的第几个
        long ts=1,s=1;  //存储阶乘
        //计算A和B字符串在全排列中的排名
        for (int i = 0; i <n; i++) {
            A[i+1]=A_STR.charAt(i)-'a'; //将上面字符转数字存储，比较起来方便
            B[i+1]=B_STR.charAt(i)-'a';
        }
        for (int i = 1; i <=n; i++) {
            int t1=0;   //统计A[i]之后小于A[i]的数量
            int t2=0;   //统计B[i]之后小于B[i]的数量
            for (int j = i+1; j <=n ; j++) {
                if(A[i]>A[j]){
                    t1++;
                }
                if(B[i]>B[j]){
                    t2++;
                }
            }
            //康托展开
            r1+=t1*fun(n-i);
            r2+=t2*fun(n-i);
        }
        System.out.println(Math.min(Math.abs(r1-r2),fun(17)-Math.abs(r2-r1)));
    }

    //计算阶乘
    public static long fun(int n){
        if(n==0||n==1){
            return 1;
        }else{
            return n*fun(n-1);
        }
    }
}
