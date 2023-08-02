package 代码随想录.二叉树.对称二叉树;

import 代码随想录.二叉树.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode101 {
    //递归实现
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        //比较左子树和右子树
        return dfs(root.left, root.right);
    }

    public static boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        //递归比较左子树的左孩子和右子树的右孩子
        //左子树的右孩子 和 右子树的左孩子
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }

    //队列实现
    public static boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        //将根节点的左右孩子放入队列中
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            //从队列中取出两个节点，再比较这两个节点
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            //将左节点的左孩子，右节点的右孩子放入队列
            queue.offer(left.left);
            queue.offer(right.right);
            //将左节点的右孩子，右节点的左孩子放入队列
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println(isSymmetric(node1));
        System.out.println(isSymmetric1(node1));
    }
}
