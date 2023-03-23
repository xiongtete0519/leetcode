package 蓝桥杯.数位排序;


import java.util.*;
import java.util.stream.Collectors;

public class Main {
    //返回位数和
    public static Integer sum(int number){
        int [] nums=new int[String.valueOf(number).length()];
        int temp=number;
        for (int i = 0; i < nums.length; i++) {
            nums[i]=temp%10;
            temp=(temp-nums[i])/10;
        }
        return Arrays.stream(nums).sum();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int m=scan.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            //value存位数之和
            map.put(i,sum(i));
        }
//        HashMap<Integer, Integer> collect = map.entrySet()
//                .stream()
//                .sorted((o1, o2) -> o1.getValue().compareTo(o2.getValue()))
//                .collect(Collectors.toMap(Map.Entry::getKey,
//                        Map.Entry::getValue,
//                        (oldValue, newValue) -> newValue,
//                        LinkedHashMap::new));
        List<Integer> collect = map.entrySet()
                .stream()
                .sorted((o1, o2) -> o1.getValue().compareTo(o2.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("排序之后的key:"+collect);
//        collect.entrySet().forEach(System.out::println);
        System.out.println(collect.get(m - 1));
    }
}
