package 代码随想录.字符串.反转字符串II;

public class Main {
    public static String reverseStr(String s, int k) {
        StringBuffer res = new StringBuffer();
        int start=0;
        int length = s.length();
        while(start<length){
            StringBuffer temp = new StringBuffer();
            //找到k和2k的位置
            int firstK= Math.min(start + k, length);
            int secondK= Math.min(start + 2 * k, length);
            //无论start所处位置，至少会反转一次
            temp.append(s.substring(start,firstK));
            res.append(temp.reverse());
            // 如果firstK到secondK之间有元素，这些元素直接放入res里即可。
            if(firstK<secondK){
                res.append(s.substring(firstK,secondK));
            }
            start+=2*k;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s="abcdefg";
        int k=2;
        System.out.println(reverseStr(s, k));
    }
}
