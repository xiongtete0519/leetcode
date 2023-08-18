package 代码随想录.二叉树.二叉搜索树.二叉搜索数的最小绝对差;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode530 {
    //性质：二叉搜索树的中序遍历结果是递增有序的
    public static int getMinimumDifference(TreeNode root) {
        //先用中序遍历求出递增序列
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        //开始计算有序数组的最小绝对差：这个只在相邻的元素之间产生
        int min = Integer.MAX_VALUE;
        int[] arr = res.stream().mapToInt(Integer::valueOf).toArray();
        int len = arr.length;
        for (int i = 0, j = i + 1; i < len && j < len; i++, j++) {
            min = Math.min(min, Math.abs(arr[i] - arr[j]));
        }
        return min;
    }

    //递归
    TreeNode pre;//记录上一个遍历的结点
    int result = Integer.MAX_VALUE;

    public int getMinimumDifference1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traversal(root);
        return result;
    }

    public void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);   //左
        if (pre != null) {          //中
            //二叉搜索树的中序遍历本来就是有序的，这里可不用计算绝对值
            result = Math.min(result, Math.abs(root.val - pre.val));
        }
        pre = root;
        traversal(root.right);  //右
    }


    public static void main(String[] args) {
        LeetCode530 code530 = new LeetCode530();
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        System.out.println(getMinimumDifference(node1));
        System.out.println(code530.getMinimumDifference1(node1));
    }
}
