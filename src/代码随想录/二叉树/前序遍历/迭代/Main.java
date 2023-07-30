package 代码随想录.二叉树.前序遍历.迭代;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//前序遍历：迭代法
public class Main {
    /**
     * 先加入右孩子，再加入左孩子，这样出栈的时候才是根左右的顺序
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
        List<Integer> list = preorderTraversal(node1);
        list.forEach(x -> System.out.print(x + " "));
    }
}
