package 十三届蓝桥杯国赛.最大公约数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
//AC:线段树+二分
public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static int MAXN=1000010;
    public static int[] arr=new int[MAXN];
    public static int[] tree=new int[MAXN<<2];//4n

    public static void main(String[] args)throws IOException {
        int n=nextInt();
        int tmp=0;
        for (int i = 0; i <n; i++) {
            arr[i]=nextInt();
            if(arr[i]==1){
                tmp++;
            }
        }
        if(tmp>0){  //有1的话可以直接得出结果
            System.out.println(n-tmp);
            return;
        }else{
            tmp=n;
        }
        //构造线段树
        buildTree(0,0,n-1);
        if(queryTree(0,0,n-1,0,n-1)!=1){
            System.out.println(-1);
            return;
        }
        for(int i=0;i<n;i++){   //枚举左端点
            int left=i+1;
            int right=n-1;
            int mid;
            while(left<right){  //二分法枚举出右端点
                mid=(left+right)>>1;
                if(queryTree(0,0,n-1,i,mid)==1){
                    right=mid;
                }else{
                    left=mid+1;
                }
            }
            if(queryTree(0,0,n-1,i,right)==1){
                //tmp最终保留的是满足有解的最小区间[i-right]
                //区间长度为right-i+1,但是我们要的是全部执行gcd变成1的操作次数,所以我right-i
                tmp=Math.min(tmp,right-i);
            }
        }
        //tmp表示变一个1出来的最少操作次数，然后再加上将剩下的n-1个数变成1就是最后的结果了
        System.out.println(n-1+tmp);
    }
    //构建线段树
    public static void buildTree(int node,int start,int end){
        if(start==end){
            tree[node]=arr[start];
        }else{
            int mid=(start+end)>>1;
            int leftNode=2*node+1;
            int rightNode=2*node+2;
            //构建左子树
            buildTree(leftNode,start,mid);
            //构建右子树
            buildTree(rightNode,mid+1,end);
            //子树构建号之后，更新父节点的值
            tree[node]=gcd(tree[leftNode],tree[rightNode]);
        }
    }
    //区间查询
    public static int queryTree(int node,int start,int end,int L,int R){
        if(L<=start&&end<=R){   //区间覆盖那就直接返回
            return tree[node];
        }
        int mid=(start+end)/2;
        int leftNode=2*node+1;
        int rightNode=2*node+2;
        if(R<=mid){//查询左子树
            return queryTree(leftNode,start,mid,L,R);
        }else if(L>mid){    //查询右子树
            return queryTree(rightNode,mid+1,end,L,R);
        }else{  //左右子树结果合并
            int leftGcd=queryTree(leftNode,start,mid,L,R);
            int rightGcd=queryTree(rightNode,mid+1,end,L,R);
            return gcd(leftGcd,rightGcd);
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        return gcd(min, max % min);
    }
    public static int nextInt() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }
}
