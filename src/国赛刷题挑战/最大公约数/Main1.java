package 国赛刷题挑战.最大公约数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main1 {
    public static int n;
    public static int MAXN=100010;
    public static int[] arr=new int[MAXN];
    public static int[] tree=new int[MAXN<<2];//4*MAXN
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        n=nextInt();
        int countOne=0;
        for (int i = 0; i <n; i++) {
            arr[i]=nextInt();
            if(arr[i]==1){
                countOne++; //统计1的个数
            }
        }
        if(countOne>0){
            System.out.println(n-countOne);
            return;
        }
        int tmp=n;
        //构造线段树
        buildTree(0,0,n-1);
        //查看是否有解
        if(queryTree(0,0,n-1,0,n-1)!=1){
            System.out.println(-1);
            return;
        }
        for (int i = 0; i <n; i++) {
            int left=i;
            int right=n-1;
            int mid;
            while(left<right){  //二分法找右端点
                mid=(left+right)>>1;
                if(queryTree(0,0,n-1,i,mid)==1){
                    right=mid;
                }else{
                    left=mid+1;
                }
            }
            if(queryTree(0,0,n-1,i,right)==1){
                tmp=Math.min(tmp,right-i);
            }
        }
        System.out.println(tmp+n-1);
    }
    //构造线段树
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
            //子树构建好之后，更新父节点的值
            tree[node]=gcd(tree[leftNode],tree[rightNode]);
        }
    }
    //区间查询
    public static int queryTree(int node,int start,int end,int L,int R){
        if(L<=start&&end<=R){
            return tree[node];
        }
        int mid=(start+end)/2;
        int leftNode=2*node+1;
        int rightNode=2*node+2;
        if(R<=mid){ //查询左子树
            return queryTree(leftNode,start,mid,L,R);
        }else if(L>mid){    //查询右子树
            return queryTree(rightNode,mid+1,end,L,R);
        }else{//区间相交左右子树结果合并
            int leftGcd=queryTree(leftNode,start,mid,L,R);
            int rightGcd=queryTree(rightNode,mid+1,end,L,R);
            return gcd(leftGcd,rightGcd);
        }

    }
    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        return gcd(min,max%min);
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
    public static int binarySearch(int[] a,int left,int right,int value){
        int mid=(left+right)>>1;
        if(a[mid]==value){
            System.out.println("left="+left);
            System.out.println("right="+right);
            return mid;
        }
        if(a[mid]<value){
            return binarySearch(a,mid+1,right,value);
        }else{
            return binarySearch(a,left,mid,value);
        }
    }
}
