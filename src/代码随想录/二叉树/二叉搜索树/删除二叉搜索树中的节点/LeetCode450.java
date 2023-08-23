package 代码随想录.二叉树.二叉搜索树.删除二叉搜索树中的节点;

import 代码随想录.二叉树.TreeNode;

public class LeetCode450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root;
        TreeNode pre = null;
        //先找到要删除的节点
        while (cur != null) {
            if (cur.val > key) {
                pre = cur;
                cur = cur.left;
            } else if (cur.val < key) {
                pre = cur;
                cur = cur.right;
            } else {
                break;
            }
        }
        if (pre == null) {  //如果搜索树只有头节点
            return deleteOneNode(cur);
        }
        if (pre.left != null && pre.left.val == key) {
            pre.left = deleteOneNode(cur);
        }
        if (pre.right != null && pre.right.val == key) {
            pre.right = deleteOneNode(cur);
        }
        return root;
    }

    //将目标结点(删除结点)的左子树放到目标节点的右子树的最左面节点的左孩子位置上
    //并返回目标节点右孩子为新的根节点
    public TreeNode deleteOneNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            return node.left;
        }
        TreeNode cur = node.right;
        while (cur.left != null) {
            cur = cur.left;
        }
        cur.left = node.left;
        return node.right;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        LeetCode450 code450 = new LeetCode450();
        code450.deleteNode(node1, 3);
    }
}
