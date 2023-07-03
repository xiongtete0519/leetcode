package 代码随想录.链表.链表相交;

public class Main {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA=headA;
        ListNode curB=headB;
        //求两个链表的长度
        int lenA=0;
        int lenB=0;
        while(curA!=null){
            lenA++;
            curA=curA.next;
        }
        while(curB!=null){
            lenB++;
            curB=curB.next;
        }
        curA=headA;
        curB=headB;
        if(lenA<lenB){  //让curA为最长链表的头指针
            int temp=lenA;
            lenA=lenB;
            lenB=temp;
            ListNode tempNode=curA;
            curA=curB;
            curB=tempNode;
        }
        int gap=lenA-lenB;
        while(gap>0){
            curA=curA.next;
            gap--;
        }
        //此时两个位于同一起点，遍历两个链表，遇到相同直接返回
        while(curA!=null){
            if(curA==curB){
                return curA;
            }
            curA=curA.next;
            curB=curB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;

        ListNode node11 = new ListNode(10);
        ListNode node21 = new ListNode(9);
        node11.next=node21;
        node21.next=node3;

        ListNode intersectionNode = getIntersectionNode(node1, node11);
        assert intersectionNode != null;
        System.out.println(intersectionNode.val);
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
