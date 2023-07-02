package 代码随想录.链表.翻转链表;

import java.util.List;

public class Main {
    public ListNode reverseList(ListNode head) {
        //增加一个虚拟头节点
        ListNode listNode = new ListNode();
        listNode.next=null;
        ListNode p=head;
        while(p!=null){
            ListNode q=p.next;
            p.next=listNode.next;
            listNode.next=p;
            p=q;
        }
        return listNode.next;
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
