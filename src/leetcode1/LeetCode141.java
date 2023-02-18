package leetcode1;


import java.util.HashSet;

public class LeetCode141 {
    /**
     * 使用哈希表来存储所有已经访问过的节点。每次我们到达一个节点，
     * 如果该节点已经存在于哈希表中，则说明该链表是环形链表，
     * 否则就将该节点加入哈希表中。重复这一过程，直到我们遍历完整个链表即可。
     */
    public static boolean hasCycle(ListNode head) {
        HashSet<ListNode> seen = new HashSet<>();
        while(head!=null){
            if(!seen.add(head)){
                return true;
            }
            head=head.next;
        }
        return false;
    }

    /**
     * 快慢指针
     * 慢指针每次移动一步，快指针每次移动两步，若有环，则两个指针移动会相遇。
     */
    public static boolean hasCycle1(ListNode head) {
        if(head==null||head.next==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while(slow!=fast){
            if(fast==null||fast.next==null){
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node2;
        System.out.println(hasCycle(node1));
        System.out.println(hasCycle1(node1));
    }
}
