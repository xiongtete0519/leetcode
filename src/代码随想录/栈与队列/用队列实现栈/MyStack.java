package 代码随想录.栈与队列.用队列实现栈;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 入栈操作时，首选获得入栈前的元素个数n，然后将元素入队到队列，再将队列的前n个元素(即除了新入栈的元素之外的全部元素)
 * 依次出队并入队到队列，此时队列的前端的元素即为新入栈的元素，且队列的前端和后端分别对应栈顶和栈底。
 */
public class MyStack {

    Queue<Integer> queue;
    public MyStack() {
        queue=new LinkedList<>();
    }
    
    public void push(int x) {
        int n=queue.size();
        queue.offer(x);
        for (int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}