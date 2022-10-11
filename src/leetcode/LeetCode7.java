package leetcode;
//整数反转
public class LeetCode7 {

    public static int reverse(int x) { //用stringbuffer的reverse翻转，负数需要注意一下-位置
        int y=0;
        String s=String.valueOf(x);
        StringBuffer s1 = new StringBuffer(s);
        StringBuffer s2= s1.reverse();
        if(x>0){
            try {   //发生异常说明超出了Integer范围
                y=Integer.parseInt(String.valueOf(s2));
            } catch (NumberFormatException e) {
                return 0;
            }
        }else{
            //将尾部的负号放到首个字符
            String s3 = s2.charAt(s2.length()-1)+s2.substring(0, s2.length() - 1);
            try {   //发生异常说明超出了Integer范围
                y=Integer.parseInt(s3);
            } catch (NumberFormatException e) {
                return 0;
            }
        }
        return y;
    }

    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
        System.out.println(reverse(-123));
//        System.out.println(reverse(1234567899));
    }
}
