package 代码随想录.二叉树.层序遍历.二叉树的最小深度;

import 代码随想录.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最小深度
 * 层序遍历：当左右孩子节点都为空时达到
 */
public class LeetCode111 {
    //
    public static int minDepth(TreeNode root) {
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            depth++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                //层序遍历到某个节点的左右孩子都为空时直接结束
                if (node.left == null && node.right == null) {
                    return depth;
                }
            }
        }
        return depth;
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
        System.out.println("二叉树的最小深度为:" + minDepth(node1));
    }
}
