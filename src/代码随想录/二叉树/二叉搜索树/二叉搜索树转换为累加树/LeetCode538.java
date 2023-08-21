package 代码随想录.二叉树.二叉搜索树.二叉搜索树转换为累加树;

import 代码随想录.二叉树.TreeNode;

import java.util.*;

/**
 * 题目要求我们将每个节点的值修改为原来的节点值加上所有大于它的节点值之和
 * 我们可以利用右中左的方式(反中序遍历)遍历该二叉搜索树，记录过程中的节点值之和，
 * 并不断更新当前遍历到的节点的节点值，即可得到题目要求的类家属
 */
public class LeetCode538 {
    int sum = 0;

    //递归法
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right); //右
            sum += root.val;        //中
            root.val = sum;
            convertBST(root.left);  //左
        }
        return root;
    }

    //写个层序测试
    public List<Integer> print(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                res.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }

    //BST的中序遍历结果是递增数组，我们反中序遍历的结果就是递减数组
    //迭代法：反中序遍历(右根左)，遍历的时候不断求累计和来更新当前节点即可
    public TreeNode convertBST1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        int preSum = 0; //记录上一个节点的累加值，初始的时候给个0，让第一个节点和0加
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            cur.val += preSum;    //更新当前节点的值
            preSum = cur.val;     //更新从后向前的累加和
            cur = cur.left;
        }
        return root;
    }

    //反中序
    public TreeNode convertBST2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        int preSum = 0;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.right;
            } else {
                cur = stack.pop();
                cur.val += preSum;
                preSum = cur.val;
                cur = cur.left;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(3);
        TreeNode node9 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.right = node8;
        node3.left = node6;
        node3.right = node7;
        node7.right = node9;
        LeetCode538 code = new LeetCode538();
//        TreeNode root = code.convertBST(node1);
//        System.out.println(code.print(root));

//        TreeNode root1 = code.convertBST1(node1);
//        System.out.println(code.print(root1));

        TreeNode root2 = code.convertBST2(node1);
        System.out.println(code.print(root2));
    }
}
