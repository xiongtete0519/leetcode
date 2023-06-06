package 国赛复习.最大公约数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

//AC:线段树+二分法
public class Test1 {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static final int MAXN=100010;
    public static int[] arr=new int[MAXN];      //原始数组
    public static int[] tree=new int[MAXN<<2];//MAXN*4 线段树数组
    public static void main(String[] args) throws IOException{
        int n=nextInt();
        int count=0;
        for (int i = 0; i <n ; i++) {
            arr[i]=nextInt();
            if(arr[i]==1){
                count++;
            }
        }
        if(count>0){
            System.out.println(n-count);
            return;
        }
        int tmp=n;
        //构造线段树
        buildTree(0,0,n-1);
        //查询是否无解
        if(queryTree(0,0,n-1,0,n-1)!=1){
            System.out.println(-1);
            return;
        }
        //左端点固定，二分枚举右端点
        for (int i = 0; i <n; i++) {//枚举左端点
            int left=i+1;
            int right=n-1;
            //二分法枚举右端点
            while(left<right){
                int mid=(left+right)>>1;
                if(queryTree(0,0,n-1,i,mid)==1){
                    right=mid;
                }else{
                    left=mid+1;
                }
            }
            if(queryTree(0,0,n-1,i,right)==1){
                //区间长度为right-left+1,但是执行gcd的操作次数为right-left
                tmp=Math.min(tmp,right-i);
            }
        }
        System.out.println(tmp+n-1);
//        buildTree(0,0,n-1);
//        updateTree(0,0,n-1,2,8);
//        Arrays.stream(arr).limit(3).forEach(x->{
//            System.out.print(x+" ");
//        });
//        System.out.println();
//        Arrays.stream(tree).limit(5).forEach(x->{
//            System.out.print(x+" ");
//        });
    }
    //构建线段树  start和end是线段树每个节点对应的区间
    public static void buildTree(int node, int start, int end) {
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
            //左右子树构建好了之后，更新父节点的值
            tree[node]=gcd(tree[leftNode],tree[rightNode]);
        }
    }
    //区间查询
    public static int queryTree(int node,int start,int end,int L,int R){
        if(L<=start&&end<=R){   //区间覆盖，直接返回
            return tree[node];
        }
        int mid=(start+end)>>1;
        int leftNode=2*node+1;
        int rightNode=2*node+2;
        if(R<=mid){ //查询左子树
            return queryTree(leftNode,start,mid,L,R);
        }else if(L>mid){    //查询右子树
            return queryTree(rightNode,mid+1,end,L,R);
        }else{  //相交，左右子树结果合并
            int leftGcd=queryTree(leftNode,start,mid,L,R);
            int rightGcd=queryTree(rightNode,mid+1,end,L,R);
            return gcd(leftGcd,rightGcd);
        }
    }
    //单点修改(仅测试，与本题无关)
    public static void updateTree(int node,int start,int end,int index,int val){
        if(start==end){
            arr[index]=val;
            tree[node]=val;
        }else{
            int mid=(start+end)>>1;
            int leftNode=node*2+1;
            int rightNode=node*2+2;
            if(index>=start&&index<=mid){   //要修改的值在左子树
                updateTree(leftNode,start,mid,index,val);
            }else{
                //要修改的值在右子树
                updateTree(rightNode,mid+1,end,index,val);
            }
            //修改父节点的值
            tree[node]=gcd(tree[leftNode],tree[rightNode]);
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
