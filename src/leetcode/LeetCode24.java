package leetcode;
//leetcode24:两两交换链表中的节点
public class LeetCode24 {
    //方法一：迭代法
    //方法二：可以借助堆栈，每次两个两个的入栈出栈就行
    public ListNode swapPairs(ListNode head){
        ListNode listNode = new ListNode(0);
        if(head==null||head.next==null){
            return head;
        }
        listNode.next=head;
        ListNode temp =listNode;
        //每次都交换的是temp后面的两个节点，若temp后面没有节点或者不足2个节点，那就不用执行交换
        while(temp.next!=null&&temp.next.next!=null){
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next=node2;
            node1.next=node2.next;
            node2.next=node1;
            temp=node1;
        }
        return listNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        LeetCode24 code24 = new LeetCode24();
        ListNode listNode = code24.swapPairs(l1);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
