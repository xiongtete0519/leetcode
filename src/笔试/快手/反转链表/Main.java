package 笔试.快手.反转链表;

public class Main {
    //翻转链表：头插法较为简单
    public static ListNode reverseList(ListNode head) {
        //新引入一个头节点
        ListNode listNode = new ListNode();
        listNode.next = null;
        ListNode p = head;
        while (p != null) {
            ListNode q = p.next;
            p.next = listNode.next;
            listNode.next = p;
            p = q;
        }
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
        ListNode listNode = reverseList(node1);
        print(listNode);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
