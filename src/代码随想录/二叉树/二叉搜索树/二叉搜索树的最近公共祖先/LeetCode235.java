package 代码随想录.二叉树.二叉搜索树.二叉搜索树的最近公共祖先;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 由于是二叉搜索树，所以寻找起来比二叉树简单
 */
public class LeetCode235 {

    /**
     * 从根节点开始遍历，
     * 如果当前节点的值大于p和q的值，说明p和q应该在当前节点的左子树，因此将当前节点移动到它的左子节点
     * 如果当前节点的值小于p和q的值，说明p和q应该在当前节点的右子树，因此将当前节点移动到它的右子节点
     * 如果不满足上述要求，说明当前节点就是分叉点，此时，p和q要么在当前节点的不同的子树中，要么其中一个就是当前节点。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    /**
     * 方法二:我们可以分别求出从根节点到p和q的路径，找路径中那个最后一个相同的节点即可。
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path_P = getPath(root, p);//从根节点到p的路径
        List<TreeNode> path_q = getPath(root, q);//从根节点到q的路径
        TreeNode res = null;
        //最后一个相同的节点，即分叉点就是p个q的最近公共祖先。
        for (int i = 0; i < path_P.size() && i < path_q.size(); i++) {
            if (path_P.get(i) == path_q.get(i)) {
                res = path_P.get(i);
            } else {
                break;
            }
        }
        return res;
    }

    /**
     * 利用二叉搜索树的性质进行遍历
     * 从根节点开始遍历
     * 如果当前节点就是p，那就成功找到了该节点
     * 如果当前节点的值大于p,说明当前节点应该在p的左子树，往左边找
     * 如果当前节点的值小于p,说明当前节点应该在p的右子树，往右边找
     */
    public List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<>();
        TreeNode node = root;
        while (node != target) {
            path.add(node);
            if (target.val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        //将最后一步的target也加入
        path.add(node);
        return path;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(9);
        TreeNode node8 = new TreeNode(3);
        TreeNode node9 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
        LeetCode235 code235 = new LeetCode235();
        TreeNode node = code235.lowestCommonAncestor(node1, node2, node3);
        TreeNode res = code235.lowestCommonAncestor1(node1, node2, node3);
        System.out.println(node.val);
        System.out.println(res.val);
    }
}
