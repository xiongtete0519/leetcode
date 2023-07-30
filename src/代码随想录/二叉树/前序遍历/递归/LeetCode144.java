package 代码随想录.二叉树.前序遍历.递归;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode144 {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    public static void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
        List<Integer> list = preorderTraversal(node1);
        System.out.println("二叉树的前序遍历结果为");
        list.forEach(x -> System.out.print(x + " "));
    }
}
