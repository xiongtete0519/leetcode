package 蓝桥杯.字符统计;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        //map根据value排序
        LinkedHashMap<Character, Integer> collect = map.entrySet().stream()
                .sorted((o1, o2) -> {
                    return o2.getValue().compareTo(o1.getValue());
                })
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> newValue,   //合并函数
                        LinkedHashMap::new)
                );
//        System.out.println(collect);
        Integer max = collect.entrySet().iterator().next().getValue();
        collect.forEach((key, value) -> {
            if (value.equals(max)) {
                System.out.print(key);
            }
        });

        scan.close();

    }
}
