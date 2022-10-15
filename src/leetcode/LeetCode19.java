package leetcode;
//leetcode19:删除链表的倒数第N个结点
public class LeetCode19 {
    public static ListNode removeNthFromEnd(ListNode head,int n){
        ListNode result = new ListNode(0);
        int i=0;
        ListNode p=head;
        ListNode q=head;
        while(p.next!=null){    //最终q是倒数第n个结点的前驱结点，p指向最后一个结点
            p=p.next;
            i++;
            if(i>n){
                q=q.next;
            }
        }
        //删除倒数第n个结点，即q的后继结点。
        if(i<n){
            head=q.next;
        }else{
            q.next=q.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;

        ListNode listNode = removeNthFromEnd(listNode1, 2);
//        ListNode listNode = removeNthFromEnd(listNode1, 2);

        while(listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;while(listNode!=null){
                System.out.println(listNode.val);
                listNode=listNode.next;
            }
        }

    }
}
