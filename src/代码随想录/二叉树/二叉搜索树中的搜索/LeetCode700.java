package 代码随想录.二叉树.二叉搜索树中的搜索;

import 代码随想录.二叉树.TreeNode;

/**
 * 相当于是在二叉搜索树中查找一个值
 * 二叉搜索树是一个有序树
 * 若它的左子树不空，则左子树尚所有结点的值均小于它的根节点的值
 * 若它的右子树不空，则右子树上所有结点的值均大于它的根节点的值
 * 它的左右子树也分别是二叉搜索树
 * <p>
 * 这里可以使用普通二叉树的搜索，不过利用二叉搜索树的性质的话搜索速度更快
 */
public class LeetCode700 {

    //递归
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    //迭代
    public TreeNode searchBST1(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            }
            if (val > root.val) {
                root = root.right;
            }
            if (val < root.val) {
                root = root.left;
            }
        }
        return null;
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
        LeetCode700 code700 = new LeetCode700();
        TreeNode node = code700.searchBST(node1, 2);
        TreeNode treeNode = code700.searchBST1(node1, 2);
        System.out.println(node.val);
        System.out.println(treeNode.val);
    }
}
