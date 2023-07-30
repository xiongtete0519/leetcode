package 代码随想录.二叉树.后序遍历;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode145 {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    public static void postorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
        List<Integer> list = postorderTraversal(node1);
        System.out.println("二叉树的后序遍历结果为");
        list.forEach(x -> System.out.print(x + " "));
    }
}
