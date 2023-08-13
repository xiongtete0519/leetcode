package 代码随想录.二叉树.二叉搜索树.验证二叉搜索树;

import 代码随想录.二叉树.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode98 {
    //递归
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 判断子树的值是否都在(l,r)范围内，如果不在，直接返回false
     * 如果满足，继续递归子树是否满足，假设当前根节点的值为node.val
     * 那么在递归左子树的时候边界条件为(lower,node.val),上届为node.val
     * 在递归右子树的时候边界条件为(node.val,upper),下届为node.val
     */
    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

    //利用性质：二叉搜索树的中序遍历是递增序列
    public boolean isValidBST1(TreeNode root) {
        long inorder = Long.MIN_VALUE;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.poll();
            //如果中序遍历得到的节点的值小于等于前一个inorder,说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        LeetCode98 code = new LeetCode98();
        System.out.println(code.isValidBST(node1));
        System.out.println(code.isValidBST1(node1));
    }
}
