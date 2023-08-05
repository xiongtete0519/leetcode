package 代码随想录.二叉树.左叶子之和;

import 代码随想录.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//通过父节点判断是否是左叶子
public class LeetCode404 {
    //迭代法 前序
    public static int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null && node.left.left == null && node.left.right == null) {
                res += node.left.val;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }

    //迭代法 层序遍历
    public static int sumOfLeftLeaves1(TreeNode root) {
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && node.left.left == null && node.left.right == null) {
                    res += node.left.val;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }

    //递归
    public static int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //当前节点的左子树满足条件的和
        int leftValue = sumOfLeftLeaves2(root.left);
        //当前节点的右子树满足条件的和
        int rightValue = sumOfLeftLeaves2(root.right);
        int midValue = 0;
        //如果当前节点有新的左叶子节点
        if (root.left != null && root.left.left == null && root.left.right == null) {
            midValue = root.left.val;
        }
        int sum = midValue + leftValue + rightValue;
        return sum;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println(sumOfLeftLeaves(node1));
        System.out.println(sumOfLeftLeaves1(node1));
        System.out.println(sumOfLeftLeaves2(node1));
    }
}
