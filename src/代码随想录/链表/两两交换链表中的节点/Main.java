package 代码随想录.链表.两两交换链表中的节点;
//两两交换链表中的节点：leetcode24
public class Main {
    public static ListNode swapPairs(ListNode head) {
        ListNode listNode = new ListNode();
        listNode.next=head;
        ListNode cur=listNode;

        while(cur.next!=null&&cur.next.next!=null){
            ListNode temp=cur.next;
            ListNode temp1=cur.next.next.next;
            cur.next=cur.next.next;
            cur.next.next=temp;
            temp.next=temp1;
            cur=cur.next.next;
        }
        return listNode.next;
    }
    public static ListNode swapPairs1(ListNode head){
        ListNode listNode = new ListNode();
        if(head==null||head.next==null){
            return head;
        }
        listNode.next=head;
        ListNode temp=listNode;
        //每次交换的都是temp后的两个节点，若temp后不够2个或者没有节点就不用交换
        while(temp.next!=null&&temp.next.next!=null){
            ListNode node1=temp.next;
            ListNode node2=temp.next.next;
            temp.next=node2;
            node1.next=node2.next;
            node2.next=node1;
            temp=node1;
        }
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
        ListNode listNode = swapPairs(node1);
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
