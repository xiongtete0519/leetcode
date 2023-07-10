package 代码随想录.栈与队列.删除字符串中的所有相邻重复项;

import java.util.Deque;
import java.util.LinkedList;
//leetcode1047:删除字符串中的所有相邻重复项
public class Main {
    //利用栈判断
    //每次遍历的时候都和栈顶元素判断，若相同，弹出栈顶元素
    //否则将当前元素入栈
    public static String removeDuplicates(String s) {
        Deque<Character> stack=new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(stack.isEmpty()||stack.peek()!=c){
                stack.push(c);
            }else{
                stack.pop();
            }
        }
        StringBuffer buffer = new StringBuffer();
        while(!stack.isEmpty()){
            buffer.append(stack.pop());
        }
        //最后出战的元素顺序和原来是反的，需要reverse一下
        return buffer.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }
}
