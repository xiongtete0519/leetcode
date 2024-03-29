package 代码随想录.二叉树.二叉树的最近公共祖先;

import 代码随想录.二叉树.TreeNode;

/**
 * 最近公共祖先
 * 左右子树都不为空，那根就是公共祖先
 */
public class LeetCode236 {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        //后序遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {    //未找到节点p或q
            return null;
        } else if (left == null && right != null) {  //找到一个节点
            return right;
        } else if (left != null && right == null) {
            return left;
        } else {  //左右子树都不为空，根就是公共祖先
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
        TreeNode node = lowestCommonAncestor(node1, node2, node3);
        System.out.println(node.val);
    }
}
