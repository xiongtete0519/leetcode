package 笔试.快手.删除链表倒数第N个节点;

public class Main {

    public static ListNode deleteNNode(ListNode head, int N) {
        if (head == null) {
            return null;
        }
        ListNode listNode = new ListNode(-1, null);
        listNode.next = head;
        ListNode p = listNode;
        ListNode q = listNode;
        int k = 1;
        while (p.next != null) {
            p = p.next;
            //我们的目的是最终让q指向倒数N+1个节点，方便删除倒数第N个节点
            if (k > N) {
                q = q.next;
            }
            k++;
        }
        //执行删除
        q.next = q.next.next;
        return listNode.next;
    }

    //遍历链表
    public static void print(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode listNode = deleteNNode(node1, 1);
        print(listNode);
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
