package 代码随想录.二叉树.二叉树的层平均值;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的层平均值：给定一个非空二叉树，返回一个由每层节点平均值组成的数组
 */
public class LeetCode637 {

    //层次遍历，对没层的节点数值取平均值并保存即可
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return list;
        }
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double levelSum = 0.0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.pollFirst();
                levelSum += node.val;
                if (node.left != null) {
                    queue.offerLast(node.left);
                }
                if (node.right != null) {
                    queue.offerLast(node.right);
                }
            }
            list.add(levelSum / levelSize);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        List<Double> list = averageOfLevels(node1);
        list.forEach(x -> System.out.print(x + " "));
    }
}
