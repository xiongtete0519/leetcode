package 代码随想录.二叉树.完全二叉树的节点个数;

import 代码随想录.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode222 {

    //利用层序遍历记录节点个数即可
    public static int countNodes(TreeNode root) {
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
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                res++;
            }
        }
        return res;
    }

    //递归
    public static int countNode1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //左子树节点个数+右子树节点个数+自己
        return countNodes(root.left) + countNodes(root.right) + 1;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        System.out.println(countNodes(node1));
        System.out.println(countNode1(node1));
    }
}
