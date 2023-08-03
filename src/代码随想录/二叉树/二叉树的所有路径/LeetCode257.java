package 代码随想录.二叉树.二叉树的所有路径;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode257 {

    //方法一：深度优先搜索(递归写法)
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, "", res);
        return res;
    }

    public static void dfs(TreeNode root, String path, List<String> res) {
        if (root == null) {
            return;
        }
        //如果是叶子节点，说明找到了一条路径，加入res
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
        } else {
            //如果不是叶子节点，分别遍历它的左右子节点
            dfs(root.left, path + root.val + "->", res);
            dfs(root.right, path + root.val + "->", res);
        }
    }

    //方法二：非递归写法
    public static List<String> binaryTreePaths1(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Object> stack = new Stack<>();
        //当前节点和路径同时入栈
        stack.push(root);
        stack.push(root.val + "");
        while (!stack.isEmpty()) {
            //节点和路径同时出栈
            String path = (String) stack.pop();
            TreeNode node = (TreeNode) stack.pop();
            //如果是根节点，说明找到了一条完整路径，把它加入到集合中
            if (node.left == null && node.right == null) {
                res.add(path);
            }
            //右子节点不为空就把右子节点和路径压栈
            if (node.right != null) {
                stack.push(node.right);
                stack.push(path + "->" + node.right.val);
            }
            //左子节点不为空就把左子节点和路径压栈
            if (node.left != null) {
                stack.push(node.left);
                stack.push(path + "->" + node.left.val);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        List<String> list = binaryTreePaths(node1);
        System.out.println(list);
        System.out.println(binaryTreePaths1(node1));

    }
}
