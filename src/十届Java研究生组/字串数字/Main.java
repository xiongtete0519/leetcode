package 十届Java研究生组.字串数字;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<Character,Integer> map = new HashMap<Character,Integer>(){
        {
            put('A',1);
            put('B',2);
            put('C',3);
            put('D',4);
            put('E',5);
            put('F',6);
            put('G',7);
            put('H',8);
            put('I',9);
            put('J',10);
            put('K',11);
            put('L',12);
            put('M',13);
            put('N',14);
            put('O',15);
            put('P',16);
            put('Q',17);
            put('R',18);
            put('S',19);
            put('T',20);
            put('U',21);
            put('V',22);
            put('W',23);
            put('X',24);
            put('Y',25);
            put('Z',26);
        }
    };
    public static void main(String[] args) {
        long res=0;
        String s = "LANQIAO";
//        String s = "AZ";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            res+=(long)map.get(chars[i])*Math.pow(26,chars.length-1-i);
        }
        System.out.println(res);
    }
}
