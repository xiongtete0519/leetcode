package java程序员面试宝典.容器.Collections;

import java.util.Collections;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] array={1,7,3,2};
        for (int i = 0; i < array.length; i++) {
            list.add(Integer.valueOf(array[i]));
        }
        Collections.sort(list);
        for (int i = 0; i < array.length; i++) {
            System.out.println(list.get(i));
        }
    }
}
