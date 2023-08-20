package 代码随想录.二叉树.二叉搜索树.二叉搜索树中的插入操作;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode701 {
    //迭代
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;  //遍历的节点
        TreeNode pre = root;
        while (cur != null) {//利用二叉搜索树的性质，小的往左边，大的往右边
            pre = cur;    //保存前一个节点，方便最后的插入
            if (cur.val > val) {
                cur = cur.left;
            } else if (cur.val < val) {
                cur = cur.right;
            }
        }
        if (pre.val > val) {
            pre.left = new TreeNode(val);
        } else {
            pre.right = new TreeNode(val);
        }
        return root;
    }

    //递归
    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null) {//遍历的节点为null,就是要插入的位置，把新插入的节点返回
            return new TreeNode(val);
        }
        if (root.val < val) {
            //这里也实现了父子节点的赋值，下一层将加入节点返回，本层用root.right将其接住
            root.right = insertIntoBST1(root.right, val);
        } else if (root.val > val) {
            root.left = insertIntoBST1(root.left, val);
        }
        return root;
    }

    //层序遍历测试
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

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        LeetCode701 code701 = new LeetCode701();
        TreeNode root = code701.insertIntoBST(node1, 5);
        System.out.println(code701.print(root));

    }
}
