package 代码随想录.二叉树.层序遍历;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//二叉树层序遍历
public class LeetCode102 {

    public static List<List<Integer>> res = new ArrayList<>();

    //DFS-递归方式
    public static List<List<Integer>> levelOrder1(TreeNode root) {
        dns(root, 0);
        return res;
    }

    //DFS-递归方式
    public static void dns(TreeNode node, Integer deep) {
        if (node == null) {
            return;
        }
        deep++;
        if (res.size() < deep) {
            //当层级增加时，list的item也增加，利用list的索引值进行层即界定
            List<Integer> item = new ArrayList<>();
            res.add(item);
        }
        res.get(deep - 1).add(node.val);
        dns(node.left, deep);
        dns(node.right, deep);
    }

    //BFS迭代方式-借助队列(重点)
    //需要用一个len记录每一层节点的个数，这样我们出队的时候就只出len个(一层一层出)。
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> itemList = new ArrayList<>();
            int len = queue.size();
            //这里用的是len，因为queue.size是不断变化的
            while (len > 0) {
                TreeNode tmpNode = queue.poll();
                itemList.add(tmpNode.val);
                if (tmpNode.left != null) {
                    queue.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    queue.offer(tmpNode.right);
                }
                len--;
            }
            resList.add(itemList);
        }
        return resList;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        //BFS
        System.out.println("BFS:");
        List<List<Integer>> lists = levelOrder(node1);
        lists.forEach(System.out::println);
        //DFS
        System.out.println("DFS:");
        List<List<Integer>> lists1 = levelOrder1(node1);
        lists1.forEach(System.out::println);
    }
}
