package 代码随想录.二叉树.平衡二叉树;

import 代码随想录.二叉树.TreeNode;

//平衡二叉树：每个节点的左右子树的高度差的绝对值不超过1
public class LeetCode110 {

    //方法一：自顶向下 O(n^2)
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            //左右子树高度差不超过1&&左右子树都是平衡二叉树
            return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    //计算二叉树的高度
    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //递归计算左子树的高度
        int leftHeight = getHeight(root.left);
        //递归计算右子树的高度
        int rightHeight = getHeight(root.right);
        //左子树高度+右子树高度+根节点高度即为整个树的高度
        return Math.max(leftHeight, rightHeight) + 1;
    }

    //方法二：自底向上O(n)
    public static boolean isBalanced1(TreeNode root) {
        return getHeight1(root) > 0;
    }

    public static int getHeight1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight1(root.left);
        int rightHeight = getHeight1(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        node4.right = node7;
        System.out.println("二叉树的高度:" + getHeight(node1));
        System.out.println("是否是平衡二叉树-自顶向下:" + isBalanced(node1));
        System.out.println("是否是平衡二叉树-自底向上:" + isBalanced1(node1));
    }
}
