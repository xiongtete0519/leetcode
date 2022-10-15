package leetcode;

//leetcode21:合并两个有序链表
public class LeetCode21 {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;
        ListNode listNode = mergeTwoLists(l1, l4);
//        ListNode listNode = mergeTwoLists(null, null);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
            while (listNode != null) {
                System.out.println(listNode.val);
                listNode = listNode.next;
            }
        }

    }
}
