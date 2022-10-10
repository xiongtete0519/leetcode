package leetcode;

import java.util.ArrayList;

//Z字形变换
public class LeetCode6 {
    /**
     * 字符串s是以Z字形为顺序存储的字符串，目标是按行打印
     * 设numRows行字符串分别为s1,s2...sn,容易发现：按顺序遍历字符串s时，每个字符C在Z字形中对应
     * 的行索引先从s1增大到sn,再从sn减小到s1，如此反复。
     * 因此，模拟这个行索引的变化，在遍历s中把每个字符填到正确的行即可。
     * numRows为几，就有几行。
     */
    public static String convert(String s, int numRows) {
        if(numRows<2)
            return s;
        ArrayList<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) { //集合里面是numRows个StringBuilder
            rows.add(new StringBuilder());
        }
        int i=0;
        int flag=-1;//是否转向的标志
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);  //把每个字符加入对应的list
            if(i==0||i==numRows-1)  //只有在第一行和最后一行才会转向
                flag=-flag;     //在达到Z字形转折点时，执行反向
            i+=flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
    }
}
