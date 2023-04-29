package 十三届蓝桥杯国赛.最大公约数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Test {
    static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static int MAX_N=1000010;
    static int[] a=new int[MAX_N];
    static int[] t=new int[MAX_N<<2];
    public static void main(String[] args) throws IOException{
        int n=nextInt();
        int tmp=0;
        for(int i=1;i<=n;i++){
            a[i]=nextInt();
            if(a[i]==1){
                tmp++;
            }
        }
        if(tmp>0){
            System.out.println(n-tmp);
            return;
        }else{
            tmp=n;
        }
        build(1,n,1);
        if(query(1,n,1,1,n)!=1){    //是否有解
            System.out.println(-1);
            return;
        }
        for (int i = 1; i <=n; i++) {   //枚举左端点
            int left=i+1;
            int right=n;
            int mid;
            while(left<right){      //二分法找到使得区间长度最小的右端点
                mid=(left+right)>>1;
                if(query(1,n,1,i,mid)==1){
                    right=mid;
                }else{
                    left=mid+1;
                }
            }
            if(query(1,n,1,i,right)==1){
                tmp=Math.min(tmp,right-i);
            }
        }
        System.out.println(n-1+tmp);
    }
    //构造线段树
    public static void build(int left,int right,int p){
        if(left==right){
            t[p]=a[left];
            return;
        }
        int mid=(left+right)>>1;
        build(left,mid,p<<1);
        build(mid+1,right,p<<1|1);
        t[p]=gcd(t[p<<1],t[p<<1|1]);
    }
    public static int query(int left,int right,int p,int L,int R){
        if(L<=left&&right<=R){//区间覆盖直接返回
            return t[p];
        }
        int mid=(left+right)>>1;
        if(R<=mid){
            return query(left,mid,p<<1,L,R);
        }else if(L>mid){
            return query(mid+1,right,p<<1|1,L,R);
        }else{
            return gcd(query(left,mid,p<<1,L,R),query(mid+1,right,p<<1|1,L,R));
        }
    }

    public static int gcd(int a,int b){
        return b == 0 ? a:gcd(b,a%b);
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
