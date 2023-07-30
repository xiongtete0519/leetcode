package 代码随想录.二叉树.二叉树的右视图;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 依然是层序遍历的解法，在每层遍历的时候把最后一个节点保存下即可
 */
public class LeetCode199 {
    //BFS，保存没层的最后一个节点即可
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return list;
        }
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            //对当前层进行遍历
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.pollFirst();
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
                //保存没层的最后一个节点即为右视图的节点
                if (i == levelSize - 1) {
                    list.add(node.val);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.right = node5;
        List<Integer> list = rightSideView(node1);
        list.forEach(x -> System.out.print(x + " "));
    }
}
