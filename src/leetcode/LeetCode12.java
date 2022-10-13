package leetcode;
//leetcode12:整数转罗马数字
public class LeetCode12 {

    private static int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
    private static String[] symbols={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};


    /**
     *为了表示一个给定的整数，我们寻找不超过num的最大符号值，将num减去该符号值，
     * 然后继续寻找不超过num的最大符号值，将该符号拼接在上一个找到的符号之后，循环
     * 直至num为0。最后得到的字符串即为num的罗马数字表示。
     */
    //整数转罗马数字
    public static String intToRoman(int num) {
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];
            while(num>=value){
                num-=value;
                roman.append(symbol);
            }
            if(num==0)
                break;
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
}
