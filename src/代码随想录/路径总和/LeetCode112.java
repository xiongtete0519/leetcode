package 代码随想录.路径总和;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode112 {
    //我们不用一个个去加路径和，我们从开始就一个个减去访问的节点，满足就true
    //不满足就回溯
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;   //为空就退出
        }
        //判断叶子节点是否符合
        if (root.left == null && root.right == null && targetSum == root.val) {
            return true;
        }
        //判断左右子树
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    //广度优先搜索
    public static boolean hasPathSum1(TreeNode root, int targetSum) {
        //使用两个队列，分别存储将要遍历的节点和根节点到这些节点的路径和
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> valueQueue = new LinkedList<>();
        if (root == null) {
            return false;
        }
        nodeQueue.offer(root);
        valueQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            Integer value = valueQueue.poll();
            if (node.left == null && node.right == null) {
                if (value == targetSum) {
                    return true;
                }
                continue;
            }
            if (node.left != null) {
                nodeQueue.offer(node.left);
                valueQueue.offer(value + node.left.val);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                valueQueue.offer(value + node.right.val);
            }
        }
        return false;
    }

    public static List<Integer> print(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node3.left = node5;
        node3.right = node6;
        node2.left = node4;
        node4.left = node7;
        node4.right = node8;
        node6.right = node9;
        System.out.println(hasPathSum(node1, 22));
        System.out.println(hasPathSum1(node1, 22));

        System.out.println(print(node1));

    }
}
