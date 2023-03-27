package 模拟题.卡牌;

import java.io.*;

public class Main {
    static BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static int n;   //n种卡牌
    static long m;  //空白牌的数量
    static int[] a; //每种卡牌的数量
    static int[] b; //每种牌最多手写bi张
    public static void main(String[] args) throws IOException {
        String[] str = in.readLine().split(" ");
        n=Integer.parseInt(str[0]);
        m=Long.parseLong(str[1]);
        a=new int[n];
        b=new int[n];
        String[] s = in.readLine().split(" ");
        for (int i = 0; i <n; i++) {
            a[i]=Integer.parseInt(s[i]);
        }
        String[] st = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            b[i]=Integer.parseInt(st[i]);
        }
        int l=0;
        int r=n;
        while(l<r){
            int mid=(l+r+1)>>1; //防止死循环，答案目标在右边
            if(check(mid)){
                l=mid;
            }else{
                r=mid-1;
            }
        }
        out.println(l);
        out.flush();
        in.close();

    }
    public static boolean check(int mid){
        long value=m;
        for (int i = 0; i < n; i++) {
            if(a[i]>mid){   //无需补充卡牌，还有余量，让mid继续变大
                continue;
            }
            if(a[i]+b[i]<mid){//当前卡牌补充最大数量的卡牌依然不满足，说明mid不对，直接返回false,让mid减小
                return false;
            }
            if(value>=mid-a[i]){
                //所有类型的牌如果可以用空白牌(value)补充完，那么就返回true,如果当前有一种牌不能补充完，返回false
                value-=(mid-a[i]);
            }else{
                return false;
            }
        }
        return true;
    }
}
