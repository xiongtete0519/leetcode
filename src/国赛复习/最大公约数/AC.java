package 国赛复习.最大公约数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
//AC:线段树+二分
public class AC {
    public static int MAXN=100010;
    public static int[] arr=new int[MAXN];
    public static int[] tree=new int[MAXN<<2];//4n
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int n=nextInt();
        int count=0;
        for (int i =0; i <n ; i++) {
            arr[i]=nextInt();
            if(arr[i]==1){
                count++;
            }
        }
        if(count>1){
            System.out.println(n-count);
            return;
        }else{
            count=n;
        }
        //构造线段树
        buildTree(0,0,n-1);
        if(queryTree(0,0,n-1,0,n-1)!=1){    //是否无解
            System.out.println(-1);
            return;
        }
        for (int i = 0; i <n; i++) {//枚举左端点
            int left=i;
            int right=n-1;
            while(left<right){  //二分法枚举右端点
                int mid=(left+right)>>1;
                if(queryTree(0,0,n-1,i,mid)==1){
                    right=mid;
                }else{
                    left=mid+1;
                }
            }
            if(queryTree(0,0,n-1,i,right)==1){
                //区间:[i-right]
                //区间长度为right-i+1,但是我们要的是全部执行gcd变成1的操作次数，所以为right-i
                count=Math.min(count,right-i);
            }
        }
        System.out.println(n-1+count);

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
            //子树构建好了之后，更新父节点的值
            tree[node]=gcd(tree[leftNode],tree[rightNode]);
        }
    }
    //区间查询
    public static int queryTree(int node,int start,int end,int L,int R){
        if(L<=start&&end<=R){   //区间覆盖可以直接返回
            return tree[node];
        }
        int mid=(start+end)/2;
        int leftNode=2*node+1;
        int rightNode=2*node+2;
        if(R<=mid){ //查询左子树
            return queryTree(leftNode,start,mid,L,R);
        }else if(L>mid){ //查询右子树
            return queryTree(rightNode,mid+1,end,L,R);
        }else{  //左右子树结果合并
            int leftGcd=queryTree(leftNode,start,mid,L,R);
            int rightGcd=queryTree(rightNode,mid+1,end,L,R);
            return gcd(leftGcd,rightGcd);
        }
    }
    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        int max=Math.max(a,b);
        int min=Math.min(a,b);
        return gcd(min,max%min);
    }
    public static int nextInt() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }
}
