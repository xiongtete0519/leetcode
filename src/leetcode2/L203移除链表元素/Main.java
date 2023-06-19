package leetcode2.L203移除链表元素;

public class Main {
    public static ListNode removeElements(ListNode head,int val){
        //添加一个虚拟的头节点，就不用考虑删除头节点的情况了
        ListNode listNode = new ListNode();
        listNode.next=head;
        head=listNode;
        ListNode p=head;
        while(p.next!=null){
           if(p.next.val==val){
               p.next=p.next.next;
           }else{
               p=p.next;
           }
        }
        return head.next;
    }
    public static ListNode listInsert(ListNode head,ListNode node){
        ListNode p=head;
        while(p.next!=null){
            p=p.next;
        }
        p.next=node;
        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);
        listInsert(head,node2);
        listInsert(head,node3);
        listInsert(head,node4);
        listInsert(head,node5);
        listInsert(head,node6);
        listInsert(head,node7);

        head=removeElements(head,6);

    }
}
class ListNode{
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
