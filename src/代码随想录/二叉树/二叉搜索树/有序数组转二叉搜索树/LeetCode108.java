package 代码随想录.二叉树.二叉搜索树.有序数组转二叉搜索树;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//要求二叉搜索树高度平衡
public class LeetCode108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        //左闭右闭
        return sortedArrayToBST1(nums, 0, nums.length - 1);
    }

    //递归。左闭右开
    public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left >= right) {
            return null;
        }
        if (right - left == 1) {
            return new TreeNode(nums[left]);
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        return root;
    }

    //递归：左闭右闭
    public TreeNode sortedArrayToBST1(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        //选取中间位置左边的数字作为根节点
//        int mid=left+((right-left)>>1);
        int mid = (left + right) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        //递归左子树
        root.left = sortedArrayToBST1(nums, left, mid - 1);
        //递归右子树
        root.right = sortedArrayToBST1(nums, mid + 1, right);
        return root;
    }

    //写个前序测试下
    public List<Integer> print(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        LeetCode108 code = new LeetCode108();
        TreeNode root = code.sortedArrayToBST(nums);
        System.out.println(code.print(root));
    }
}
