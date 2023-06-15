package Offer来了.数据结构.单链表;

public class Node{
     int data;    //数据域
     Node next;      //指针域

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

}