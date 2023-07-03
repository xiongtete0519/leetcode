package 代码随想录.链表.环形链表;

import java.util.HashSet;
import java.util.List;

public class Main {
    //遍历链表中的节点并记录下来，如果遇到此前遍历过的节点就说明存在环
    public static ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode p=head;
        while(p!=null){
            if(set.contains(p)){
                return p;
            }else{
               set.add(p);
            }
            p=p.next;
        }
        return null;
    }
    //双指针法
    public static ListNode detectCycle1(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while (true){
            if(fast==null||fast.next==null){
                return null;
            }
            //fast指针每次走两步
            fast=fast.next.next;
            //slow指针每次走一步
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        fast=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node3;
        ListNode listNode = detectCycle(node1);
        ListNode listNode1 = detectCycle1(node1);
        System.out.println(listNode.val);
        System.out.println(listNode1.val);

    }
}
class ListNode {
    public int val;
    public ListNode next;

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
