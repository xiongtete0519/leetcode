package 代码随想录.二叉树.最大二叉树;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length);
    }

    //构造二叉树一般都是前序遍历(根左右)
    public TreeNode constructMaximumBinaryTree(int[] nums, int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex < 1) { //没有元素了
            return null;
        }
        if (rightIndex - leftIndex == 1) {    //只有一个元素
            return new TreeNode(nums[leftIndex]);
        }
        int maxIndex = leftIndex; //最大值所在的位置
        int maxVal = nums[maxIndex];  //最大值
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        //根据maxIndex划分左右子树
        root.left = constructMaximumBinaryTree(nums, leftIndex, maxIndex);
        root.right = constructMaximumBinaryTree(nums, maxIndex + 1, rightIndex);
        return root;
    }

    public List<List<Integer>> print(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode654 code654 = new LeetCode654();
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode node = code654.constructMaximumBinaryTree(nums);
        List<List<Integer>> tree = code654.print(node);
        System.out.println(tree);
    }
}
