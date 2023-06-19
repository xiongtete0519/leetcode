package leetcode2.L206反转链表;


public class Main {

    //申请一个结点，依次使用头插法将链表的各个结点使用头插法接在新申请的结点后面就行
    //最后返回head->Next刚好指向逆置后的链表
    public static ListNode reverseList(ListNode head) {
        ListNode listNode = new ListNode();
        ListNode p = head;
        ListNode q;
        //头插法
        while (p != null) {
            q = p.next;
            p.next = listNode.next;
            listNode.next = p;
            p = q;
        }
        return listNode.next;
    }

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

        ListNode head = reverseList(node1);
        print(head);
    }

}
