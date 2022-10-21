package leetcode1;

//删除排序链表中的重复元素
public class LeetCode83 {
    public static ListNode deleteDuplicates(ListNode head){
        if(head==null){
            return head;
        }
        ListNode p=head;
        while(p.next!=null){
            if(p.val==p.next.val){
                p.next=p.next.next;
            }else{
                p=p.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        ListNode listNode = deleteDuplicates(l1);
        ListNode.list(listNode);
    }
}
