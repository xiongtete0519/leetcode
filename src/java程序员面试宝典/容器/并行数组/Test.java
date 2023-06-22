package java程序员面试宝典.容器.并行数组;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr={1,5,8,3,19,40,6};
        Arrays.parallelSort(arr);
        Arrays.stream(arr).forEach(x-> System.out.println(x+" "));
    }
}
