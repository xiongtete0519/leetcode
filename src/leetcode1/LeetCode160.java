package leetcode1;

import java.util.HashSet;

/**
 * 相交链表
 */
public class LeetCode160 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode temp=headA;
        while(temp!=null){
            set.add(temp);
            temp=temp.next;
        }
        temp=headB;
        while(temp!=null){
            if(set.contains(temp)){
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(1);


        ListNode n1 = new ListNode(8);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(5);

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(2);

        n1.next=n2;
        n2.next=n3;

        a1.next=a2;
        a2.next=n1;

        b1.next=b2;
        b2.next=b3;
        b3.next=n1;

        ListNode node = getIntersectionNode(a1, a2);
        System.out.println(node.val);
    }
}
