package 代码随想录.二叉树.二叉树的层序遍历II;

import 代码随想录.二叉树.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层序遍历
 * 从叶子节点所在层到根节点所在曾，逐层从左向右遍历
 */
public class LeetCode107 {

    //依然是BFS，不过要求倒着输出
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> itemList = new ArrayList<>();
            int len = queue.size();
            //这里用的是len，因为queue.size是不断变化的
            while (len > 0) {
                TreeNode tmpNode = queue.poll();
                itemList.add(tmpNode.val);
                if (tmpNode.left != null) {
                    queue.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    queue.offer(tmpNode.right);
                }
                len--;
            }
            resList.add(itemList);
        }
        //对原先的层序遍历结果进行翻转即可
        List<List<Integer>> list = new ArrayList<>();
        for (int i = resList.size() - 1; i >= 0; i--) {
            list.add(resList.get(i));
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
        node3.left = node4;
        node3.right = node5;
        //BFS
        System.out.println("BFS:");
        List<List<Integer>> lists = levelOrder(node1);
        lists.forEach(System.out::println);
    }
}
