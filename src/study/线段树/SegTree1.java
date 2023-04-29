package study.线段树;

import java.util.Arrays;

public class SegTree1 {
    public static int[] arr = {1, 3, 5, 7, 9, 11};
    //线段树数组开到4*n就可以保证不会出现越界访问
    public static int[] tree = new int[4 * arr.length];

    public static void main(String[] args) {
        buildTree(0, 0, arr.length - 1);
        System.out.println("构建树：");
        Arrays.stream(tree).limit(15).forEach(x -> System.out.print(x + " "));
        System.out.println("\n-------------------------------------");
        //修改测试
        updateTree(0, 0, arr.length - 1, 4, 6);
        System.out.println("单点修改:arr[4]=6:");
        Arrays.stream(tree).limit(15).forEach(x -> System.out.print(x + " "));
        System.out.println("\n-------------------------------------");
        //查询测试
        System.out.println("区间查询：[2-5]");
        int sum = queryTree(0, 0, arr.length - 1, 2, 5);
        System.out.println(sum);
    }

    /**
     * 构建树
     *
     * @param node  当前节点
     * @param start start和end都指的是arr的start和end
     * @param end
     */
    public static void buildTree(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            int leftNode = 2 * node + 1;
            int rightNode = 2 * node + 2;
            //构建左子树
            buildTree(leftNode, start, mid);
            //构建右子树
            buildTree(rightNode, mid + 1, end);
            //子树构建好之后，更新父节点的值
            tree[node] = tree[leftNode] + tree[rightNode];
        }
    }

    /**
     * 单点修改
     *
     * @param node  当前节点
     * @param start 当前节点对应区间的左边界
     * @param end   当前节点对应区间的右边界
     * @param index 需要更新节点的下标
     * @param val   修改后的值
     */
    public static void updateTree(int node, int start, int end, int index, int val) {
        if (start == end) {
            arr[index] = val; //修改arr数组的值
            tree[node] = val; //修改线段树中对应节点的值
        } else {
            int mid = (start + end) / 2;  //区间一分为二
            int leftNode = 2 * node + 1;
            int rightNode = 2 * node + 2;
            if (index >= start && index <= mid) {   //要修改的值在左子树中
                updateTree(leftNode, start, mid, index, val);
            } else {  //要修改的值在右子树中
                updateTree(rightNode, mid + 1, end, index, val);
            }
            //更新父节点的值
            tree[node] = tree[leftNode] + tree[rightNode];
        }
    }

    //区间查询，查询区间[L-R]的和
    public static int queryTree(int node, int start, int end, int L, int R) {
//        System.out.println("start="+start);
//        System.out.println("end="+end);
        if (R < start || L > end) {//查询的区间不在范围之内
            return 0;
        } else if (L <= start && end <= R) {//是否区间覆盖，要查询的区间刚好被包含
            //直接返回tree[node],不用再往下查,tree[node]就是该子区间的和
            return tree[node];
        } else if (start == end) {    //一直查到了叶子节点
            return tree[node];
        } else {
            int mid = (start + end) / 2;
            int leftNode = 2 * node + 1;
            int rightNode = 2 * node + 2;
            //查询左子树
            int sumLeft = queryTree(leftNode, start, mid, L, R);
            //查询右子树
            int sumRight = queryTree(rightNode, mid + 1, end, L, R);
            //将左右子树的结果相加即可
            return sumLeft + sumRight;
        }
    }
}
