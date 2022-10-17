package leetcode;
//leetcode23:合并k个升序链表
public class LeetCode23 {
    //合并k个升序链表
    public  ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0){
            return null;
        }
        ListNode list = lists[0];
        for (int i = 1; i < lists.length; i++) {
            ListNode listNode = mergeTwoLists(list, lists[i]);
            list=listNode;
        }
        return list;
    }
    //合并两个升序链表
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);    //临时头结点
        ListNode r = head;  //临时头结点的工作指针，始终指向链表最后一个结点
        ListNode p = list1; //list1工作指针
        ListNode q = list2; //list2工作指针
        while (p != null && q != null) {    //逐个比较并拼接再r指针后面
            if (p.val < q.val) {    //将p链入r的后面
                r.next = p;
                r = p;
                p = p.next;
            } else {                //将q链入r的后面
                r.next = q;
                r = q;
                q = q.next;
            }
        }
        //此时p已经为空，直接把q以及q的后续结点都链入r
        while (q != null) {
            r.next = q;
            r = q;
            q = q.next;
        }
        //此时q已经为null,直接把p以及后续结点都链入r
        while (p != null) {
            r.next = p;
            r = p;
            p = p.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(5);
        l1.next=l2;
        l2.next=l3;

        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l4.next=l5;
        l5.next=l6;

        ListNode l7 = new ListNode(2);
        ListNode l8 = new ListNode(6);
        l7.next=l8;
        LeetCode23 leet = new LeetCode23();
        ListNode[] lists={l1,l4,l7};
        ListNode listNode = leet.mergeKLists(lists);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;

        }
    }
}
