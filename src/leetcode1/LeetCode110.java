package leetcode1;
//平衡二叉树
public class LeetCode110 {
    public boolean isBalanced(TreeNode root){
        if(root==null){
            return true;
        }else{
            //如果左右子树的高度差不超过1，再分别递归地遍历左右子节点，
            //并判断左子树和右子树是否平衡
            return Math.abs(height(root.left)-height(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right);
        }
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }else{
            return Math.max(height(root.left),height(root.right))+1;
        }
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
        LeetCode110 code110 = new LeetCode110();
        System.out.println(code110.isBalanced(t1));
    }
}
