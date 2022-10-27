package leetcode1;
//二叉树的最小深度
//最小深度是从根节点到最近叶子节点的最短路径上的节点数量
public class LeetCode111 {
    //深度优先搜索，遍历整棵树，记录最小深度
    //对于每一个非叶子节点，只需要分别计算其左右子树的最小叶子节点深度
    public int minDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        int min_depth=Integer.MAX_VALUE;
        if(root.left!=null){
            min_depth=Math.min(minDepth(root.left),min_depth);
        }
        if(root.right!=null){
            min_depth=Math.min(minDepth(root.right),min_depth);
        }
        return min_depth+1;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left=t2;
        t1.right=t3;
        t3.left=t4;
        t3.right=t5;
        LeetCode111 code111 = new LeetCode111();
        System.out.println(code111.minDepth(t1));
    }
}
