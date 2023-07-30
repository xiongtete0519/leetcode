package 代码随想录.二叉树.层序遍历.填充每个节点的下个右指针;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 本题依然是层序遍历，只不过在单层遍历的时候记录一下本层的头部节点，
 * 然后在遍历的时候让前一个节点指向本节点就可以了
 * //每一层的最后一个节点都是null
 */
public class LeetCode116 {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            //取出本层的头节点
            Node cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
            for (int i = 1; i < levelSize; i++) {
                Node next = queue.poll();
                if (next.left != null) {
                    queue.add(next.left);
                }
                if (next.right != null) {
                    queue.add(next.right);
                }
                //每一层的第一个节点指向第二个，第二个指向第三个...最后一个指向null
                cur.next = next;
                cur = next;
            }
        }
        return root;
    }

    public static void main(String[] args) {

    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}