package 代码随想录.链表.移除链表元素;

import 代码随想录.链表.ListNode;

public class Main {
    public static ListNode removeElements(ListNode head, int val) {
        //增加一个头节点
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

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        ListNode listNode = removeElements(listNode1, 2);
        System.out.println(listNode.val);


    }
}
