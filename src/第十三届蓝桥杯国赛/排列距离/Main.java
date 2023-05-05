package 第十三届蓝桥杯国赛.排列距离;
//康托展开问题
public class Main {
    public static String A_STR="aejcldbhpiogfqnkr";
    public static String B_STR="ncfjboqiealhkrpgd";
    public static int n = 17;
    public static int[] A=new int[50];
    public static int[] B=new int[50];
    public static void main(String[] args) {
        long r1=0,r2=0; //存储当前字符串是全排列中的第几个
        long ts=1,s=1;  //存储阶乘
        for (int i = 0; i <n; i++) {
            A[i+1]=A_STR.charAt(i)-'a'; //将上面字符转数字存储，比较起来方便
            B[i+1]=B_STR.charAt(i)-'a';
            s=ts*=(i+1);//s和ts到这里都是计算17!
        }
        for (int i = 1,k=n; i <=n;i++,k--) {
            int t1=0;//统计A[i]之后小于A[i]的数量
            int t2=0;//统计B[i]之后小于B[i]的数量
            for (int j = i+1; j <=n ; j++) {
                if(A[i]>A[j]){
                    ++t1;
                }
                if(B[i]>B[j]){
                    ++t2;
                }
            }
            ts/=k;  //ts现在就是(n-i)!
            //康托展开
            r1+=t1*ts;//r1+=t1*(n-i)!
            r2+=t2*ts;//r2+=t2*(n-i)!
        }
        //可以认为整个全排列构成一个环，整个环长度为n!，res1和res2只是环上的两个点，
        //从res1转移到res2就有两种情况：
        // 不跨越环首尾到res2，跨越环首尾到res2。这两种情况取个最小值即可
        System.out.println(Math.min(Math.abs(r1-r2),s-Math.abs(r1-r2)));
    }
}
