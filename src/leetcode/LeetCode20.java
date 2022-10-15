package leetcode;

import java.util.*;

//leetcode20:有效的括号
public class LeetCode20 {
    private static Map<Character,Character> map = new HashMap<Character,Character>(){{
        put(')','(');
        put('}','{');
        put(']','[');
    }};

    public static boolean isValid(String s){
        if(s.length()%2==1)
            return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='('||c=='{'||c=='['){ //如果是左括号，则入栈
                stack.push(c);
            }else{//否则，就和栈顶元素相比较
                if(!stack.empty()&&map.get(c)==stack.peek()){   //如果和栈顶元素左右匹配
                    stack.pop();//栈顶元素出栈
                }else{
                    return false;
                }
            }
        }
        if(stack.empty()){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        System.out.println(isValid("{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("){"));
    }
}
