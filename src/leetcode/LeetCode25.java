package leetcode;
//leetcode25:K个一组翻转链表
public class LeetCode25 {
    public static  ListNode reverseKGroup(ListNode head,int k){
        ListNode dummy = new ListNode(0, head);
        ListNode prev=dummy;
        while(true){
            //检查剩余节点是否有k个，不足则返回
            ListNode last=prev;
            for (int i = 0; i < k; i++) {
                last=last.next;
                if(last==null){
                    return dummy.next;
                }
            }
            //翻转k个节点(使用类似头插法比较简单)
            ListNode curr=prev.next;
            ListNode p;
            //每次翻转执行k-1次头插
            for (int i = 0; i < k - 1; i++) {
                p=curr.next;
                curr.next=p.next;
                p.next=prev.next;
                prev.next=p;
            }
            prev=curr;  //prev重新指向下一次需要翻转的前一个结点
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        ListNode listNode = reverseKGroup(l1, 2);
        //遍历
        ListNode.list(listNode);
    }
}
