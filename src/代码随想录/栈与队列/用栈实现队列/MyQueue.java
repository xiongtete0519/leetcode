package 代码随想录.栈与队列.用栈实现队列;

import java.util.Deque;
import java.util.LinkedList;

//leetcode232.用栈实现队列

/**
 * 将一个栈当作输入栈，用于压入push传入的数据；另一个栈当作输出栈，用于pop和peek操作
 * 每次pop或peek时，若输出栈为空则将输入栈的全部数据一次弹出并压入输出栈，这样输出栈
 * 从栈顶往栈底的顺序就是队列从队首往队尾的顺序。
 */
public class MyQueue {
    Deque<Integer> inStack; //输入栈
    Deque<Integer> outStack;//输出栈
    public MyQueue() {
        inStack=new LinkedList<>();
        outStack=new LinkedList<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if(outStack.isEmpty()){
            in2out();
        }
        return outStack.pop();
    }

    public int peek() {
        if(outStack.isEmpty()){
            in2out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty()&&outStack.isEmpty();
    }
    //将输入栈的内容弹出，全部压入输出栈，这样刚好逆序了一下
    private void in2out(){
        while(!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
    }
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < 10; i++) {
            myQueue.push(i+1);
        }
        System.out.println(myQueue.peek());
        System.out.println(myQueue.empty());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());

    }
}
