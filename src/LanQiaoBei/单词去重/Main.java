package LanQiaoBei.单词去重;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * 单词去重：由于要去重，用Set,由于要维护加入的顺序，
 * 使用LinkedHashSet
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (int i = 0; i <n ; i++) {
            String words = scan.next();
            set.add(words);
        }
        //遍历输出
        set.forEach(System.out::println);
        scan.close();
    }
}
