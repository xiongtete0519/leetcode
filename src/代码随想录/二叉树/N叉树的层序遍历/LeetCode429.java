package 代码随想录.二叉树.N叉树的层序遍历;

import java.util.*;

/**
 * N叉树的层序遍历，和二叉树层序遍历方法一样
 * 这里在遍历完一层之后，没有左右节点，只有children，
 * 如果有children，那就依次入队列即可
 */
public class LeetCode429 {

    //N叉树的层序遍历:BFS
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<Node> queue = new LinkedList<>();
        if (root == null) {
            return list;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> itemList = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.pollFirst();
                itemList.add(node.val);
                if (node.children == null || node.children.size() == 0) {
                    continue;
                }
                //孩子节点依次入队列
                for (Node child : node.children) {
                    queue.addLast(child);
                }
            }
            list.add(itemList);
        }
        return list;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        List<Node> list1 = Arrays.asList(node2, node3, node4);
        List<Node> list2 = Arrays.asList(node5, node6);
        node1.children = list1;
        node2.children = list2;
        List<List<Integer>> resList = levelOrder(node1);
        resList.forEach(x -> System.out.print(x + " "));
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
