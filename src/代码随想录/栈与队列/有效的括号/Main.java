package 代码随想录.栈与队列.有效的括号;

import java.util.*;
//leetcode20:有效的括号
public class Main {
    private static Map<Character,Character> map = new HashMap<Character,Character>(){
        {
            put(')','(');
            put('}','{');
            put(']','[');
        }
    };
    public static boolean isValid(String s) {
        if(s.length()%2==1){
            return false;
        }
        Deque<Character> stack=new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(c=='('||c=='{'||c=='['){
                //如果是左括号则入栈
                stack.push(c);
            }else{
                if(!stack.isEmpty()&&map.get(c)==stack.peek()){
                    stack.pop();    //栈顶元素出栈
                }else{
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("[{()}]()"));
    }
}
