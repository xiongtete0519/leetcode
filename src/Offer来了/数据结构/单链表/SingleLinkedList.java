package Offer来了.数据结构.单链表;

public class SingleLinkedList {
    private int length; //链表节点的个数
    private Node head;  //链表的头节点

    public SingleLinkedList() {
        this.length=0;
        head=null;
    }
    //插入
    public Object addHead(int obj){
        Node newHead = new Node(obj);
        if(length==0){
            head=newHead;
        }else{
            newHead.next=head;
            head=newHead;
        }
        length++;
        return obj;
    }
    //删除
    public boolean delete(int value){
        if(length==0){
            return false;
        }
        Node current=head;
        Node previous=head;
        while(current.data!=value){
            if(current.next==null){
                return false;
            }else{
                previous=current;
                current=current.next;
            }
        }
        //如果删除的是头节点
        if(current==head){
            head=current.next;
            length--;
        }else{
            //删除的不是头节点
            previous.next=current.next;
            length--;
        }
        return true;
    }
    //查询
    public Node find(int obj){
        Node current=head;
        int tempSize=length;
        while(tempSize>0){
            if(obj==current.data){
                return current;
            }else{
                current=current.next;
            }
            tempSize--;
        }
        return null;
    }

    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        System.out.println(linkedList.addHead(1));
        System.out.println(linkedList.addHead(2));
        System.out.println(linkedList.addHead(3));
        System.out.println(linkedList.head.data);
        System.out.println(linkedList.head.next.data);
        System.out.println(linkedList.find(2));
//        System.out.println(linkedList.addHead(node3));
//        System.out.println(linkedList.find(2));
    }
}

