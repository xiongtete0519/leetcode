package LanQiaoBei.左移右移;

import java.util.*;
import java.util.stream.Collectors;

public class ACCode {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int l=0;//最左临界值
        int r=n+1;//最优临界值
        HashMap<Integer, Integer> map = new HashMap<>();
        //key和value的初始化
        for (int i = 1; i <=n; i++) {
            map.put(i,i);
        }
        for (int i = 0; i <m ; i++) {
            String s = scan.next();
            int num = scan.nextInt();
            if(s.equals("L")){
                //如果是左移，将value赋值为左临界值，再将左临界值自减
                map.put(num,l--);
            }else{
                //如果是右移，则将value赋值为右临界值，并将右边临界值+1
                map.put(num,r++);
            }
        }

        System.out.println(map);
        //将map根据value排序并输出
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList())
                .forEach(x->System.out.print(x+" "));

    }
}
