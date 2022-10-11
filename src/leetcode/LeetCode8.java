package leetcode;
//leetcode8:字符串转化整数
public class LeetCode8 {
    public static int myAtoi(String s) {
        StringBuffer result = new StringBuffer();
        String str = s.trim();  //删除首尾空格
        if(str.equals("")) return 0;    //空字符串直接返回0
        char first = str.charAt(0);//取删除首尾空格后的第一个字符
        //判断第一个字符是否是正负号或者数字
        if(first=='+'||first=='-'||(first>='0'&&first<='9')){
            result.append(first);
        }else{  //如果第一个字符不是有效数字字符，直接返回
            return 0;
        }
        for (int i = 1; i < str.length(); i++) {//从第2个字符开始
            if(str.charAt(i)>='0'&&str.charAt(i)<='9'){ //是数字就直接加入
                result.append(str.charAt(i));
            }else{
                break;
            }
        }
        if(result.toString().equals("+")||result.toString().equals("-")||result.toString().equals("")){
            return 0;
        }
        //转换成整型
        try {
            int Z = Integer.parseInt(result.toString());
            return Z;
        } catch (NumberFormatException e) { //发生异常说明超出了范围，截断到范围内
            return str.charAt(0)=='-'?Integer.MIN_VALUE:Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
//        System.out.println(myAtoi("    -42   "));
//        System.out.println(myAtoi("-91283472332"));
//        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi(".1"));
    }
}
