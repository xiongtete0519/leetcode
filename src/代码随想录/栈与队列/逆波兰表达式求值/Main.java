package 代码随想录.栈与队列.逆波兰表达式求值;

import java.util.Deque;
import java.util.LinkedList;

//leetcode150
public class Main {
    /**
     * 使用一个栈存储操作树，从左至右遍历逆波兰表达式
     * 如果遇到操作树，则将操作树入栈
     * 如果遇到运算符，则将两个操作出栈，其中先出栈的是右操作数，后出栈的是做左操作数，
     * 使用运算符对两个操作树进行运算，将运算得到的新操作数入栈
     * 整个逆波兰表达式遍历完毕之后，栈内只有一个元素，该元素即为逆波兰表达式的值
     * @param tokens
     * @return
     */
    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack=new LinkedList<>();
        int len=tokens.length;
        for (String token : tokens) {
            if(isNumber(token)){
                stack.push(Integer.parseInt(token));
            }else{
                //先出战的是右操作树
                int num2=stack.pop();
                //后出战的是左操作数
                int num1=stack.pop();
                switch (token){
                    case "+":
                        stack.push(num1+num2);
                        break;
                    case "-":
                        stack.push(num1-num2);
                        break;
                    case "*":
                        stack.push(num1*num2);
                        break;
                    case "/":
                        stack.push(num1/num2);
                        break;
                    default:
                }
            }
        }
        return stack.pop();
    }
    public static boolean isNumber(String token){
        return !"+".equals(token) && !"-".equals(token) && !"*".equals(token) && !"/".equals(token);
    }

    public static void main(String[] args) {

    }
}
