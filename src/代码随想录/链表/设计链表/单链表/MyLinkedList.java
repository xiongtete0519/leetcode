package 代码随想录.链表.设计链表.单链表;
//单链表
public class MyLinkedList {
    int size;//存储链表元素个数
    ListNode head;  //虚拟头节点

    //初始化链表
    public MyLinkedList() {
        size=0;
        head=new ListNode(0);
    }
    //获取第index个节点的数值，注意index从0开始
    public int get(int index) {
        if(index<0||index>=size){
            return -1;
        }
        ListNode p=head;
        for (int i = 0; i <=index; i++) {
            p=p.next;
        }
        return p.val;

    }
    //在链表最前面插入一个节点，等价于在第0个元素前添加
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }
    //在链表的最后插入一个节点，等价于在(末尾+1)个元素前添加
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }
    //在第index个节点之前插入一个节点，如index为0.则说明新插入的节点为链表的新头节点
    //如果index等于链表的长度，则说明是新插入的节点为链表的尾节点
    //如果index大于链表的长度，非法
    public void addAtIndex(int index, int val) {
        if(index>size){
            return;
        }
        if(index<0){
            index=0;
        }
        size++;
        //找到要插入节点的前驱
        ListNode pred=head;
        for (int i = 0; i < index; i++) {
            pred=pred.next;
        }
        ListNode toAdd=new ListNode(val);
        toAdd.next=pred.next;
        pred.next=toAdd;
    }
    //删除第index个节点
    public void deleteAtIndex(int index) {
        if(index<0||index>=size){
            return;
        }
        size--;
        if(index==0){
            head=head.next;
            return;
        }
        ListNode pred=head;
        for (int i = 0; i < index; i++) {
            pred=pred.next;
        }
        pred.next=pred.next.next;
    }
    public static void printList(ListNode head){
        ListNode p=head;
        while(p.next!=null){
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
        printList(list.head);
        list.addAtIndex(3,333);
        printList(list.head);

        list.deleteAtIndex(3);
        printList(list.head);
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val=val;
    }
}
