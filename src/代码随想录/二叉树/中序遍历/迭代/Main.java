package 代码随想录.二叉树.中序遍历.迭代;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历
 * 基本都是一路向左，如果当前节点不为空就入栈
 * 如果当前节点为空，从栈中弹出一个元素，指向右孩子继续一路向左
 */
public class Main {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {          //访问到最底层
                stack.push(cur);
                cur = cur.left;         //左  一路向左
            } else {
                cur = stack.pop();      //从栈里弹出的数据就是要处理的数据
                result.add(cur.val);    //中
                cur = cur.right;        //右   左孩子已经为空了，看看右孩子
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
        List<Integer> list = inorderTraversal(node1);
        System.out.println("二叉树的中序遍历结果为");
        list.forEach(x -> System.out.print(x + " "));
    }
}
