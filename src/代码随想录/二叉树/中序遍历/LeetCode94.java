package 代码随想录.二叉树.中序遍历;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode94 {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    public static void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
        List<Integer> list = inorderTraversal(node1);
        System.out.println("二叉树的中序遍历结果为");
        list.forEach(x -> System.out.print(x + " "));
    }
}
