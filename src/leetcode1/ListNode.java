package leetcode1;
//leetcode2：两数相加
public class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val=val;
    }
    ListNode(int val, ListNode next){
        this.val=val;
        this.next=next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        //当作存储结果的头结点
        ListNode listNode = new ListNode(0);
        ListNode listNode1=listNode;
        //进位
        int carry=0;
        while (l1!=null||l2!=null){
            int x;
            int y;
            x=l1!=null?l1.val:0;
            y=l2!=null?l2.val:0;

            //填入结点中的值
            int value=(x+y+carry)%10;
            //申请一个新节点
            listNode1.next=new ListNode(value);
            //结点入链
            listNode1=listNode1.next;
            //给下一位的进位
            carry=(x+y+carry)>=10?1:0;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        if(carry>0){//如果最高位还有一个进位，就再申请一个结点
            listNode1.next=new ListNode(carry);
        }
        return listNode.next;
    }
    //遍历单链表
    public static void list(ListNode listNode){
        while(listNode!=null){
            System.out.print(listNode.val+" ");
            listNode=listNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode1.next=listNode2;
        listNode2.next=listNode3;

        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);
        listNode4.next=listNode5;
        listNode5.next=listNode6;

        ListNode listNode = addTwoNumbers(listNode1, listNode4);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
