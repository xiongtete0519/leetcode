package study.递归;

/**
 * 递归：代码简介，但是涉及到的运算随着递归层数的增加会呈指数级增长
 * 斐波那契数列
 */
public class Demo1 {
    public static void main(String[] args) {
        System.out.println(FN(10));
    }
    public static int FN(int n){
        if(n==1||n==2){
            return 1;
        }
        return FN(n-1)+FN(n-2);
    }
}
