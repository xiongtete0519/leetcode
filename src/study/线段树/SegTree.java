package study.线段树;

import java.util.Arrays;

public class SegTree {
    public static final int MAX_LEN=1000;

    public static void main(String[] args) {
        int[] arr={1,3,5,7,9,11};
        int size=arr.length;
        int[] tree=new int[MAX_LEN];

        buildTree(arr,tree,0,0,size-1);
        System.out.println("构建树：");
        Arrays.stream(tree).limit(15).forEach(x-> System.out.print(x+" "));
        System.out.println("\n-------------------------------------");
        //修改测试
        updateTree(arr,tree,0,0,size-1,4,6);
        System.out.println("单点修改:arr[4]=6:");
        Arrays.stream(tree).limit(15).forEach(x-> System.out.print(x+" "));
        System.out.println("\n-------------------------------------");
        //查询测试
        System.out.println("区间查询：[2-5]");
        int sum = queryTree(arr, tree, 0, 0, size - 1, 2, 5);
        System.out.println(sum);

    }

    /**
     * 构建树
     * @param arr 原始数组
     * @param tree 线段树数组
     * @param node  当前节点下标
     * @param start
     * @param end
     */
    public static void buildTree(int[] arr, int[] tree, int node, int start, int end){
        if(start==end){//
            tree[node]=arr[start];
        }else{
            int mid=(start+end)/2;//从mid将区间分为两半
            int leftNode=2*node+1;//计算左孩子
            int rightNode=2*node+2;//计算右孩子
            //构建左子树
            buildTree(arr,tree,leftNode,start,mid);
            //构建右子树
            buildTree(arr,tree,rightNode,mid+1,end);
            //子树构建好之后，更新父节点的值
            tree[node]=tree[leftNode]+tree[rightNode];
        }
    }
    /**
     * 单点修改：想要将arr[index]=val，修改tree对应位置的值
     * @param arr
     * @param tree
     * @param node 当前节点下标
     * @param start 当前节点对应区间的左边界
     * @param end   当前节点对应区间的右边界
     * @param index 需要更新节点的下标(arr中的下标)arr[index]=val
     * @param val 修改后的值
     */
    public static void updateTree(int[] arr,int[] tree,int node,int start,int end,int index,int val){
        if(start==end){
            arr[index]=val;
            tree[node]=val;
        }else{
            int mid=(start+end)/2;
            int leftNode=2*node+1;
            int rightNode=2*node+2;
            if(index>=start&&index<=mid){   //要修改的值在左子树中
                updateTree(arr,tree,leftNode,start,mid,index,val);
            }else{  //要修改的值在右子树中
                updateTree(arr,tree,rightNode,mid+1,end,index,val);
            }
            //更新父节点的值
            tree[node]=tree[leftNode]+tree[rightNode];
        }
    }
    //区间查询：查询L-R区间的和
    public static int queryTree(int[] arr,int[] tree,int node,int start,int end,int L,int R){
        if(R<start||L>end){ //要查询的区间不在查询的范围之内
            return 0;
        } else if(L<=start&&end<=R){    //是否区间覆盖，可以直接返回tree[node]
            return tree[node];
        }else if(start==end){   //一直查到了叶子节点
            return tree[node];
        }else{
            int mid=(start+end)/2;
            int leftNode=2*node+1;
            int rightNode=2*node+2;
            //查询左子树
            int sumLeft=queryTree(arr,tree,leftNode,start,mid,L,R);
            //查询右子树
            int sumRight=queryTree(arr,tree,rightNode,mid+1,end,L,R);
            //将左右子树的结果相加即可
            return sumLeft+sumRight;
        }
    }

}
