package 代码随想录.链表.设计链表.双向链表;

//双链表：这个写法的头节点和尾节点都是虚拟节点
public class MyLinkedList {
    int size;   //链表中元素数量
    ListNode head;  //虚拟头节点
    ListNode tail;  //尾指针

    //初始化
    public MyLinkedList() {
        this.size=0;
        this.head=new ListNode(0);
        this.tail=new ListNode(0);
        head.next=tail;
        tail.prev=head;
    }

    public int get(int index) {
        if(index<0||index>=size){
            return -1;
        }
        ListNode cur=this.head;
        //判断哪一边遍历时间更短
        if(index>=size/2){
            //从tail向前遍历
            cur=tail;
            for (int i = 0; i <size-index ; i++) {
                cur=cur.prev;
            }
        }else{
            for (int i = 0; i <=index; i++) {
                cur=cur.next;
            }
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        if(index>size){
            return;
        }
        if(index<0){
            index=0;
        }
        size++;
        //找前驱
        ListNode pre=this.head;
        for (int i = 0; i < index; i++) {
            pre=pre.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next=pre.next;
        pre.next.prev=newNode;
        newNode.prev=pre;
        pre.next=newNode;
    }

    public void deleteAtIndex(int index) {
        if(index<0||index>=size){
            return;
        }
        //删除操作
        size--;
        ListNode pre=this.head;
        for (int i = 0; i < index; i++) {
            pre=pre.next;
        }
        pre.next.next.prev=pre;
        pre.next=pre.next.next;
    }
    public void printList(ListNode head){
        ListNode p=head;
        while(p.next!=this.tail){
            System.out.print(p.next.val+" ");
            p=p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
       MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < 10; i++) {
            list.addAtIndex(i,i);
        }
        list.printList(list.head);
        list.addAtIndex(3,333);
        list.printList(list.head);
        list.addAtTail(100);
        list.printList(list.head);

//        list.deleteAtIndex(3);
//        printList(list.head);
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode prev;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }
}
