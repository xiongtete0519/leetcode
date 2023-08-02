package 代码随想录.二叉树.翻转二叉树;

import 代码随想录.二叉树.TreeNode;
import 代码随想录.二叉树.层序遍历.LeetCode102;

import java.util.ArrayDeque;
import java.util.List;

/**
 * 翻转二叉树:将每个节点的左右孩子交换即可
 */
public class LeetCode226 {

    //递归方式
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    //BFS:层序遍历的时候交换左右孩子
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //size是记录每层的元素个数，下面出队列也就只出size个
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //交换node的左右孩子
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println("翻转之前");
        List<List<Integer>> list = LeetCode102.levelOrder(node1);
        list.forEach(System.out::println);
//        System.out.println("翻转之后-递归法:");
//        TreeNode node = invertTree(node1);
//        List<List<Integer>> list1 = LeetCode102.levelOrder(node1);
//        list1.forEach(System.out::println);


        System.out.println("翻转之后-BFS:");
        invertTree(node1);
        List<List<Integer>> list2 = LeetCode102.levelOrder(node1);
        list2.forEach(System.out::println);

    }
}
