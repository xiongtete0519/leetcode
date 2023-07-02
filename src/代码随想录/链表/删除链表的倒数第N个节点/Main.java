package 代码随想录.链表.删除链表的倒数第N个节点;

public class Main {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int k=0;
        ListNode listNode = new ListNode();
        listNode.next=head;
        ListNode p=listNode;
        ListNode q=listNode;
        while(p.next!=null){
            p=p.next;
            k++;
            if(k>=n+1){ //n+1是为了找到第n个节点的前驱，方便删除
                q=q.next;
            }
        }
        //此时q节点指向倒数第n个节点的前驱
        q.next=q.next.next;

        return listNode.next;
    }
    public static void print(ListNode head){
       ListNode p=head;
        while(p!=null){
            System.out.print(p.val+" ");
            p=p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        ListNode listNode = removeNthFromEnd(node1, 4);
        print(listNode);
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(){}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
